package etable.application.user;

import java.util.List;

import etable.domain.cliente.model.Cliente;
import etable.domain.user.model.User;
import etable.domain.user.model.UserDTO;

public interface UserService {

	User crearNuevoUsuario(User user);
	User actualizarUsuario(User user);
	List<UserDTO> getUsuarios();
	User getUsuarioByAuthentication(User user);
	boolean eliminarUsuarioById(User user);
	User getUsuarioById(int id);
	
	Cliente crearCliente(User user , Cliente cliente);
}
