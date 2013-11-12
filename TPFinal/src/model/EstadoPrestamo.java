package model;



import java.util.List;

abstract class EstadoPrestamo {
	
	abstract public List<Cuota> pagarCuota(Prestamo p, List<Cuota> c);
	public boolean estaEnDeuda(){
		return false;
	}
	public boolean estaEnCurso(){
		return false;
	}

}
