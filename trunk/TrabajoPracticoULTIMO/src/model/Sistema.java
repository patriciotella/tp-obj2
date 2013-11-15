package model;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Busquedas.Busqueda;
import Busquedas.DniCliente;
import Busquedas.MontoDesde;

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

	private void agregarPrestamo(Prestamo p){
		prestamos.add(p);
	}

	public void aprobarPrestamo(Prestamo p) throws InstallmentCountException, InvalidAmountException{
		Cliente clienteAux = this.buscarClienteConPrestamo(p);
		clienteAux.pasarAAprobado(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		this.agregarPrestamo(p);
	}

	public void atenderCliente(int monto, int cuotas){
			String s = ""; 
			Scanner reader = new Scanner(System.in);
			int cuotasAgregadas = cuotas;
			System.out.print("Tu préstamo de $" + monto + " se dividirá en " + cuotas + " cuotas de $" + 
					this.calcularCuotas(monto,cuotas) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere más cuotas: ");
			s = reader.nextLine();
			
			while(s.equals("no")){
				cuotasAgregadas += 3;
				System.out.print("Tu préstamo de $" + monto + " se dividirá en " + (cuotasAgregadas)+ " cuotas de $" + 
						this.calcularCuotas(monto,(cuotasAgregadas)) + ". Pulse 'si' si esta de acuerdo o 'no' si quiere más cuotas: ");
				s = reader.nextLine();
			}
			if(s.equals("si")){
				System.out.println("Tu prestamo ideal seria de $" + monto + ", dividido en " + cuotasAgregadas + " cuotas de $" + this.calcularCuotas(monto, cuotasAgregadas));
			}
			reader.close();
	}

	public List<Prestamo> buscarPor(Busqueda b){
		List<Prestamo> ret = new ArrayList<Prestamo>();
		for (Prestamo p : prestamos) {
			if(b.filtrarPor(p))
				ret.add(p);
		}
		return ret;
	}

	public void pasarPrestamoAEnDeuda(Prestamo p){
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		int iAux = this.prestamos.indexOf(p);
		Prestamo pAux = clienteConPrestamo.pasarAEnDeuda(p);
	}

	public List<Prestamo> pendientesDeAprobacion(){
		return this.prestamosEnEstadoSolicitado;
	}
	
	public List<Prestamo> posiblesDeudores(){
		List<Prestamo> aux = new ArrayList<Prestamo>();
		for (Prestamo p : this.prestamos) {
			// IMPLEMENTAR
			// preguntar si tiene alguna cuota vencida
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
		// se pasa a otra lista o se borra?
		clienteConPrestamo.pasarARechazado(p);
	}

	private void agregarCliente(Cliente c) {
		if(!this.clientes.contains(c)){
			this.clientes.add(c);
		}
	}

	private Cliente buscarClienteConPrestamo(Prestamo p) {
		// privado?
		Cliente aux = null;
		for (Cliente c : this.clientes) {
			if(c.getPrestamos().contains(p)){
				aux = c;
			}
		}
		return aux;
	}

	private int calcularCuotas(int monto, int cuotas) {
		return (monto/cuotas);
	}
	
	public static void main(String[] args) {
		Sistema s = new Sistema();
		/*DniCliente dni = new DniCliente(374);
		MontoDesde monto = new MontoDesde(3000);
		ConectorLogico conector = new ConectorLogico();
		conector.addBusqueda(dni);
		conector.addBusqueda(monto);
		Cliente c1 = new Cliente("adrian", "juri", 374, "lincoln");
		Cliente c2 = new Cliente("Marito", "juri", 374, "lincoln");
		ConfiguracionGeneral conf = new ConfiguracionGeneral();
		SeguroDeVida sv = new SeguroDeVida();
		Prestamo p1 = new Prestamo(1, 5000, 15, conf, sv, c1);
		Prestamo p2 = new Prestamo(2, 4000, 10, conf, sv, c1);
		Prestamo p3 = new Prestamo(3, 3000, 20, conf, sv, c2);
		Prestamo p4 = new Prestamo(4, 1000, 20, conf, sv, c2);
		s.agregarPrestamo(p1);
		s.agregarPrestamo(p2);
		s.agregarPrestamo(p3);
		s.agregarPrestamo(p4);
		List<Prestamo> l1 = s.buscarPor(conector);
		for (Prestamo e : l1) {
			System.out.println(e.getId());
		}*/
		s.atenderCliente(12000, 12);
	}
}
