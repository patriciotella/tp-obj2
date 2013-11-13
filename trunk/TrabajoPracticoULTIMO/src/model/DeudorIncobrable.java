package model;



import java.util.List;

public class DeudorIncobrable extends EstadoPrestamo{

	@Override
	public boolean estaEnDeuda() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void pagarCuota(List<Cuota> c, int nro) {
		// pasa a en curso?
		
	}

}
