package model;

public class DeudorIncobrable extends EstadoPrestamo{

	public boolean estaEnDeuda() {
		return true;
	}

	public void pagarCuota(Prestamo p, Cuota c) {
		// pasa a en curso?
		
	}

}
