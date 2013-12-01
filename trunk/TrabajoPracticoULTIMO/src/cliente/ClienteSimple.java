package cliente;

import java.util.List;

import prestamo.Prestamo;

public class ClienteSimple extends Cliente {

	public ClienteSimple(String nombre, String apellido, String CUIT, String domicilio) {
		super(nombre, apellido, CUIT, domicilio);
	}
		
	public ClienteState getEstado() {
		return this.estado;
	}

	public List<Prestamo> getPrestamos(){
			return this.prestamos;
		}
	
	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
		this.chequearCondicion();
	}
}
