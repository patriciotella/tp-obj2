package model;



import java.util.List;

public class Finalizado extends EstadoPrestamo{

	@Override
	public void pagarCuota(List<Cuota> c, int nro) {
		System.out.println("Su pr�stamo ha sido finalizado, no hay m�s cuotas que pagar.");
		
	}

}
