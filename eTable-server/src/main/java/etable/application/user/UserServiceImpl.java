package etable.application.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import etable.domain.user.model.User;
import etable.domain.user.repository.UserRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User crearNuevoUsuario(User user) {
		return repository.crearUsuario(user);
	}

	@Override
	public User actualizarUsuario(User user) {
		return this.repository.actualizarUsuario(user);
	}

	@Override
	public List<User> getUsuarios() {
		return repository.getUsuarios();
	}

	@Override
	public boolean eliminarUsuarioById(User user) {
		return repository.eliminarUsuarioById(user.getCusuario());
	}

}
