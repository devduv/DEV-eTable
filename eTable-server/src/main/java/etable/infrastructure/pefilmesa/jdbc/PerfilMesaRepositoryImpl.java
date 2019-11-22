package etable.infrastructure.pefilmesa.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import etable.domain.perfilmesa.model.PerfilMesa;
import etable.domain.perfilmesa.repository.PerfilMesaRepository;
import etable.web.constants.querys.Query;

@Component
public class PerfilMesaRepositoryImpl implements PerfilMesaRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PerfilMesaRowMapper row;
	
	@Override
	public List<PerfilMesa> getPerfilesMesa() {
		String query = "SELECT * FROM " + Query.table_perfilmesa;
		List<PerfilMesa> perfiles = null;
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		perfiles = row.mapRowConfigSistema(rows);
		return perfiles;
	}

}
