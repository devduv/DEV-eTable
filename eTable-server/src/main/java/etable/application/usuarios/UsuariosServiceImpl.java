package etable.application.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.usuarios.model.TipoUsuario;
import etable.domain.usuarios.model.TipoUsuarioPermiso;
import etable.domain.usuarios.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	private UsuariosRepository repository;
	
	@Override
	public TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario) {
		return this.repository.agregarTipoUsuario(tipoUsuario);
	}

	@Override
	public TipoUsuario getTipoUsuarioById(int ctipousuario) {
		return this.repository.getTipoUsuarioById(ctipousuario);
	}

	@Override
	public List<TipoUsuario> getTiposUsuario() {
		return this.repository.getTiposUsuario();
	}

	@Override
	public TipoUsuario editTipoUsuario(TipoUsuario tipousuario) {
		return this.repository.editTipoUsuario(tipousuario);
	}

	@Override
	public List<TipoUsuarioPermiso> getPermisosDeTipoUsuario(int ctipousuario) {
		return this.repository.getPermisosDeTipoUsuario(ctipousuario);
	}

	@Override
	public boolean asignarPermisosParaTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos) {
		return this.repository.asignarPermisosParaTipoUsuario(tipouspermisos);
	}

	@Override
	public boolean editarPermisosDeTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos) {
		return this.repository.editarPermisosDeTipoUsuario(tipouspermisos);
	}

}
