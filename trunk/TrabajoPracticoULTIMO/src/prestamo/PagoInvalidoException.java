package prestamo;

@SuppressWarnings("serial")
public class PagoInvalidoException extends Exception {

	public PagoInvalidoException(String mensaje) {
		super(mensaje);
	}

}
