package Busquedas;

import java.util.ArrayList;
import java.util.List;

import model.Prestamo;

public class ConectorLogicoY extends Busqueda {

	private List<Busqueda> busquedas;
	
	public ConectorLogicoY() {
		this.busquedas = new ArrayList<Busqueda>();
	}

	public void addBusqueda(Busqueda b){
		this.busquedas.add(b);
	}

	public boolean filtrarPor(Prestamo p) {
		boolean b = true;
		for (Busqueda e : busquedas) {
			b = b & e.filtrarPor(p);
		}
		return b;
	}

}
