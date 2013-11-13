package model;

public class TEM {
	
	private float coef;
	
	public TEM(float c){
		this.coef = c;
	}
	
	public float getCoef(){
		return (float) this.coef;
	}
	
	/*public float recotizarValor(float cuota, int cantidadCuotas) {
		float aux = cuota + (cuota * this.darPorcentaje(cantidadCuotas));
		return aux;
	}
	
	private float darPorcentaje(int cantidadCuotas){
		float aux = 0;
		return aux;
	}*/

}
