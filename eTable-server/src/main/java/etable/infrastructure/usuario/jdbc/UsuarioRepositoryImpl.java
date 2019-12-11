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
				"WHERE U.CTIPOUSUARIO = 1 ORDER BY U.CTIPOUSUARIO";
		List<UserDTO> list = this.row.mapRowUsuarioDTO(this.jdbcTemplate.queryForList(query));
		return list;
	}

	@Override
	public boolean eliminarUsuarioById(int id) {
		// TODO Auto-generated method stub
		return false;
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

}
