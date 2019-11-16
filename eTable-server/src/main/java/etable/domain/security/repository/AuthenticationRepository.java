package etable.domain.security.repository;

public interface AuthenticationRepository {
	boolean buscarUsuarioSiExiste(String nickname);
}
