package configuracionGeneral;

public class MensualesPorcentuales extends Mensuales{
	
	public MensualesPorcentuales(float c){
		this.valor = c;
	}
	
	public float recotizarValor(float cuota){
		float aux = cuota + (cuota * this.valor);
		return aux;
	}

}
