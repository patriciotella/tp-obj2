package model;



import java.util.List;

public class Solicitado extends EstadoPrestamo{


	@Override
	public void pagarCuota(List<Cuota> c, int nro) {
		System.out.println("Todav�a no puede pagar ninguna cuota.");
		
	}


}
