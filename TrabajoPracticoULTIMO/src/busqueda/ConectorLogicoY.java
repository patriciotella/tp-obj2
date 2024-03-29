package busqueda;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;

public class ConectorLogicoY extends Busqueda {

	private List<Busqueda> busquedas;
	
	public ConectorLogicoY() {
		this.busquedas = new ArrayList<Busqueda>();
	}

	public void addBusqueda(Busqueda b){
		this.busquedas.add(b);
	}
	
	public List<Busqueda> getBusquedas(){
		return this.busquedas;
	}

	public boolean filtrarPor(Prestamo p) {
		boolean b = true;
		for (Busqueda e : busquedas) {
			b = b & e.filtrarPor(p);
		}
		return b;
	}

}
