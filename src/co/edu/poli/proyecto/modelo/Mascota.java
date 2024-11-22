package co.edu.poli.proyecto.modelo;

public class Mascota {

	  private String nombre;
	  private String chip;
	  private String edad;
	  private String sexo;
	  private String color;
	  private String fechaNacimiento;
	  private int cantidadVacunas;
	  private String proximaVacuna;
	  private String hospitalizaciones;
	  private String medicaciones;
	public Mascota(String nombre, String chip, String edad, String sexo, String color, String fechaNacimiento,
			int cantidadVacunas, String proximaVacuna, String hospitalizaciones, String medicaciones) {
		super();
		this.nombre = nombre;
		this.chip = chip;
		this.edad = edad;
		this.sexo = sexo;
		this.color = color;
		this.fechaNacimiento = fechaNacimiento;
		this.cantidadVacunas = cantidadVacunas;
		this.proximaVacuna = proximaVacuna;
		this.hospitalizaciones = hospitalizaciones;
		this.medicaciones = medicaciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getCantidadVacunas() {
		return cantidadVacunas;
	}
	public void setCantidadVacunas(int cantidadVacunas) {
		this.cantidadVacunas = cantidadVacunas;
	}
	public String getProximaVacuna() {
		return proximaVacuna;
	}
	public void setProximaVacuna(String proximaVacuna) {
		this.proximaVacuna = proximaVacuna;
	}
	public String getHospitalizaciones() {
		return hospitalizaciones;
	}
	public void setHospitalizaciones(String hospitalizaciones) {
		this.hospitalizaciones = hospitalizaciones;
	}
	public String getMedicaciones() {
		return medicaciones;
	}
	public void setMedicaciones(String medicaciones) {
		this.medicaciones = medicaciones;
	}
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", chip=" + chip + ", edad=" + edad + ", sexo=" + sexo + ", color=" + color
				+ ", fechaNacimiento=" + fechaNacimiento + ", cantidadVacunas=" + cantidadVacunas + ", proximaVacuna="
				+ proximaVacuna + ", hospitalizaciones=" + hospitalizaciones + ", medicaciones=" + medicaciones + "]";
	}



}
