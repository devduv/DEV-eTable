package etable.application.user;

import java.util.List;

import etable.domain.user.model.User;

public interface UserService {

	User crearNuevoUsuario(User user);
	User actualizarUsuario(User user);
	List<User> getUsuarios();
	boolean eliminarUsuarioById(User user);
}
