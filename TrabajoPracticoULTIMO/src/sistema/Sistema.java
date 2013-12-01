package sistema;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import busqueda.Busqueda;
import busqueda.DniCliente;
import busqueda.MontoDesde;
import configuracionGeneral.ConfiguracionGeneral;
import cliente.Cliente;
import prestamo.Prestamo;
import seguroDeVida.SeguroDeVida;

@SuppressWarnings("unused")

public class Sistema {
	
	private List<Prestamo> prestamos;
	private List<Prestamo> prestamosEnEstadoSolicitado;
	private List<Cliente> clientes;
	private List<ConfiguracionGeneral> configuraciones;
	
	public Sistema() {
		this.prestamos = new ArrayList<Prestamo>();
		this.prestamosEnEstadoSolicitado = new ArrayList<Prestamo>();
		this.clientes = new ArrayList<Cliente>();
	}

	/**
	 * Agrega un préstamo a la lista luego de haber sido aprobado.
	 * @param p Préstamo en estado EnCurso.
	 */
	private void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	/**
	 * Aprueba un préstamo p, sacándolo de la lista de préstamos solicitados y pasándolo a la lista de préstamos regulares.
	 * @param p Préstamo a aprobar.
	 */
	public void aprobarPrestamo(Prestamo p) throws InstallmentCountException, InvalidAmountException{
		Cliente clienteAux = this.buscarClienteConPrestamo(p);
		clienteAux.pasarAAprobado(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.agregarPrestamo(p);
	}

	/**
	 * Muestra el valor de cuota posible para el monto y la cantidad de cuotas que indica el cliente.
	 * @param monto Monto a evaluar.
	 * @param cuotas Cantidad de cuotas a evaluar.
	 */
	public float atenderCliente(int monto, int cuotas){
		return monto/cuotas;
//			String s = ""; 
//			Scanner reader = new Scanner(System.in);
//			int cuotasAgregadas = cuotas;
//			System.out.print("Tu prï¿½stamo de $" + monto + " se dividirï¿½ en " + cuotas + " cuotas de $" + 
//					this.calcularCuotas(monto,cuotas) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere mï¿½s cuotas: ");
//			s = reader.nextLine();
//			
//			while(s.equals("no")){
//				cuotasAgregadas += 3;
//				System.out.print("Tu prï¿½stamo de $" + monto + " se dividirï¿½ en " + (cuotasAgregadas)+ " cuotas de $" + 
//						this.calcularCuotas(monto,(cuotasAgregadas)) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere mï¿½s cuotas: ");
//				s = reader.nextLine();
//			}
//			if(s.equals("si")){
//				System.out.println("Tu prestamo ideal seria de $" + monto + ", dividido en " + cuotasAgregadas + " cuotas de $" + this.calcularCuotas(monto, cuotasAgregadas));
//			}
//			reader.close();
	}

	/**
	 * Realiza una búsqueda de acuerdo al parámetro indicado y retorna una lista de préstamos que cumplen con esa condición.
	 * @param b Parámetro de búsqueda (ej: ApellidoCliente, DniCliente, etc.)
	 */
	public List<Prestamo> buscarPor(Busqueda b){
		List<Prestamo> ret = new ArrayList<Prestamo>();
		for (Prestamo p : prestamos) {
			if(b.filtrarPor(p))
				ret.add(p);
		}
		return ret;
	}

	/**
	 * Retorna la lista de clientes incluida en el sistema.
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * Retorna la lista de préstamos regulares incluida en el sistema.
	 */
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	/**
	 * Retorna la lista de préstamos en estado solicitado incluida en el sistema.
	 */
	public List<Prestamo> getPrestamosEnEstadoSolicitado() {
		return prestamosEnEstadoSolicitado;
	}

	/**
	 * Cambia el estado del préstamo a EnDeuda.
	 * @param p Préstamo a pasar a EnDeuda.
	 */
	public void pasarPrestamoAEnDeuda(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		clienteConPrestamo.pasarAEnDeuda(p);
	}

	/**
	 * Retorna la lista de préstamos que podrían ser deudores.
	 */
	public List<Prestamo> posiblesDeudores(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			if(p.tieneCuotasVencidas()) aux.add(p);
		}
		return aux;
	}
	
	/**
	 * Retorna la lista de préstamos que podrían ser deudores incobrables.
	 */
	public List<Prestamo> posiblesDeudoresIncobrables(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			if(p.estaEnDeuda()){
				aux.add(p);
			}
		}
		return aux;
	}
	
	/**
	 * Agrega el préstamo pasado por parámetro a la lista de préstamos en estado solicitado.
	 * @param c Cliente relacionado con el préstamo.
	 * @param p Préstamo a procesar.
	 */
	public void procesarPrestamo(Cliente c, Prestamo p){
		if(c.aptoParaPedirPrestamo()){
			c.agregarPrestamo(p);
			this.agregarCliente(c);
			this.prestamosEnEstadoSolicitado.add(p);
		}
	}

	/**
	 * Rechaza un préstamo, sacándolo de la lista de préstamos en estado solicitado y pasándolo a la lista de préstamos regulares.
	 * Notifica a su cliente que el préstamo ha sido rechazado.
	 * @param p Préstamo a rechazar.
	 */
	public void rechazarPrestamo(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.agregarPrestamo(p);
		clienteConPrestamo.pasarARechazado(p);
	}

	/**
	 * Agrega a un cliente que solicitó un préstamo a la lista de clientes contenida por el sistema.
	 * @param c Cliente a agregar.
	 */
	private void agregarCliente(Cliente c) {
		if(!this.clientes.contains(c)){
			this.clientes.add(c);
		}
	}

	/**
	 * Realiza una búsqueda de acuerdo al parámetro indicado y retorna una lista de clientes que cumplen con esa condición.
	 * @param b Parámetro de búsqueda (ej: ApellidoCliente, DniCliente, etc.)
	 */
	public Cliente buscarClienteConPrestamo(Prestamo p) {
		Cliente aux = null;
		for (Cliente c : this.clientes) {
			if(c.getPrestamos().contains(p)){
				aux = c;
			}
		}
		return aux;
	}
}
