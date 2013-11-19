package prestamo;

import model.Cuota;

public class EnDeuda extends EstadoPrestamo{

	public boolean estaEnDeuda() {
		return true;
	}

	public void pagarCuota(Prestamo p, Cuota c) {
		c.pagarCuota();
		p.chequearEstado();
	}

}
