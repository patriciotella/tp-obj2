package cliente;

import java.util.List;

import prestamo.Prestamo;

public class ClienteSimple extends Cliente {

	public ClienteSimple(String nombre, String apellido, String dni, String domicilio) {
		super(nombre, apellido, dni, domicilio);
	}

	public String getApellido() {
		return this.apellido;
	}
	
	public String getDni() {
		return this.dni;
	}
		
	public ClienteState getEstado() {
		return this.estado;
	}

	public List<Prestamo> getPrestamos(){
			return this.prestamos;
		}

}
