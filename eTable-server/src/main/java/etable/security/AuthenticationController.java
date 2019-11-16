package etable.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.security.AuthenticationService;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping({"/api/authentication"})
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	
	@GetMapping(path = {"/finduserbynickname/{nickname}"})
	public boolean buscarUsuarioSiExiste(String nickname) {
		return this.service.buscarUsuarioSiExiste(nickname);
	}

}
