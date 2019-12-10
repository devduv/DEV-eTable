package etable.infrastructure.mesa.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import etable.domain.mesa.model.Mesa;

@Component
public class MesaRowMapper implements RowMapper {

	public List<Mesa> mapRowMesa(List<Map<String, Object>> rows){
		List<Mesa> mesas = new ArrayList<Mesa>();
		for(Map<String, Object> row: rows) {
			int cmesa = Integer.parseInt(row.get("CMESA").toString());
			int cperfilmesa = Integer.parseInt(row.get("CPERFILMESA").toString());
			int cestadomesa = Integer.parseInt(row.get("CESTADOMESA").toString());
			String nombreMesa = row.get("NOMBREMESA").toString();
			Mesa i = new Mesa(cmesa,cperfilmesa,cestadomesa, nombreMesa);
			mesas.add(i);
		}
		return mesas;
	}
	
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
