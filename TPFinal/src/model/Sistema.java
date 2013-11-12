package model;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Sistema {
	
	List<Prestamo> prestamos;
	List<Prestamo> prestamosEnEstadoSolicitado;
	List<Cliente> clientes;
	SeguroDeVida seguro; //		+++VER+++
	List<ConfiguracionGeneral> configuraciones;
	
	public void atenderCliente(int monto, int cuotas){
			// SUBDIVIDIR!
			String s = ""; 
			Scanner reader = new Scanner(System.in);
			int cuotasAgregadas = cuotas;
			System.out.print("Tu prestamo de $" + monto + " se dividira en " + cuotas + " cuotas de $" + 
					this.calcularCuotas(monto,cuotas) + ". Pulse 'yeah' si esta de acuerdo o 'no' si quiere mas cuotas: ");
			s = reader.nextLine();
			
			while(s.equals("no")){
				cuotasAgregadas += 3;
				System.out.print("Tu prestamo de $" + monto + " se dividira en " + (cuotasAgregadas)+ " cuotas de $" + 
						this.calcularCuotas(monto,(cuotasAgregadas)) + ". Pulse 'yeah' si esta de acuerdo o 'no' si quiere mas cuotas: ");
				s = reader.nextLine();
			}
			if(s.equals("si")){
				System.out.println("Tu préstamo ideal sería de $" + monto + ", dividido en " + cuotasAgregadas + " cuotas de $" + this.calcularCuotas(monto, cuotasAgregadas));
			}
	}
			
	private int calcularCuotas(int monto, int cuotas) {
		return (monto/cuotas);
	}
	
	public void procesarPrestamo(Cliente c, int monto, int cuotas){
		Prestamo prestamoNuevo = new Prestamo(monto, cuotas);
		c.solicitarPrestamo(prestamoNuevo);
		this.prestamosEnEstadoSolicitado.add(prestamoNuevo);
		this.agregarCliente(c);
	}

	public void setearPrestamoEnDeudaOIncobrable(){
		
	}
	
//	public void buscarPor(Busqueda b){
//		
//	}
	
	public void aprobarPrestamo ( Prestamo p){
		//recibe un prestamo en estado solicitado y lo pasa a en curso, agregandole los
		//gastos correspondientes.
		Cliente clienteAux = this.buscarClienteConPrestamo(p);
		clienteAux.pasarAAprobado (p);
		this.prestamosEnEstadoSolicitado.remove(p);
	}
	
	private void agregarCliente(Cliente c) {
		int aux = this.clientes.indexOf(c);
		if(aux == -1){
			this.clientes.add(c);
		}else{
			this.clientes.add(aux, c);
			// es necesario pisarlo? se actualiza la informacion sola?
		}
	}
	
//	public void procesarPrestamo(Cliente c, Prestamo p){
//		
//	}
	
	public void rechazarPrestamo(Prestamo p){
		int aux = this.prestamosEnEstadoSolicitado.indexOf(p);
		Cliente clienteConPrestamo = this.buscarClienteConPrestamo(p);
		this.prestamosEnEstadoSolicitado.remove(p);
		// se pasa a otra lista o se borra?
		((Cliente) clienteConPrestamo).pasarARechazado(p); // tiraba error y asi dejo de chillar
		// revisar. cliente es el encargado de hacer esto?
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
	
//	public void buscarPor(Busqueda b){
//		
//	}
	
	public void getPrestamo(){
		
	}
	
	public void prestamosPendientesDeAprobacion(){
		
	}
	
	public void posiblesDeudores(){
		
	}
	
	public void posiblesDeudoresIncobrables(){
		
	}
	
	public static void main(String[] args) {
		Sistema s = new Sistema();
		s.atenderCliente(12000, 12);
//		{
//			Scanner c = new Scanner(System.in);
//			Sistema sy = new Sistema();
//			String x = "";
//				System.out.print("Teclee n o y");
//				x = c.nextLine();
//				if(x.equals("n")){
//					System.out.println("anda n");
//				}
//		}
	}
}
