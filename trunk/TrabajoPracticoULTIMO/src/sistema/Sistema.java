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
	
	List<Prestamo> prestamos;
	List<Prestamo> prestamosEnEstadoSolicitado;
	List<Cliente> clientes;
	SeguroDeVida seguro; //		+++VER+++
	List<ConfiguracionGeneral> configuraciones;
	
	public Sistema() {
		this.prestamos = new ArrayList<Prestamo>();
		this.prestamosEnEstadoSolicitado = new ArrayList<Prestamo>();
		this.clientes = new ArrayList<Cliente>();
	}

	public void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	public void aprobarPrestamo(Prestamo p) throws InstallmentCountException, InvalidAmountException{
		Cliente clienteAux = this.buscarClienteConPrestamo(p);
		clienteAux.pasarAAprobado(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.agregarPrestamo(p);
	}

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

	public List<Prestamo> buscarPor(Busqueda b){
		List<Prestamo> ret = new ArrayList<Prestamo>();
		for (Prestamo p : prestamos) {
			if(b.filtrarPor(p))
				ret.add(p);
		}
		return ret;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public List<Prestamo> getPrestamosEnEstadoSolicitado() {
		return prestamosEnEstadoSolicitado;
	}

	public void pasarPrestamoAEnDeuda(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		clienteConPrestamo.pasarAEnDeuda(p);
	}

	public List<Prestamo> pendientesDeAprobacion(){
		return this.prestamosEnEstadoSolicitado;
	}
	
	public List<Prestamo> posiblesDeudores(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			if(p.tieneCuotasVencidas()) aux.add(p);
		}
		return aux;
	}
	
	public List<Prestamo> posiblesDeudoresIncobrables(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			if(p.estaEnDeuda()){
				aux.add(p);
			}
		}
		return aux;
	}
	
	public void procesarPrestamo(Cliente c, Prestamo p){
		if(c.aptoParaPedirPrestamo()){
			c.agregarPrestamo(p);
			this.agregarCliente(c);
			this.prestamosEnEstadoSolicitado.add(p);
		}
	}

	public void rechazarPrestamo(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.prestamos.add(p);
		clienteConPrestamo.pasarARechazado(p);
	}

	private void agregarCliente(Cliente c) {
		if(!this.clientes.contains(c)){
			this.clientes.add(c);
		}
	}

	private Cliente buscarClienteConPrestamo(Prestamo p) {
		Cliente aux = null;
		for (Cliente c : this.clientes) {
			if(c.getPrestamos().contains(p)){
				aux = c;
			}
		}
		return aux;
	}
}
