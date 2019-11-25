package etable.application.usuarios;

import java.util.List;

import etable.domain.usuarios.model.TipoUsuario;
import etable.domain.usuarios.model.TipoUsuarioPermiso;

public interface UsuariosService {

	TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario);
	TipoUsuario getTipoUsuarioById(int ctipousuario);
	List<TipoUsuario> getTiposUsuario();
	TipoUsuario editTipoUsuario(TipoUsuario tipousuario);
	
	List<TipoUsuarioPermiso> getPermisosDeTipoUsuario(int ctipousuario);
	boolean asignarPermisosParaTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos);
	boolean editarPermisosDeTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos);
}
