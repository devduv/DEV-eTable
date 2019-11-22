package etable.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.perfilmesa.PerfilMesaService;
import etable.domain.perfilmesa.model.PerfilMesa;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping({"/api/perfilMesa"})
public class PerfilMesaController {

	@Autowired
	private PerfilMesaService service;
	
	
	@GetMapping(path = {"/perfiles"})
	public List<PerfilMesa> obtenerPerfilesMesa() {
		return this.service.getPerfilesMesa();
	}
}
