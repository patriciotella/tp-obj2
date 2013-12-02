package cliente;

import java.util.ArrayList;
import java.util.List;

import prestamo.PagoInvalidoException;
import prestamo.Prestamo;


public abstract class Cliente {
	
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected String domicilio;
	protected ClienteState estado;
	protected boolean notificacionDeVencimientos= false;
	protected ArrayList<Prestamo> prestamos;
	
	public Cliente(String nombre, String apellido, String dni, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.prestamos = new ArrayList<Prestamo>();
		this.estado = new ClienteConPermiso();
	}
	
	/**
	 * Agrega un préstamo a la lista de préstamos del cliente.
	 * @param p Préstamo a agregar.
	 */
	public abstract void agregarPrestamo(Prestamo p);

	/**
	 * Retorna el apellido o la razón social del cliente.
	 */
	public String getApellido() {
		return this.apellido;
	}
	
	/**
	 * Retorna el dni o el CUIT del cliente.
	 */
	public String getDni() {
		return this.dni;
	}
		
	/**
	 * Retorna el estado del cliente.
	 */
	public ClienteState getEstado() {
		return this.estado;
	}

	/**
	 * Retorna la lista de préstamos correspondiente al cliente.
	 */
	public List<Prestamo> getPrestamos(){
			return this.prestamos;
		}

	/**
	 * Retorna true si el cliente tiene permiso para pedir
	 * un préstamo.
	 */
	public boolean aptoParaPedirPrestamo() {
		return this.estado.aptoParaPedirPrestamo();
	}

	/**
	 * Chequea si el cliente tiene algún préstamo en deuda o si tiene
	 * dos préstamos en curso. En caso de ser así, cambia el estado
	 * a SinPermiso.
	 */
	public void chequearCondicion() {
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

	/**
	 * En caso de poder hacerlo, paga una cuota correspondiente
	 * al préstamo pasado por parámetro.
	 * @param p Préstamo con cuota a pagar.
	 */
	public void pagarCuota(Prestamo p) {
		int posicionPrestamo= prestamos.indexOf(p);
		prestamos.get(posicionPrestamo).pagarCuota();
	}

	/**
	 * Pasa el préstamo indicado por parámetro a estado Rechazado.
	 * @param p Préstamo con estado a cambiar.
	 */
	public void pasarARechazado(Prestamo p) {
		p.cambiarEstadoARechazado();
	}

	/**
	 * Pasa el préstamo indicado por parámetro a estado Aprobado.
	 * @param p Préstamo con estado a cambiar.
	 */
	public void pasarAAprobado(Prestamo p) {
		p.cambiarEstadoAEnCursoYAplicarCG();
		
	}

	/**
	 * Pasa el préstamo indicado por parámetro a estado EnDeuda.
	 * @param p Préstamo con estado a cambiar.
	 */
	public void pasarAEnDeuda(Prestamo p) {
		p.cambiarEstadoAEnDeuda();
	}

	/**
	 * En caso de tener permiso, solicita un préstamo y lo agrega a su lista.
	 * @param p Préstamo a solicitar.
	 */
	public void solicitarPrestamo(Prestamo p) {
		try {
		this.estado.solicitarPrestamo(this, p);
		} catch (PagoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cambia el estado del cliente a SinPermiso.
	 */
	protected void setEstadoASinPermiso() {
		this.estado = new ClienteSinPermiso();
	}
}