package etable.application.usuarios;

import java.util.List;

import etable.domain.usuarios.model.TipoUsuario;

public interface UsuariosService {

	TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario);
	TipoUsuario getTipoUsuarioById(int ctipousuario);
	List<TipoUsuario> getTiposUsuario();
	TipoUsuario editTipoUsuario(TipoUsuario tipousuario);
}
