package model;

public class Finalizado extends EstadoPrestamo{

	@Override
	public void pagarCuota(Prestamo p, Cuota c) {
		System.out.println("Su pr�stamo ha sido finalizado, no hay m�s cuotas que pagar.");
		
	}

}
