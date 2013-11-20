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
	
	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
		this.chequearCondicion();
	}
	
	public void chequearCondicion(){
		int prestamosEnCurso= 0;
		for (Prestamo e : prestamos) {
			if(e.estaEnDeuda()){
				this.setEstadoASinPermiso();
				break;
			}
			if(e.estaEnCurso()){
				prestamosEnCurso++;
			}
		}
		if(prestamosEnCurso >= 2){
			this.setEstadoASinPermiso();
		}
	}

}
