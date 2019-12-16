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

@Component
public class ReservacionRowMapper implements RowMapper {

	
	public List<EstadoMesa> mapRowEstadoMesa(List<Map<String, Object>> rows){
		List<EstadoMesa> estadomesas = new ArrayList<EstadoMesa>();
		for(Map<String, Object> row: rows) {
			
			int cestadomesa = Integer.parseInt(row.get("CESTADOMESA").toString());
			String emdescripcion = row.get("EMDESCRIPCION").toString();
			EstadoMesa i = new EstadoMesa(cestadomesa,emdescripcion);
			estadomesas.add(i);
		}
		return estadomesas;
	}
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
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
