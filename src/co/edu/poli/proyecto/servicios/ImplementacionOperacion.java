package co.edu.poli.proyecto.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.proyecto.modelo.Solicitud_Adopcion;




public class ImplementacionOperacion implements Operacion {

	private Solicitud_Adopcion[] solicitudes;

	public ImplementacionOperacion() {
		solicitudes = new Solicitud_Adopcion[1];
	}

	@Override
	public String create(Solicitud_Adopcion x) {
		for (int i = 0; i < solicitudes.length; i++) {
			if (solicitudes[i] == null) {
				solicitudes[i] = x;
				return "listo.";
			}
		}
		Solicitud_Adopcion[] aux = new Solicitud_Adopcion[solicitudes.length * 2];
		System.arraycopy(solicitudes, 0, aux, 0, solicitudes.length);
		aux[solicitudes.length] = x;
		solicitudes = aux;
		return "listo..";
	}

	@Override
	public Solicitud_Adopcion[] readall() {
		return solicitudes;
	}

	@Override
	public Solicitud_Adopcion read(int codigo) {
		for (Solicitud_Adopcion solicitude : solicitudes) {
			if (solicitude.getCodigo() == codigo) {
				return solicitude;
			}
		}
		return null;
	}

	@Override
	public String update(int codigo, Solicitud_Adopcion y) {
		for (int i = 0; i < solicitudes.length; i++) {
			if (solicitudes[i] != null && solicitudes[i].getCodigo() == codigo) {
				solicitudes[i] = y;
				return "Actualizada";
			}
		}
		return "no se encuentra vivienda";
	}

	@Override
	public Solicitud_Adopcion delete(int codigo) {
		for (int i = 0; i < solicitudes.length; i++) {
			if (solicitudes[i] != null && solicitudes[i].getCodigo()==codigo) {
				Solicitud_Adopcion solicitudEliminada = solicitudes[i];
				solicitudes[i] = null;
				return solicitudEliminada;
			}
		}
		return null;
	}




	public Solicitud_Adopcion[] getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(Solicitud_Adopcion[] solicitudes) {
		this.solicitudes = solicitudes;
	}

	public String serializar(Solicitud_Adopcion[] solicitudes, String path, String name) {
		try {
		FileOutputStream fos = new FileOutputStream(path + name);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(solicitudes);
		oos.close();
		fos.close();
		return "File create!!";
		} catch (IOException ioe) {
		return "Error file " + ioe.getMessage();
		}
		}
		public Solicitud_Adopcion[] deserializar(String path, String name) {
		Solicitud_Adopcion[] a = null;
		try {
		FileInputStream fis = new FileInputStream(path + name);
		ObjectInputStream ois = new ObjectInputStream(fis);
		a = (Solicitud_Adopcion[]) ois.readObject();
		ois.close();
		fis.close();
		} catch (IOException ioe) {
		ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
		c.printStackTrace();
		}
		return a;
		}
}





