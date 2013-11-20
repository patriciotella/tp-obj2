package configuracionGeneral;

public class MensualesValorFijo extends Mensuales{
	
	public MensualesValorFijo(float c){
		this.valor = c;
	}
	
	public float recotizarValor(float cuota){
		float aux = cuota + this.valor;
		return aux;
	}

}
