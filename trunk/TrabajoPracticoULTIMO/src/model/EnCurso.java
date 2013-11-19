package model;

public class EnCurso extends EstadoPrestamo{

	public void pagarCuota(Prestamo p, Cuota c) {
		c.pagarCuota();
	}
	
	public boolean estaEnCurso(){
		return true;
	}

}
