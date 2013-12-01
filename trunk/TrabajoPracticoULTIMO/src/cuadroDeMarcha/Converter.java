package cuadroDeMarcha;

import prestamo.Prestamo;

public abstract class Converter {
	
	protected String file;
	
	/**
	 * Devuelve un string conteniendo la informaci�n del pr�stamo
	 * en el formato indicado (XML o HTML).
	 * @param p Pr�stamo a cargar.
	 */
	public abstract String loadFile(Prestamo p);

}
