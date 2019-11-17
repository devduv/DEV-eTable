package etable.domain.security.model;


public class Authentication {

	private int cusuario;
	private String nickname;
	private String password;
	
	public Authentication(int cusuario, String nickname, String password){
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.password = password;
	}

	public Authentication() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
