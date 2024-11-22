package co.edu.poli.proyecto.modelo;

public class Privado {

	  private String donaciones;

	public Privado(String donaciones) {
		super();
		this.donaciones = donaciones;
	}

	public String getDonaciones() {
		return donaciones;
	}

	public void setDonaciones(String donaciones) {
		this.donaciones = donaciones;
	}

	@Override
	public String toString() {
		return "Privado [donaciones=" + donaciones + "]";
	}


}
