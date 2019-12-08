package etable.domain.user.model;

public class User{

	private int cusuario;
	private String nickname;
	private String password;
	private String usnombres;
	private String usapellidos;
	private boolean estado;
	private int ctipousuario;
	
	public User() {
		
	}

	public User(int cusuario, String nickname, String usnombres, String usapellidos, boolean estado, int ctipousuario) {
		super();
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.usnombres = usnombres;
		this.usapellidos = usapellidos;
		this.estado = estado;
		this.ctipousuario = ctipousuario;
	}

	
	public User(int cusuario, String nickname, String password, String usnombres, String usapellidos, boolean estado,
			int ctipousuario) {
		super();
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.password = password;
		this.usnombres = usnombres;
		this.usapellidos = usapellidos;
		this.estado = estado;
		this.ctipousuario = ctipousuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUsnombres() {
		return usnombres;
	}

	public void setUsnombres(String usnombres) {
		this.usnombres = usnombres;
	}

	public String getUsapellidos() {
		return usapellidos;
	}

	public void setUsapellidos(String usapellidos) {
		this.usapellidos = usapellidos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCtipousuario() {
		return ctipousuario;
	}

	public void setCtipousuario(int ctipousuario) {
		this.ctipousuario = ctipousuario;
	}

	@Override
	public String toString() {
		return "User [cusuario=" + cusuario + ", nickname=" + nickname + ", password=" + password + ", usnombres="
				+ usnombres + ", usapellidos=" + usapellidos + ", estado=" + estado + ", ctipousuario=" + ctipousuario
				+ "]";
	}

}
