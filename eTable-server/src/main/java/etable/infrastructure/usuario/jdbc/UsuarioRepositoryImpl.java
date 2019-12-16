package etable.infrastructure.usuario.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import etable.domain.cliente.model.Cliente;
import etable.domain.cliente.model.ClienteDTO;
import etable.domain.user.model.User;
import etable.domain.user.model.UserDTO;
import etable.domain.user.repository.UserRepository;
import etable.web.constants.querys.Query;

@Component
public class UsuarioRepositoryImpl implements UserRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UsuarioRowMapper row;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User crearUsuario(User user, String password) {
		List<User> list = foundNickname(user.getNickname());
		if(list.size() > 0) {
			return null;
		} else { 
			final String passwordHash = this.passwordEncoder.encode(password);
			final String query = Query.insert_usuario;
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps =
							connection.prepareStatement(query, new String[] {"id"});
						ps.setString(1, user.getNickname());
						ps.setString(2, passwordHash);
						ps.setInt(3, user.getCtipousuario());
						ps.setString(4, user.getUsnombres());
						ps.setString(5, user.getUsapellidos());
						ps.setBoolean(6, user.isEstado());
						return ps;
					}
				},
				keyHolder);
				user.setCusuario(keyHolder.getKey().intValue());
			return user;
		}
	}


	@Override
	public List<UserDTO> getUsuarios() {
		String query = "SELECT CUSUARIO, NICKNAME, TP.TIPONOMBRE, USNOMBRE, USAPELLIDOS, ESTADO FROM TBUSUARIOS AS U " + 
				"INNER JOIN TBTIPOUSUARIO AS TP " + 
				"ON U.CTIPOUSUARIO = TP.CTIPOUSUARIO " + 
				"WHERE U.CTIPOUSUARIO != 2 ORDER BY U.CTIPOUSUARIO";
		List<UserDTO> list = this.row.mapRowUsuarioDTO(this.jdbcTemplate.queryForList(query));
		return list;
	}

	@Override
	public Cliente crearCliente(User user, Cliente cliente) {
		User newUser = this.crearUsuario(user, user.getPassword());
		if (newUser != null) {
			cliente.setCusuario(newUser.getCusuario());
			String insert = Query.insert_cliente;
			int success = this.jdbcTemplate.update(insert, cliente.getDni(), cliente.getCusuario(), cliente.getEmail(), cliente.getPhone(), cliente.getDate());
			if (success != 0) {
				return cliente;
			}
		}
		return null;
	}

	@Override
	public User getUsuarioByAuthentication(String nickname, String password) {
		String findUser = "SELECT * FROM " + Query.table_usuarios + " WHERE NICKNAME = '" + nickname + "' AND PASSWORD = '" + password + "'";
		List<User> user = this.row.mapRowUsuario(this.jdbcTemplate.queryForList(findUser));
		if (user.size() > 0 && user.size() == 1) {
			return user.get(0);
		}
		return null;
	}

	@Override
	public User getUsuarioById(int id) {
		String findUser = Query.selectFromWhere(Query.table_usuarios, "CUSUARIO", id);
		List<User> user = this.row.getUser(this.jdbcTemplate.queryForList(findUser));
		if (user.size() > 0) {
			return user.get(0);
		}
		return null;
	}

	@Override
	public User editUser(User user) {
		User userBefore = this.getUsuarioById(user.getCusuario());
		
		List<User> list = foundNickname(user.getNickname());
		if(list.size() > 0) {
			if (!userBefore.getNickname().equalsIgnoreCase(user.getNickname())) {
				return null;
			} else {
				return actualizarUsuario(user, userBefore.getPassword());
			}
		} else { 
			return actualizarUsuario(user, userBefore.getPassword());
		}
	}

	public User actualizarUsuario(User user, String passwordBefore) {
		String updateUser = "";
		int success = 0;
		if (user.getPassword().equals(passwordBefore)) {
			updateUser = "UPDATE " + Query.table_usuarios + " SET CTIPOUSUARIO = ?, NICKNAME = ?, USAPELLIDOS = ?, USNOMBRE = ?, ESTADO = ? WHERE CUSUARIO = ?";
			success = this.jdbcTemplate.update(
					updateUser, 
					user.getCtipousuario(), user.getNickname(), user.getUsapellidos(), user.getUsnombres(), user.isEstado() ? 1 : 0, user.getCusuario());
			
		} else {
			updateUser = "UPDATE " + Query.table_usuarios + " SET CTIPOUSUARIO = ?, NICKNAME = ?, PASSWORD = ?, USAPELLIDOS = ?, USNOMBRE = ?, ESTADO = ? WHERE CUSUARIO = ?";
			String passwordHash = this.passwordEncoder.encode(user.getPassword());
			success = this.jdbcTemplate.update(
					updateUser, 
					user.getCtipousuario(), user.getNickname(), passwordHash, user.getUsapellidos(), user.getUsnombres(), user.isEstado() ? 1 : 0, user.getCusuario());
			
		}
		if (success == 1) {
			return user;
		} else {
			return null;
		}
	}
	public List<User> foundNickname(String nickname) {
		String query = Query.selectFromWhere(Query.table_usuarios, "NICKNAME", nickname);
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<User> list = this.row.mapRowUsuario(rows);
		return list;
	}


	@Override
	public boolean deleteUser(int id) {
		String delete = "DELETE FROM " +Query.table_usuarios + " WHERE CUSUARIO = ?";
		int success = this.jdbcTemplate.update(delete, id);
		if (success == 1) {
			return true;
		}
		return false;
	}


	@Override
	public Cliente getClienteByUserId(int id) {
		String query = Query.selectFromWhere(Query.table_clientes, "CUSUARIO", id);
		List<Cliente> list = this.row.mapRowCliente(this.jdbcTemplate.queryForList(query));
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}


	@Override
	public List<ClienteDTO> getClientes() {
		String query = "SELECT U.NICKNAME, U.PASSWORD, C.CCLIENTE, C.CUSUARIO, C.DNI, C.EMAIL, C.PHONE, C.DATE, U.USNOMBRE, U.USAPELLIDOS, U.ESTADO "
				+ "FROM TBCLIENTES AS C INNER JOIN TBUSUARIOS AS U ON C.CUSUARIO = U.CUSUARIO";
		List<ClienteDTO> list = this.row.mapRowClienteDTO(this.jdbcTemplate.queryForList(query));
		return list;
	}


	@Override
	public Cliente editCliente(Cliente cliente) {
		Cliente aux = this.getClienteByUserId(cliente.getCusuario());
		System.out.println(aux);
		if (aux != null) {
			System.out.println("Actualiza");
			String editCliente = "UPDATE " + Query.table_clientes + " SET DNI = ?, EMAIL = ?, PHONE = ?, DATE = ? WHERE CUSUARIO = ?";
			int success = this.jdbcTemplate.update(editCliente, cliente.getDni(), cliente.getEmail(), cliente.getPhone(), cliente.getDate(), cliente.getCusuario());
			if (success == 1) {
				return cliente;
			} else {
				return null;
			}
		} else {
			System.out.println("Inserta");
			String insert = Query.insert_cliente;
			int success = this.jdbcTemplate.update(insert, cliente.getDni(), cliente.getCusuario(), cliente.getEmail(), cliente.getPhone(), cliente.getDate());
			if (success != 0) {
				return cliente;
			} else {
				return null;
			}
		}
	}


	@Override
	public boolean eliminarClienteById(ClienteDTO cliente) {
		String deleteCliente = "DELETE FROM " + Query.table_clientes + " WHERE CCLIENTE = ?";
		int success = this.jdbcTemplate.update(deleteCliente, cliente.getCcliente());
		if (success == 1) {
			boolean successful = this.deleteUser(cliente.getCusuario());
			return successful;
		} else {
			return false;
		}
	}


	@Override
	public ClienteDTO getClienteById(int id) {
		String query = "SELECT U.NICKNAME, U.PASSWORD, C.CCLIENTE, C.CUSUARIO, C.DNI, C.EMAIL, C.PHONE, C.DATE, U.USNOMBRE, U.USAPELLIDOS, U.ESTADO "
				+ "FROM TBCLIENTES AS C INNER JOIN TBUSUARIOS AS U ON C.CUSUARIO = U.CUSUARIO WHERE CCLIENTE = " + id;
		List<ClienteDTO> list = this.row.mapRowClienteDTO(this.jdbcTemplate.queryForList(query));
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
