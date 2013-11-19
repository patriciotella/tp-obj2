package cliente;
/**
 * Esta clase ....
 * @author Ángeles, Juan Pablo, Adrián
 */
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private List<Prestamo> prestamos;
	private ClienteState estado;
	boolean notificacionDeVencimientos= false;
	
	public Cliente(String nombre, String apellido, String dni, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.prestamos = new ArrayList<Prestamo>();
		this.estado = new ClienteConPermiso();
	}
	
	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
		this.chequearCondicion();
	}

	public boolean aptoParaPedirPrestamo() {
		return this.estado.aptoParaPedirPrestamo();
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

	public String getApellido() {
		return apellido;
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

	public void pagarCuota(Prestamo p) throws Exception{
		int posicionPrestamo= prestamos.indexOf(p);
		prestamos.get(posicionPrestamo).pagarCuota();
	}


	public void pasarARechazado(Prestamo p) {
		p.cambiarEstadoARechazado();
		System.out.println("El préstamo ha sido rechazado.");
	}

	public void pasarAAprobado(Prestamo p) throws InstallmentCountException, InvalidAmountException {
		p.cambiarEstadoAEnCursoYAplicarCG();
		System.out.println("El préstamo ha sido aprobado.");
		
	}

	public void pasarAEnDeuda(Prestamo p) {
		p.cambiarEstadoAEnDeuda();
		System.out.println("El préstamo fue pasado a En Deuda.");
	}

	public void solicitarPrestamo(Prestamo p){
		this.estado.solicitarPrestamo(this, p);
	}

	private void setEstadoASinPermiso() {
		this.estado = new ClienteSinPermiso();
	}
}