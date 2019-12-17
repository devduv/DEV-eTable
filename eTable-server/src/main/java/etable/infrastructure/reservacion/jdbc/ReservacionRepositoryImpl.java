package etable.infrastructure.reservacion.jdbc;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.cliente.model.Cliente;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.model.ReservacionDTO;
import etable.domain.reservacion.model.ReservacionDTOCli;
import etable.domain.reservacion.repository.ReservacionRepository;
import etable.web.constants.querys.Query;

@Component
public  class ReservacionRepositoryImpl implements ReservacionRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReservacionRowMapper row;

	

	public Reservacion crearReservacion(Reservacion reservacion) {
		System.out.println(reservacion.toString());
		String insertQuery = "insert into " + Query.table_reservacion
				+ "(CCLIENTE,CESTADO,COMENTARIO,FECHA,HORA,CANTIDAD,CONFIRMADA) values (?, ?, ?,?, ?, ?,?)";
		int success = this.jdbcTemplate.update(insertQuery,reservacion.getCcliente(), reservacion.getCestado(),
				reservacion.getComentario(), reservacion.getFecha(), reservacion.getHora(),reservacion.getCantidad(), 
				reservacion.isConfirmada());
		if (success >= 0) {
			return reservacion;
		}
		return null;

	}


	@Override
	public Cliente obtenerClientebyUsuario(int cusuario) {
		String findCliente = Query.selectFromWhere(Query.table_clientes, "CUSUARIO", cusuario);
		List<Cliente> cliente = this.row.getIdCliente(this.jdbcTemplate.queryForList(findCliente));
		if (cliente.size() > 0) {
			return cliente.get(0);
		}
		return null;
	}

	public Reservacion getReservacionById(int id) {
		String Reservacion = Query.selectFromWhere(Query.table_reservacion, "CRESERVA", id);
		List<Reservacion> rsvc = this.row.getReservacionesbyId(this.jdbcTemplate.queryForList(Reservacion));
		if (rsvc.size() > 0) {
			return rsvc.get(0);
		}
		return null;
		
	}
	


	
	@Override
	public List<Reservacion> listReservacionesbyId(int id) {
		String query = Query.selectFromWhere(Query.table_reservacion, "CCLIENTE", id);
		
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<Reservacion> reservacion = row.getReservacionesbyId(rows);
		if (reservacion.size() > 0) {
			return reservacion;
		}
		return null;
	}



	@Override
	public List<ReservacionDTO> listReservacionesbyIdDTO(int id) {

		String query = "SELECT * FROM TBRESERVACION AS M  INNER JOIN TBESTADORESERVACION AS N ON M.CESTADO = N.CESTADO " +
				" WHERE CCLIENTE = " + id;
		

		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<ReservacionDTO> reservaciones = row.getReservacionesbyIdDTO(rows);
		return reservaciones ;
	}

	@Override
	public boolean anularReservacion(int id)  {
		Reservacion rv = getReservacionById(id);
	System.out.print(rv);
		String query = 	"UPDATE " + Query.table_reservacion +
	" SET CESTADO = ?  WHERE CRESERVA = ?";
	int update = this.jdbcTemplate.update(query, 4 , rv.getCreserva());
		
		if(update == 1) {
			return true;
		} 
				return false;
			}


	@Override
	public List<ReservacionDTOCli> listReservacionesDTO() {
		String query = "SELECT * FROM TBRESERVACION AS M INNER JOIN TBESTADORESERVACION AS N ON M.CESTADO = N.CESTADO INNER JOIN tbclientes AS C ON M.CCLIENTE = C.CCLIENTE INNER JOIN tbusuarios AS U ON C.CUSUARIO = U.CUSUARIO "; 
		

		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<ReservacionDTOCli> reservaciones = row.getReservacionesDTO(rows);
		return reservaciones ;
	}


	
}
