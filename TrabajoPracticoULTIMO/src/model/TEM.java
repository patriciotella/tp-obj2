package model;

public class TEM {

	//preguntar por enunciado. porcentajes se pasan por parametro?
	
	public float recotizarValor(float cuota, int cantidadCuotas) {
		float aux = cuota + (cuota * this.darPorcentaje(cantidadCuotas));
		return aux;
	}
	
	private float darPorcentaje(int cantidadCuotas){
		float aux = 0;
		if(cantidadCuotas <= 12){
			aux = (float) 0.03;
		}
		if(cantidadCuotas <= 18){
			aux = (float) 0.045;
		}
		if(cantidadCuotas <= 24){
			aux = (float) 0.06;
		}
		if(cantidadCuotas <= 36){
			aux = (float) 0.09;
		}else{
			aux = (float) 0.1;
		}
		return aux;
	}

}
