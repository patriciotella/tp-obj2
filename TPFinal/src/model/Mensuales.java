package model;

public class Mensuales extends Gastos{
	
	float coefPorcentual;
	float coefFijo;
	//IMPLEMENTAR SUBCLASES PORCENTUALES Y VALOR FIJO
	public float recotizarValor (float cuota){
		float aux=0;
		if( coefFijo != 0){
			aux=cuota + coefFijo;
		}else{
			if(coefPorcentual != 0){
				aux= (cuota+ cuota*coefPorcentual);
			}
		}
		return aux;
	}

}
