package model;



import java.util.List;

public abstract class EstadoPrestamo {
	
	abstract public void pagarCuota(List<Cuota> c, int nro);
	
	public boolean estaEnDeuda(){
		return false;
	}
	public boolean estaEnCurso(){
		return false;
	}

}
