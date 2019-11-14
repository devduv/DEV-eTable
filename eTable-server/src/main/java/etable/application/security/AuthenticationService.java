package etable.application.security;


public interface AuthenticationService {

	boolean buscarUsuarioSiExiste(int cusuario, String nickname);
}
