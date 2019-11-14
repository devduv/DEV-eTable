package etable.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.security.repository.AuthenticationRepository;

@Service
public class AuthenticationSeviceImpl implements AuthenticationService{

	@Autowired
	private AuthenticationRepository repository;
	
	public boolean buscarUsuarioSiExiste(int cusuario, String nickname) {
		return this.repository.buscarUsuarioSiExiste(cusuario, nickname);
	}

}
