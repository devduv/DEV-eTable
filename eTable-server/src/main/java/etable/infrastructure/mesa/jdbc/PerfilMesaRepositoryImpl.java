package etable.infrastructure.mesa.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.mesa.model.PerfilMesa;
import etable.domain.mesa.repository.PerfilMesaRepository;
import etable.web.constants.querys.Query;

@Component
public class PerfilMesaRepositoryImpl implements PerfilMesaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PerfilMesaRowMapper row;



	@Override
	public List<PerfilMesa> getPerfilMesas() {
		// TODO Auto-generated method stub
		String query = Query.selectFrom(Query.table_perfilmesa);

		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<PerfilMesa> perfilmesas = row.mapRowPerfilMesa(rows);
		return perfilmesas;
	}

	@Override
	public PerfilMesa actualizarPerfilMesaById(PerfilMesa perfilmesa, int id) {
		String query = "UPDATE " + Query.table_perfilmesa
				+ " SET PMNOMBRE = ? , PMDESCRIPCION = ? , PMCAPACIDAD = ?,PMCOMPUESTA = ? WHERE CPERFILMESA = ?";
		int update = this.jdbcTemplate.update(query, perfilmesa.getPmnombre(), perfilmesa.getPmdescripcion(),
				perfilmesa.getPmcapacidad(), perfilmesa.getPmcompuesta(),	perfilmesa.getCperfilmesa());
		
		if (update == 1) {
			return perfilmesa;
		}
		return null;
	}

	@Override
	public boolean eliminarPerfilMesaById(int id)  {
		String query = "DELETE FROM " + Query.table_perfilmesa + " WHERE CPERFILMESA = ?";

		int success = this.jdbcTemplate.update(query, id);
		if (success >= 0) {
			return true;
		}
		return false;

	}

	@Override
	public PerfilMesa crearPerfilMesa(PerfilMesa perfilmesa) {

		String insertQuery = "insert into " + Query.table_perfilmesa
				+ "(PMNOMBRE,PMDESCRIPCION,PMCAPACIDAD,PMCOMPUESTA) values (?, ?, ?,?)";
		int success = this.jdbcTemplate.update(insertQuery,perfilmesa.getPmnombre(),perfilmesa.getPmdescripcion(),
				perfilmesa.getPmcapacidad(), perfilmesa.getPmcompuesta());
		if (success >= 0) {
			return perfilmesa;
		}
		return null;

	}

	@Override
	
	public PerfilMesa getPerfilMesaById(int id) {
		String findPerfil = Query.selectFromWhere(Query.table_perfilmesa, "CPERFILMESA", id);
		List<PerfilMesa> perfilmesa = this.row.getPerfilMesa(this.jdbcTemplate.queryForList(findPerfil));
		if (perfilmesa.size() > 0) {
			return perfilmesa.get(0);
		}
		return null;
	}
	

}
