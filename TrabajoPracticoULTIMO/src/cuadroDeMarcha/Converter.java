package cuadroDeMarcha;

import prestamo.Prestamo;

public abstract class Converter {
	
	protected String file;
	
	/**
	 * Devuelve un string conteniendo la información del préstamo
	 * en el formato indicado (XML o HTML).
	 * @param p Préstamo a cargar.
	 */
	public abstract String loadFile(Prestamo p);

}
