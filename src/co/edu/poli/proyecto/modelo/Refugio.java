package co.edu.poli.proyecto.modelo;

public class Refugio {





	private int ID;
	  private String nombre;

	  private String nombre_de_mascota;

	  private double latitud;

	  private double longitud;

	  private String chip;

	  private String direccion;

	  private String telefono;

	  private String email;

	  private String hora_atencion;

	  private String capacidad_maxima;

	  private Mascota mascotas;
	   private String raza;
	   private String nombre_usuario;
	   private String sexo;
	   private String mayor_edad;
	   private String proxima_vacuna;


	  private Solicitud_Adopcion solicitud;




	public Refugio() {
		super();
	}




	public Refugio(String fecha, int iD, String nombre, String nombre_de_mascota, double latitud, double longitud,
			String chip, String direccion, String telefono, String email, String hora_atencion, String capacidad_maxima,
			Mascota mascotas, String raza, String nombre_usuario, String sexo, String mayor_edad, String proxima_vacuna,
			Solicitud_Adopcion solicitud) {
		super();
		this.proxima_vacuna = proxima_vacuna;
		ID = iD;
		this.nombre = nombre;
		this.nombre_de_mascota = nombre_de_mascota;
		this.latitud = latitud;
		this.longitud = longitud;
		this.chip = chip;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.hora_atencion = hora_atencion;
		this.capacidad_maxima = capacidad_maxima;
		this.mascotas = mascotas;
		this.raza = raza;
		this.nombre_usuario = nombre_usuario;
		this.sexo = sexo;
		this.mayor_edad = mayor_edad;
		this.proxima_vacuna = proxima_vacuna;
		this.solicitud = solicitud;
	}




	public String getFecha() {
		return proxima_vacuna;
	}




	public void setproxima_vacuna(String proxima_vacuna) {
		this.proxima_vacuna = proxima_vacuna;
	}




	public int getID() {
		return ID;
	}




	public void setID(int iD) {
		ID = iD;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getNombre_de_mascota() {
		return nombre_de_mascota;
	}




	public void setNombre_de_mascota(String nombre_de_mascota) {
		this.nombre_de_mascota = nombre_de_mascota;
	}




	public double getLatitud() {
		return latitud;
	}




	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}




	public double getLongitud() {
		return longitud;
	}




	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}




	public String getChip() {
		return chip;
	}




	public void setChip(String chip) {
		this.chip = chip;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getHora_atencion() {
		return hora_atencion;
	}




	public void setHora_atencion(String hora_atencion) {
		this.hora_atencion = hora_atencion;
	}




	public String getCapacidad_maxima() {
		return capacidad_maxima;
	}




	public void setCapacidad_maxima(String capacidad_maxima) {
		this.capacidad_maxima = capacidad_maxima;
	}




	public Mascota getMascotas() {
		return mascotas;
	}




	public void setMascotas(Mascota mascotas) {
		this.mascotas = mascotas;
	}




	public String getRaza() {
		return raza;
	}




	public void setRaza(String raza) {
		this.raza = raza;
	}




	public String getNombre_usuario() {
		return nombre_usuario;
	}




	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public String getMayor_edad() {
		return mayor_edad;
	}




	public void setMayor_edad(String mayor_edad) {
		this.mayor_edad = mayor_edad;
	}




	public String getProxima_vacuna() {
		return proxima_vacuna;
	}




	public void setProxima_vacuna(String proxima_vacuna) {
		this.proxima_vacuna = proxima_vacuna;
	}




	public Solicitud_Adopcion getSolicitud() {
		return solicitud;
	}




	public void setSolicitud(Solicitud_Adopcion solicitud) {
		this.solicitud = solicitud;
	}




	@Override
	public String toString() {
		return "Refugio [fecha=" + proxima_vacuna + ", ID=" + ID + ", nombre=" + nombre + ", nombre_de_mascota="
				+ nombre_de_mascota + ", latitud=" + latitud + ", longitud=" + longitud + ", chip=" + chip
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", hora_atencion="
				+ hora_atencion + ", capacidad_maxima=" + capacidad_maxima + ", mascotas=" + mascotas + ", raza=" + raza
				+ ", nombre_usuario=" + nombre_usuario + ", sexo=" + sexo + ", mayor_edad=" + mayor_edad
				+ ", proxima_vacuna=" + proxima_vacuna + ", solicitud=" + solicitud + "]";
	}
}




