package model;



import java.util.List;

public class EnCurso extends EstadoPrestamo{

	public List<Cuota> pagarCuota(Prestamo p, List<Cuota> c) {
		List<Cuota> cAux= c;
		cAux.remove(0);
		return cAux;
	}
	
	public boolean estaEnCurso(){
		return false;
	}



}
