package etable.infrastructure.usuarios.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import etable.domain.usuarios.model.TipoUsuario;

@Component
public class UsuariosRowMapper implements RowMapper {

	public List<TipoUsuario> mapRowTipoUsuario(List<Map<String, Object>> rows) {
		List<TipoUsuario> list = new ArrayList<TipoUsuario>();
		for(Map<String, Object> row: rows) {
			int ctipousuario = Integer.parseInt(row.get("CTIPOUSUARIO").toString()); 
			String tiponombre = row.get("TIPONOMBRE").toString();
			String tipodescripcion = row.get("TIPODESCRIPCION").toString();
			TipoUsuario tu = new TipoUsuario(ctipousuario, tiponombre, tipodescripcion);
			list.add(tu);
		}
		return list;
	}
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
