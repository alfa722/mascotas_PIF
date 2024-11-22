package co.edu.poli.proyecto.modelo;

public class Solicitud_Adopcion {

    private int codigo;

    private String fechaSolicitud;

    private String estadoAdopcion;

    private Usuario usuario;

    private String fechaAprovacion;

	public Solicitud_Adopcion(int codigo, String fechaSolicitud, String estadoAdopcion, Usuario usuario,
			String fechaAprovacion) {
		super();
		this.codigo = codigo;
		this.fechaSolicitud = fechaSolicitud;
		this.estadoAdopcion = estadoAdopcion;
		this.usuario = usuario;
		this.fechaAprovacion = fechaAprovacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getEstadoAdopcion() {
		return estadoAdopcion;
	}

	public void setEstadoAdopcion(String estadoAdopcion) {
		this.estadoAdopcion = estadoAdopcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaAprovacion() {
		return fechaAprovacion;
	}

	public void setFechaAprovacion(String fechaAprovacion) {
		this.fechaAprovacion = fechaAprovacion;
	}

	@Override
	public String toString() {
		return "Solicitud_Adopcion [codigo=" + codigo + ", fechaSolicitud=" + fechaSolicitud + ", estadoAdopcion="
				+ estadoAdopcion + ", usuario=" + usuario + ", fechaAprovacion=" + fechaAprovacion + "]";
	}


}
