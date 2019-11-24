package etable.infrastructure.usuarios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import etable.domain.usuarios.model.TipoUsuario;
import etable.domain.usuarios.repository.UsuariosRepository;
import etable.web.constants.querys.Query;

@Component
public class UsuariosRepositoryImpl implements UsuariosRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UsuariosRowMapper row;
	
	@Override
	public TipoUsuario agregarTipoUsuario(TipoUsuario tipousuario) {
		final String query = Query.insert_tipousuario;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps =
						connection.prepareStatement(query, new String[] {"id"});
					ps.setString(1, tipousuario.getTiponombre());
					ps.setString(2, tipousuario.getTipodescripcion());
					return ps;
				}
			},
			keyHolder);
			tipousuario.setCtipousuario(keyHolder.getKey().intValue());
		
		return tipousuario;
	}

	@Override
	public TipoUsuario getTipoUsuarioById(int ctipousuario) {
		String query = Query.selectFromWhere(Query.table_tipousuario, "CTIPOUSUARIO", ctipousuario);
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<TipoUsuario> list = this.row.mapRowTipoUsuario(rows);
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<TipoUsuario> getTiposUsuario() {
		String query = Query.selectFrom(Query.table_tipousuario);
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<TipoUsuario> list = this.row.mapRowTipoUsuario(rows);
		return list;
	}

	@Override
	public TipoUsuario editTipoUsuario(TipoUsuario tipousuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
