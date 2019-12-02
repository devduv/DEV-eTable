package etable.domain.user.model;

public class User{

	private int cusuario;
	private String nickname;
	private String email;
	private String phone;
	private String dni;
	private String date;
	private int estado;
	private int ustipo;
	
	public User() {
		
	}

	public User(int cusuario, String nickname, String email, String phone, String dni, String date, int estado,
			int ustipo) {
		super();
		this.cusuario = cusuario;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.dni = dni;
		this.date = date;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
