package etable.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.configuracion.ConfiguracionService;
import etable.domain.configuracion.model.Configuracion;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping({"/api/configuracion"})
public class ConfiguracionController {

	@Autowired
	private ConfiguracionService service;
	
	@GetMapping(path = {"/configuracionSistema"})
	public Configuracion getConfiguracionSistemaGeneral() {
		return this.service.getConfiguracion();
	}
}
