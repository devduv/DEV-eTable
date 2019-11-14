package etable.domain.security.repository;

public interface AuthenticationRepository {
	boolean buscarUsuarioSiExiste(int cusuario, String nickname);
}
