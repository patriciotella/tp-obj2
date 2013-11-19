package configuracionGeneral;


public class MensualesPorcentuales extends Mensuales{
	
	public MensualesPorcentuales(float c){
		this.coef = c;
	}
	
	public float recotizarValor(float cuota){
		float aux = cuota + (cuota * this.coef);
		return aux;
	}

}
