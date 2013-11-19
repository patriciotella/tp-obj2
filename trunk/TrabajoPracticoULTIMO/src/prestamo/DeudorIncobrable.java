package prestamo;

import cuota.Cuota;

public class DeudorIncobrable extends EstadoPrestamo{

	public boolean estaEnDeuda() {
		return true;
	}

	public void pagarCuota(Prestamo p, Cuota c) throws Exception {
		throw new Exception("No puede pagar cuotas, es deudor incobrable");
	}
}
