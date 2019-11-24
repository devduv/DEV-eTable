package etable.domain.usuarios.repository;

import java.util.List;

import etable.domain.usuarios.model.TipoUsuario;

public interface UsuariosRepository {

	TipoUsuario agregarTipoUsuario(TipoUsuario tipoUsuario);
	TipoUsuario getTipoUsuarioById(int ctipousuario);
	List<TipoUsuario> getTiposUsuario();
	TipoUsuario editTipoUsuario(TipoUsuario tipousuario);
}
