package model;

public class Finalizado extends EstadoPrestamo{

	@Override
	public void pagarCuota(Prestamo p, Cuota c) {
		System.out.println("Su préstamo ha sido finalizado, no hay más cuotas que pagar.");
		
	}

}
