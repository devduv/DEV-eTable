package etable.infrastructure.pefilmesa.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import etable.domain.perfilmesa.model.PerfilMesa;

@Component
public class PerfilMesaRowMapper implements RowMapper{

	public List<PerfilMesa> mapRowConfigSistema(List<Map<String, Object>> rows){
		 List<PerfilMesa> perfiles = new ArrayList<PerfilMesa>();
		for(Map<String, Object> row: rows) {
			int cperfilmesa = Integer.parseInt(row.get("CPERFILMESA").toString());
			String pmnombre = row.get("PMNOMBRE").toString();
			String pmdescripcion = row.get("PMDESCRIPCION").toString();
			int pmcapacidad = Integer.parseInt(row.get("PMCAPACIDAD").toString());
			boolean pmcompuesta = Integer.parseInt(row.get("PMCOMPUESTA").toString()) == 1 ? true : false;
			
			PerfilMesa perfilmesa = new PerfilMesa(cperfilmesa, pmnombre, pmdescripcion, pmcapacidad, pmcompuesta);
			perfiles.add(perfilmesa);
		}
		return perfiles;
	}
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
