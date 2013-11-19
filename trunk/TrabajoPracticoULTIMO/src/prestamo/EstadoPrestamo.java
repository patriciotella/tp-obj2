package prestamo;

import cuota.Cuota;

public abstract class EstadoPrestamo {
	
	abstract public void pagarCuota(Prestamo p, Cuota c) throws Exception;
	
	public boolean estaEnDeuda(){
		return false;
	}
	public boolean estaEnCurso(){
		return false;
	}


}
