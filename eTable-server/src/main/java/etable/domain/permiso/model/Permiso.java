package etable.domain.permiso.model;

public class Permiso {

	private int cpermiso;
	private int csubitem;
	private String permiso;
	private String descripcion;
	private boolean estado;
	
	public Permiso() {
		
	}

	public Permiso(int cpermiso, int csubitem, String permiso, String descripcion, boolean estado) {
		super();
		this.cpermiso = cpermiso;
		this.csubitem = csubitem;
		this.permiso = permiso;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCpermiso() {
		return cpermiso;
	}

	public void setCpermiso(int cpermiso) {
		this.cpermiso = cpermiso;
	}

	public int getCsubitem() {
		return csubitem;
	}

	public void setCsubitem(int csubitem) {
		this.csubitem = csubitem;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
