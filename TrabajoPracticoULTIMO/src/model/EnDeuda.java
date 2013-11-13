package model;



import java.util.List;

public class EnDeuda extends EstadoPrestamo{

	@Override
	public boolean estaEnDeuda() {
		return true;
	}

	@Override
	public void pagarCuota(List<Cuota> c, int nro) {
		// pasa a en curso?
		
	}

}
