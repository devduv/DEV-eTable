package etable.infrastructure.mesa.jdbc;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.mesa.repository.EstadoMesaRepository;
import etable.web.constants.querys.Query;

@Component
public class EstadoMesaRepositoryImpl implements EstadoMesaRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EstadoMesaRowMapper row;

	
	@Override
	public List<EstadoMesa> getEstadoMesas() {
		// TODO Auto-generated method stub
		String query = Query.selectFrom(Query.table_estadomesa);
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<EstadoMesa> estadomesas = row.mapRowEstadoMesa(rows);
		return estadomesas;
	}


	@Override
	public EstadoMesa getEstadoMesaById(int id) {
		String findEstadomesa = Query.selectFromWhere(Query.table_estadomesa, "CESTADOMESA", id);
		List<EstadoMesa> estadomesa = this.row.mapRowEstadoMesa(this.jdbcTemplate.queryForList(findEstadomesa));
		if (estadomesa.size() > 0) {
			return estadomesa.get(0);
		}
		return null;
	}
	
	
	
	
}
