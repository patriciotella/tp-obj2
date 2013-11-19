package configuracionGeneral;


public class GlobalesPorcentuales extends Globales{

	public GlobalesPorcentuales(float c){
		this.coef = c;
	}
	
	public float recotizarValor(float monto) {
		float aux = monto - (monto * this.coef); // MULTIPLICAR POR PORCENTAJE 
		return aux;
	}

}
