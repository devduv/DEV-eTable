package etable.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.security.AuthenticationService;

@RestController
@RequestMapping({"/api/authentication"})
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	
	@GetMapping(path = {"/{cusuario}"})
	public boolean buscarUsuarioSiExiste(@PathVariable("cusuario") int cusuario, String nickname) {
		return this.service.buscarUsuarioSiExiste(cusuario, nickname);
	}

}
