package model;



import java.util.List;

public class DeudorIncobrable extends EstadoPrestamo{

	@Override
	public List<Cuota> pagarCuota(Prestamo p, List<Cuota> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaEnDeuda() {
		// TODO Auto-generated method stub
		return true;
	}

}
