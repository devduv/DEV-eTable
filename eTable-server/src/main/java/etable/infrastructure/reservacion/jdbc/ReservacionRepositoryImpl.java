package etable.infrastructure.reservacion.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import etable.domain.cliente.model.Cliente;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.PerfilMesa;
import etable.domain.mesa.repository.EstadoMesaRepository;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.repository.ReservacionRepository;
import etable.domain.user.model.User;
import etable.web.constants.querys.Query;

@Component
public class ReservacionRepositoryImpl implements ReservacionRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReservacionRowMapper row;


	public Reservacion crearReservacion(Reservacion reservacion) {

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
	public boolean anularReservacion(int id)  {
	/*	String query = 	"UPDATE " + Query.table_mesa +
	" SET NOMBREMESA = ? , CPERFILMESA = ? , CESTADOMESA = ? WHERE CMESA = ?";
	int update = this.jdbcTemplate.update(query, 
				mesa.getNombremesa(),
				mesa.getCperfilmesa(), 
				mesa.getCestadomesa(), 
				mesa.getCmesa());
		System.out.print("update");
		System.out.print(update);
		if(update == 1) {
			return true;
		} */
				return false;
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
	

	
}
