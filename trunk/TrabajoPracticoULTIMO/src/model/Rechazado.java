package model;

public class Rechazado extends EstadoPrestamo{

	public void pagarCuota(Prestamo p, Cuota c) {
		System.out.println("Su pr�stamo ha sido rechazado, no puede pagar ninguna cuota.");
		
	}
}


