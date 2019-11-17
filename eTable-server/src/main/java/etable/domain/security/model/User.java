package etable.domain.security.model;

public class User{

	private int cusuario;
	private String nickname;
	private String usnombre;
	private String usapellidos;
	private int estado;
	private int ustipo;
	
	public User() {
		
	}
	
	public User(int cusuario, String nickname, String usnombre, String usapellidos, int estado, int ustipo) {
		super();
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.usnombre = usnombre;
		this.usapellidos = usapellidos;
		this.estado = estado;
		this.ustipo = ustipo;
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
	public String getUsnombre() {
		return usnombre;
	}
	public void setUsnombre(String usnombre) {
		this.usnombre = usnombre;
	}
	public String getUsapellidos() {
		return usapellidos;
	}
	public void setUsapellidos(String usapellidos) {
		this.usapellidos = usapellidos;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getUstipo() {
		return ustipo;
	}
	public void setUstipo(int ustipo) {
		this.ustipo = ustipo;
	}
	
	
	
	
}
