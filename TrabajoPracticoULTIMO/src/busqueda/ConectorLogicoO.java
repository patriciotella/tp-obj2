package busqueda;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;


public class ConectorLogicoO {
	
	private List<Busqueda> busquedas;
		
	public ConectorLogicoO() {
		this.busquedas = new ArrayList<Busqueda>();
	}

	public void addBusqueda(Busqueda b){
		this.busquedas.add(b);
	}
		
	public boolean filtrarPor(Prestamo p) {	
		boolean b = false;
		for (Busqueda e : busquedas) {
			b = b || e.filtrarPor(p);
		}	
		return b;
	}

	public List<Busqueda> getBusquedas() {
		return this.busquedas;
	}
}
