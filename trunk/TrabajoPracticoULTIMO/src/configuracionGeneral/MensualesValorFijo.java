package configuracionGeneral;


public class MensualesValorFijo extends Mensuales{
	
	public MensualesValorFijo(float c){
		this.coef = c;
	}
	
	public float recotizarValor(float cuota){
		float aux = cuota + this.coef;
		return aux;
	}

}
