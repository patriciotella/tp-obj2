package model;

import java.util.ArrayList;
// import java.io.IOException;
import java.util.List;

public class Cliente {
	
	String nombre;
	String apellido;
	int dni;
	String domicilio;
	List<Prestamo> prestamos;
	private ClienteState estado;
	boolean notificacionDeVencimientos= false;
	
	public Cliente(String nombre, String apellido, int dni, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.prestamos = new ArrayList<Prestamo>();
		this.estado = new ClienteConPermiso();
	}
	
	public String getNombre() {
		return nombre;
	}

	public ClienteState getEstado() {
		return estado;
	}

	public void setEstado(){
		//hay que chequear que el cliente no tenga ningun prestamo en deuda o incobrable
	/*	int pEnDeuda = 0;
		int pEnCurso = 0;
		int pEnIncobrable = 0;
		for (Prestamo p : this.prestamos ) {
			
			if ( p.estaEnDeuda() ){
				this.estado = new ClienteSinPermiso();
			} */
		
	}
	
	public List<Prestamo> getPrestamos(){
		return this.prestamos;
	}
	
	public void solicitarPrestamo(Prestamo p){
		this.prestamos.add(p);
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
				this.setEstado(new ClienteSinPermiso());
			}
			if(e.estaEnCurso()){
				prestamosEnCurso++;
			}
		}
		if(prestamosEnCurso >= 2){
			this.setEstado(new ClienteSinPermiso());
		}
	}
	
	public boolean aptoParaPedirPrestamo() {
		return this.estado.aptoParaPedirPrestamo();
	}

	public void pasarARechazado(Prestamo p) {
		int aux = this.prestamos.indexOf(p);
		this.prestamos.get(aux).cambiarEstadoARechazado();
		System.out.println("Tu préstamo ha sido rechazado.");
	}

	public void pasarAAprobado(Prestamo p) {
		int aux = this.prestamos.indexOf(p);
		this.prestamos.get(aux).cambiarEstadoAAprobado();
		System.out.println("Tu préstamo ha sido aprobado.");
		
	}

	public static void main(String[] args) {
	}
	

}