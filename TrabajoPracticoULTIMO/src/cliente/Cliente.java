package cliente;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;


public abstract class Cliente {
	
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected String domicilio;
	protected List<Prestamo> prestamos;
	protected ClienteState estado;
	protected boolean notificacionDeVencimientos= false;
	
	public Cliente(String nombre, String apellido, String dni, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.prestamos = new ArrayList<Prestamo>();
		this.estado = new ClienteConPermiso();
	}
	
	public abstract String getApellido();
	
	public abstract String getDni();
		
	public ClienteState getEstado() {
		return this.estado;
	}

	public List<Prestamo> getPrestamos(){
			return this.prestamos;
		}

	public abstract void agregarPrestamo(Prestamo p);

	public boolean aptoParaPedirPrestamo() {
		return this.estado.aptoParaPedirPrestamo();
	}

	public abstract void chequearCondicion();

	public void pagarCuota(Prestamo p) throws Exception{
		int posicionPrestamo= prestamos.indexOf(p);
		prestamos.get(posicionPrestamo).pagarCuota();
	}


	public void pasarARechazado(Prestamo p) {
		p.cambiarEstadoARechazado();
	}

	public void pasarAAprobado(Prestamo p) throws InstallmentCountException, InvalidAmountException {
		p.cambiarEstadoAEnCursoYAplicarCG();
		
	}

	public void pasarAEnDeuda(Prestamo p) {
		p.cambiarEstadoAEnDeuda();
	}

	public void solicitarPrestamo(Prestamo p) throws Exception{
		this.estado.solicitarPrestamo(this, p);
	}

	protected void setEstadoASinPermiso() {
		this.estado = new ClienteSinPermiso();
	}
}