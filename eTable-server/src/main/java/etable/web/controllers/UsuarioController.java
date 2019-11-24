package etable.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.usuarios.UsuariosService;
import etable.domain.usuarios.model.TipoUsuario;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping({"/api/usuarios"})
public class UsuarioController {
	
	@Autowired
	private UsuariosService service;
	
	@GetMapping(path = {"/tipoUsuario/list"})
	public List<TipoUsuario> getTiposUsuario() {
		return this.service.getTiposUsuario();
	}
	
	@GetMapping(path = {"/tipoUsuario/{id}"})
	public TipoUsuario getTipoUsuarioById(@PathVariable int id) {
		return this.service.getTipoUsuarioById(id);
	}
	
	@PostMapping(path = {"/tipoUsuario/agregarTipoUsuario"})
	public TipoUsuario addTipoUsuario(@RequestBody TipoUsuario tipousuario) {
		return this.service.crearTipoUsuario(tipousuario);
	}
	
	@PutMapping(path = {"/tipoUsuario/editarTipoUsuario"})
	public TipoUsuario editTipoUsuario(@RequestBody TipoUsuario tipousuario) {
		return this.service.editTipoUsuario(tipousuario);
	}

}
