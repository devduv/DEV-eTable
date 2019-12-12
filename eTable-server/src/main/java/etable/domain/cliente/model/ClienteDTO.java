package etable.domain.cliente.model;

public class ClienteDTO {

	private int ccliente;
	private int dni;
	private String usnombre;
	private String usapellidos;
	private int cusuario;
	private String email;
	private String phone;
	private String date;
	private boolean estado;
	
	public ClienteDTO() {
		
		
	}
	
	public ClienteDTO(int ccliente, int dni, String usnombre, String usapellidos, int cusuario, String email, String phone, String date, boolean estado) {
		super();
		this.ccliente = ccliente;
		this.dni = dni;
		this.usnombre = usnombre;
		this.usapellidos = usapellidos;
		this.cusuario = cusuario;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.estado = estado;
	}

	public int getCcliente() {
		return ccliente;
	}

	public void setCcliente(int ccliente) {
		this.ccliente = ccliente;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCusuario() {
		return cusuario;
	}

	public void setCusuario(int cusuario) {
		this.cusuario = cusuario;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
