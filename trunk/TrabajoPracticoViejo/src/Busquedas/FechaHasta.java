package Busquedas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Prestamo;

public class FechaHasta extends Filtro {

	private GregorianCalendar date;
	
	
	public FechaHasta (GregorianCalendar date) {
		this.date = date;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.date.after(p.getFechaPrestamo()));
	}
}
