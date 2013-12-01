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
	 * Agrega un pr�stamo a la lista luego de haber sido aprobado.
	 * @param p Pr�stamo en estado EnCurso.
	 */
	private void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	/**
	 * Aprueba un pr�stamo p, sac�ndolo de la lista de pr�stamos solicitados y pas�ndolo a la lista de pr�stamos regulares.
	 * @param p Pr�stamo a aprobar.
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
//			System.out.print("Tu pr�stamo de $" + monto + " se dividir� en " + cuotas + " cuotas de $" + 
//					this.calcularCuotas(monto,cuotas) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere m�s cuotas: ");
//			s = reader.nextLine();
//			
//			while(s.equals("no")){
//				cuotasAgregadas += 3;
//				System.out.print("Tu pr�stamo de $" + monto + " se dividir� en " + (cuotasAgregadas)+ " cuotas de $" + 
//						this.calcularCuotas(monto,(cuotasAgregadas)) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere m�s cuotas: ");
//				s = reader.nextLine();
//			}
//			if(s.equals("si")){
//				System.out.println("Tu prestamo ideal seria de $" + monto + ", dividido en " + cuotasAgregadas + " cuotas de $" + this.calcularCuotas(monto, cuotasAgregadas));
//			}
//			reader.close();
	}

	/**
	 * Realiza una b�squeda de acuerdo al par�metro indicado y retorna una lista de pr�stamos que cumplen con esa condici�n.
	 * @param b Par�metro de b�squeda (ej: ApellidoCliente, DniCliente, etc.)
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
	 * Retorna la lista de pr�stamos regulares incluida en el sistema.
	 */
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	/**
	 * Retorna la lista de pr�stamos en estado solicitado incluida en el sistema.
	 */
	public List<Prestamo> getPrestamosEnEstadoSolicitado() {
		return prestamosEnEstadoSolicitado;
	}

	/**
	 * Cambia el estado del pr�stamo a EnDeuda.
	 * @param p Pr�stamo a pasar a EnDeuda.
	 */
	public void pasarPrestamoAEnDeuda(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		clienteConPrestamo.pasarAEnDeuda(p);
	}

	/**
	 * Retorna la lista de pr�stamos que podr�an ser deudores.
	 */
	public List<Prestamo> posiblesDeudores(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			if(p.tieneCuotasVencidas()) aux.add(p);
		}
		return aux;
	}
	
	/**
	 * Retorna la lista de pr�stamos que podr�an ser deudores incobrables.
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
	 * Agrega el pr�stamo pasado por par�metro a la lista de pr�stamos en estado solicitado.
	 * @param c Cliente relacionado con el pr�stamo.
	 * @param p Pr�stamo a procesar.
	 */
	public void procesarPrestamo(Cliente c, Prestamo p){
		if(c.aptoParaPedirPrestamo()){
			c.agregarPrestamo(p);
			this.agregarCliente(c);
			this.prestamosEnEstadoSolicitado.add(p);
		}
	}

	/**
	 * Rechaza un pr�stamo, sac�ndolo de la lista de pr�stamos en estado solicitado y pas�ndolo a la lista de pr�stamos regulares.
	 * Notifica a su cliente que el pr�stamo ha sido rechazado.
	 * @param p Pr�stamo a rechazar.
	 */
	public void rechazarPrestamo(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.agregarPrestamo(p);
		clienteConPrestamo.pasarARechazado(p);
	}

	/**
	 * Agrega a un cliente que solicit� un pr�stamo a la lista de clientes contenida por el sistema.
	 * @param c Cliente a agregar.
	 */
	private void agregarCliente(Cliente c) {
		if(!this.clientes.contains(c)){
			this.clientes.add(c);
		}
	}

	/**
	 * Realiza una b�squeda de acuerdo al par�metro indicado y retorna una lista de clientes que cumplen con esa condici�n.
	 * @param b Par�metro de b�squeda (ej: ApellidoCliente, DniCliente, etc.)
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
