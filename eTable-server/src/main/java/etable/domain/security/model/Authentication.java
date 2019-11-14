package etable.domain.security.model;

public class Authentication {

	private int cusuario;
	private String nickname;
	private String contrasena;
	
	Authentication(int cusuario, String nickname, String contrasena){
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.contrasena = contrasena;
	}

	public int getCusuario() {
		return cusuario;
	}

	public void setCusuario(int cusuario) {
		this.cusuario = cusuario;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
