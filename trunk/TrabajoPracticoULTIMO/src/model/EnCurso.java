package model;



import java.util.List;

public class EnCurso extends EstadoPrestamo{

	public void pagarCuota(List<Cuota> cs, int i) {
		for (Cuota c : cs) {
			if(c.getNroCuota() == i){
				c.pagarCuota();
			}
		}
	}
	
	public boolean estaEnCurso(){
		return false;
	}



}
