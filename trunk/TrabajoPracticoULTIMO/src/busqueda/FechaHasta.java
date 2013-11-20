package busqueda;

import java.util.GregorianCalendar;

import prestamo.Prestamo;

public class FechaHasta extends Filtro {

	private GregorianCalendar fecha;
	
	public FechaHasta (GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public boolean filtrarPor(Prestamo p) {
		return (this.fecha.after(p.getFechaPrestamo()));
	}
}
