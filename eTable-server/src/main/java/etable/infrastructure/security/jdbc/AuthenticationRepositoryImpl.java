package etable.infrastructure.security.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.security.repository.AuthenticationRepository;

@Component
public class AuthenticationRepositoryImpl implements AuthenticationRepository{

	private final JdbcTemplate jdbcTemplate;
	
	public AuthenticationRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public boolean buscarUsuarioSiExiste(int cusuario, String nickname) {
		// TODO Auto-generated method stub
		return false;
	}

}
