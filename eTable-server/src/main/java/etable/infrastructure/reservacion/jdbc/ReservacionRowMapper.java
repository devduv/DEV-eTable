package etable.infrastructure.reservacion.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import etable.domain.cliente.model.Cliente;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.PerfilMesa;
import etable.domain.reservacion.model.Reservacion;

@Component
public class ReservacionRowMapper implements RowMapper {

	
	
	public List<Cliente> getIdCliente(List<Map<String, Object>> rows){
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		for(Map<String, Object> row: rows) {
			int ccliente = Integer.parseInt(row.get("CCLIENTE").toString());
			int dni = Integer.parseInt(row.get("DNI").toString());
			int cusuario = Integer.parseInt(row.get("CUSUARIO").toString());
			String email = row.get("EMAIL").toString();
			String phone = row.get("PHONE").toString();
			String date = row.get("DATE").toString();
			Cliente i = new Cliente(ccliente,dni,cusuario, email,phone,date);
			cliente.add(i);
		}
		return cliente;
	}
	
	public List<Reservacion> getReservacionesbyId(List<Map<String, Object>> rows){
		List<Reservacion> reservacion = new ArrayList<Reservacion>();
		
		for(Map<String, Object> row: rows) {
			
			int creserva = Integer.parseInt(row.get("CRESERVA").toString());
			int ccliente = Integer.parseInt(row.get("CCLIENTE").toString());
			int cestado = Integer.parseInt(row.get("CESTADO").toString());
			String comentario;
			comentario =" ";
			if(row.get("COMENTARIO")!=null){
				 comentario = row.get("COMENTARIO").toString();
			}
			 
			String fecha = row.get("FECHA").toString();
			String hora = row.get("HORA").toString();
			int cantidad = Integer.parseInt(row.get("CANTIDAD").toString());
			boolean confirmada = Integer.parseInt(row.get("CONFIRMADA").toString()) == 1 ? true : false;
				
					Reservacion i = new Reservacion(creserva,ccliente,cestado, comentario ,fecha,hora,cantidad,confirmada);
					reservacion.add(i);
		
		
		
		}
			return reservacion;
		
	}
	

	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
