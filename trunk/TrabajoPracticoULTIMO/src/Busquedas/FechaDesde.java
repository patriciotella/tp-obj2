package Busquedas;

import java.util.GregorianCalendar;

import model.Prestamo;

public class FechaDesde extends Filtro {

	private GregorianCalendar fecha;

	public FechaDesde(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public boolean filtrarPor(Prestamo p) {
		return (this.fecha.before(p.getFechaPrestamo()));
	}
}
