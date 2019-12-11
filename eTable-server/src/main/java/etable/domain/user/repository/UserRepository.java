package etable.domain.user.repository;

import java.util.List;

import etable.domain.cliente.model.Cliente;
import etable.domain.user.model.User;
import etable.domain.user.model.UserDTO;

public interface UserRepository {

	User crearUsuario(User user, String password);
	User editUser(User user);
	List<UserDTO> getUsuarios();
	User getUsuarioByAuthentication(String nickname, String password);
	boolean eliminarUsuarioById(int id);
	User getUsuarioById(int id);
	boolean deleteUser(int id);
	Cliente crearCliente(User user, Cliente cliente);
	Cliente getClienteById(int id);
	List<Cliente> getClientes();
	Cliente editCliente(Cliente cliente);
}
