package cuadroDeMarcha;

import prestamo.Prestamo;

public abstract class Converter {
	
	protected String file;
	
	public abstract String loadFile(Prestamo p);

}
