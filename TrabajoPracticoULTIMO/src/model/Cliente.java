package model;
/**
 * Esta clase ....
 * @author Angeles
 */
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
// import java.io.IOException;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private int dni;
	private String domicilio;
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
	
	public String getApellido() {
		return apellido;
	}
	
	public int getDni() {
		return this.dni;
	}

	public ClienteState getEstado() {
		return estado;
	}
	
	public List<Prestamo> getPrestamos(){
		return this.prestamos;
	}
	
	public void solicitarPrestamo(Prestamo p, Sistema s){
		this.estado.solicitarPrestamo(this, p, s);
	}
	
	public void pagarCuota(Prestamo p){
		int posicionPrestamo= prestamos.indexOf(p);
		prestamos.get(posicionPrestamo).pagarCuota();
	}

	public void chequearCondicion(Cliente c){
		//HORRIBLE
		int prestamosEnCurso= 0;
		for (Prestamo e : prestamos) {
			if(e.estaEnDeuda()){
				this.setEstadoASinPermiso();
			}
			if(e.estaEnCurso()){
				prestamosEnCurso++;
			}
		}
		if(prestamosEnCurso >= 2){
			this.setEstadoASinPermiso();
		}
	}
	
	private void setEstadoASinPermiso() {
		this.estado = new ClienteSinPermiso();
		
	}

	public boolean aptoParaPedirPrestamo() {
		return this.estado.aptoParaPedirPrestamo();
	}

	public void pasarARechazado(Prestamo p) {
		p.cambiarEstadoARechazado();
		
		int aux = this.prestamos.indexOf(p);
		this.prestamos.get(aux).cambiarEstadoARechazado();
		//System.out.println("Tu préstamo ha sido rechazado.");
	}

	public void pasarAAprobado(Prestamo p) throws InstallmentCountException, InvalidAmountException {
		int aux = this.prestamos.indexOf(p);
		this.prestamos.get(aux).cambiarEstadoAEnCurso();
		System.out.println("Tu préstamo ha sido aprobado.");
		
	}

	public Prestamo pasarAEnDeuda(Prestamo p) {
		int aux = this.prestamos.indexOf(p);
		this.prestamos.get(aux).cambiarEstadoAEnDeuda();
		System.out.println("El préstamo fue pasado a En Deuda.");
		return this.prestamos.get(aux);
	}

	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
	}

	
	

}