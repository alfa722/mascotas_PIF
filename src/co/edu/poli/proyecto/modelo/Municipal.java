package co.edu.poli.proyecto.modelo;

public class Municipal {

	  private String financiamientoGobierno;

	public Municipal(String financiamientoGobierno) {
		super();
		this.financiamientoGobierno = financiamientoGobierno;
	}

	public String getFinanciamientoGobierno() {
		return financiamientoGobierno;
	}

	public void setFinanciamientoGobierno(String financiamientoGobierno) {
		this.financiamientoGobierno = financiamientoGobierno;
	}

	@Override
	public String toString() {
		return "Municipal [financiamientoGobierno=" + financiamientoGobierno + "]";
	}

}
