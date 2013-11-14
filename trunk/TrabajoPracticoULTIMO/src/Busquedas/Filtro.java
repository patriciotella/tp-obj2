package Busquedas;

import model.Prestamo;

public abstract class Filtro extends Busqueda{
	
	public abstract boolean filtrarPor(Prestamo p);

}
