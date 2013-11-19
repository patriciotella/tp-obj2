package prestamo;

import cuota.Cuota;

public class Finalizado extends EstadoPrestamo{

	public void pagarCuota(Prestamo p, Cuota c) throws Exception {
		throw new Exception("No puede pagar cuotas, el préstamo finalizó");
	}

}
