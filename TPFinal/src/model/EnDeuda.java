package model;



import java.util.List;

public class EnDeuda extends EstadoPrestamo{

	@Override
	public List<Cuota> pagarCuota(Prestamo p, List<Cuota> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaEnDeuda() {
		return true;
	}

}
