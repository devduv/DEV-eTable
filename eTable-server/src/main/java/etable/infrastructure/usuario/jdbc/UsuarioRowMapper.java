package etable.infrastructure.usuario.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import etable.domain.user.model.User;
import etable.domain.user.model.UserDTO;

@Component
public class UsuarioRowMapper {

	public List<User> mapRowUsuario(List<Map<String, Object>> rows){
		List<User> users = new ArrayList<User>();
		
		for(Map<String, Object> row: rows) {
			int cusuario = Integer.parseInt(row.get("CUSUARIO").toString()); 
			String nickname = row.get("NICKNAME").toString();
			int ctipousuario = Integer.parseInt(row.get("CTIPOUSUARIO").toString()); 
			String usnombres = row.get("USNOMBRE").toString();
			String usapellidos = row.get("USAPELLIDOS").toString();
			boolean estado = Integer.parseInt(row.get("ESTADO").toString()) == 1 ? true : false;
			User user = new User(cusuario, nickname, usnombres, usapellidos, estado, ctipousuario);
			users.add(user);
		}
		return users;
	}
	
	public List<UserDTO> mapRowUsuarioDTO(List<Map<String, Object>> rows){
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		for(Map<String, Object> row: rows) {
			int cusuario = Integer.parseInt(row.get("CUSUARIO").toString()); 
			String nickname = row.get("NICKNAME").toString();
			String tiponombre = row.get("TIPONOMBRE").toString(); 
			String usnombres = row.get("USNOMBRE").toString();
			String usapellidos = row.get("USAPELLIDOS").toString();
			boolean estado = Integer.parseInt(row.get("ESTADO").toString()) == 1 ? true : false;
			UserDTO user = new UserDTO(cusuario, nickname, usnombres, usapellidos, estado, tiponombre);
			users.add(user);
		}
		return users;
	}
}
