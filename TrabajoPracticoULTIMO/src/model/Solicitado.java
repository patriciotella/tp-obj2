package model;

public class Solicitado extends EstadoPrestamo{

	public void pagarCuota(Prestamo p, Cuota c) throws Exception {
		throw new Exception("No puede pagar cuotas, el pr�stamo todav�a no fue aprobado");
		
	}


}
