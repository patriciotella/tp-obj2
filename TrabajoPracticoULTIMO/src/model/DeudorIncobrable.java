package model;

public class DeudorIncobrable extends EstadoPrestamo{

	public boolean estaEnDeuda() {
		return true;
	}

	public void pagarCuota(Prestamo p, Cuota c) {
		System.out.println("Es deudor incobrable, no puede pagar ninguna cuota.");
	}

}
