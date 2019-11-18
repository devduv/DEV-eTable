package etable.infrastructure.configuracion.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.configuracion.model.Configuracion;
import etable.domain.configuracion.repository.ConfiguracionRepository;
import etable.web.constants.querys.Query;

@Component
public class ConfiguracionRepositoryImpl implements ConfiguracionRepository {

	private final JdbcTemplate jdbcTemplate;
	private final ConfiguracionRowMapper row;
	
	public ConfiguracionRepositoryImpl(JdbcTemplate jdbcTemplate, ConfiguracionRowMapper row) {
		this.jdbcTemplate = jdbcTemplate;
		this.row = row;
	}
	
	@Override
	public Configuracion getConfiguracion() {
		String query = "SELECT * FROM " + Query.table_configuracion;
		Configuracion configuracion = null;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		configuracion = row.mapRow(rows);
		return configuracion;
	}
}
