package model;



import java.util.List;

public class Rechazado extends EstadoPrestamo{

	@Override
	public void pagarCuota(List<Cuota> c, int nro) {
		System.out.println("Su préstamo ha sido rechazado, no puede pagar ninguna cuota.");
		
	}
}


