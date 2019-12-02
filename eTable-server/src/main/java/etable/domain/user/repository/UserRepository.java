package etable.domain.user.repository;

import java.util.List;

import etable.domain.user.model.User;

public interface UserRepository {

	User crearUsuario(User user);
	User actualizarUsuario(User user);
	List<User> getUsuarios();
	boolean eliminarUsuarioById(int id);
}
