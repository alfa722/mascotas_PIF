package co.edu.poli.proyecto.modelo;


public class Usuario {


    private String nombre;

    private String contraseña;

    private String tipoId;

    private String identificacion;


    private int telefono;

    private String correoElectronico;

    private String direccion;

    private String ciudad;

    private String ingresoMensual;

	public Usuario(String nombre, String contraseña, String tipoId, String identificacion, int telefono,
			String correoElectronico, String direccion, String ciudad, String ingresoMensual) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.tipoId = tipoId;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.ingresoMensual = ingresoMensual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(String ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", tipoId=" + tipoId + ", identificacion="
				+ identificacion + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico
				+ ", direccion=" + direccion + ", ciudad=" + ciudad + ", ingresoMensual=" + ingresoMensual + "]";
	}



}