package model;

import java.util.ArrayList;
import java.util.List;

import Busquedas.Busqueda;

public class ConectorLogico extends Busqueda {

	private List<Busqueda> busquedas;
	
	public ConectorLogico() {
		this.busquedas = new ArrayList<Busqueda>();
	}

	public void addBusqueda(Busqueda b){
		this.busquedas.add(b);
	}
	@Override
	public boolean filtrarPor(Prestamo p) {
		boolean b = true;
		for (Busqueda e : busquedas) {
			b = b & e.filtrarPor(p);
		}
		return b;
	}

}
