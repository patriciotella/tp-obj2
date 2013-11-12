package Busquedas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Prestamo;

public class FechaDesde extends Filtro {

	private GregorianCalendar date;
	
	
	public FechaDesde(GregorianCalendar date) {
		super();
		this.date = date;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.date.before(p.getFechaPrestamo()));
	}
}
