package model;

public abstract class EstadoPrestamo {
	
	abstract public void pagarCuota(Prestamo p, Cuota c);
	
	public boolean estaEnDeuda(){
		return false;
	}
	public boolean estaEnCurso(){
		return false;
	}


}
