package model;

import java.io.IOException;
import java.util.List;
import java.lang.*;

public class Cliente {
	
	String nombre;
	String apellido;
	int dni;
	String domicilio;
	List<Prestamo> prestamos;
	boolean notificacionDeVencimientos= false;
	private ClienteState state;
	
	public Cliente(String nombre, String apellido, int dni, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.state = new ClienteConPermiso();
	}
	
	public void setState(ClienteState s){
		this.state = s;
	}
	
	public List<Prestamo> getPrestamos(){
		return this.prestamos;
	}
	
	public void solicitarPrestamo(int monto, int cuotas){
		this.state.solicitarPrestamo(this, monto, cuotas);
	}
	
	public void pagarCuota(Prestamo p){
		int posicionPrestamo= prestamos.indexOf(p);
		prestamos.get(posicionPrestamo).pagarCuota(p.getCuotas());
	}
	

	public void chequearCondicion(Cliente c){
		//HORRIBLE
		int prestamosEnCurso= 0;
		for (Prestamo e : prestamos) {
			if(e.estaEnDeuda()){
				this.setState(new ClienteSinPermiso());
			}
			if(e.estaEnCurso()){
				prestamosEnCurso++;
			}
		}
		if(prestamosEnCurso >= 2){
			this.setState(new ClienteSinPermiso());
		}
	}
	
	public static void main(String[] args) {
		Cliente c= new Cliente("a", "b", 123, "a");
		c.solicitarPrestamo(12000, 12);
	}
	

}
