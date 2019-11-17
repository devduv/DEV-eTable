package etable.infrastructure.security.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import org.springframework.stereotype.Component;

import etable.domain.security.model.Authentication;
import etable.web.constants.querys.UserQuery;

@Component
public class AuthenticationRowMapper implements RowMapper {
	
	
	public List<Authentication> mapRow(List<Map<String, Object>> rows) {
		List<Authentication> authentication = new ArrayList<Authentication>();
		for(Map<String, Object> row: rows){
			String cusuario = row.get(UserQuery.CUSUARIO).toString();
			String nickname = row.get(UserQuery.NICKNAME).toString();
			String password = row.get(UserQuery.PASSWORD).toString();
			
			Authentication distribucion= new Authentication(Integer.parseInt(cusuario), nickname, password);
            authentication.add(distribucion);
        }
		return authentication;
	}

	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}
}
