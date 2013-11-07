package model;

import java.sql.Date;
import java.util.Calendar;

public class Cuota {
	
	private int nroDeCuota;
	private float valorCuota;
	private Calendar fechaDeInicio = Calendar.getInstance();
	private Calendar fechaDeVencimiento = Calendar.getInstance();
	private Calendar fechaDePago;
	private float amortizacion;
	private float interes;
	private float saldoDeDeuda;
	private float valorTotalDeCuota;
	private float TEM;
	private float seguroDeVida;
	private float coeficienteSeguro;
	private float gastosMensuales;
	
	
	
	public Cuota(float valorCuota, int nroDeCuota, Calendar fechaDeInicioPrestamo) {
		this.valorCuota = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.fechaDeInicio = fechaDeInicioPrestamo;
		this.calcularAmortizacion();
		this.calcularVencimiento(fechaDeInicioPrestamo);
	}

	private void calcularAmortizacion(){
		this.amortizacion = this.valorCuota - this.interes;
	}
	
	private void calcularVencimiento(Calendar fechaDeInicioPrestamo){
		if(this.nroDeCuota == 1 && (fechaDeInicioPrestamo.DAY_OF_MONTH <= 15)){
			this.fechaDeInicio.add(fechaDeInicioPrestamo.DAY_OF_MONTH, 30);
		}else{
			this.fechaDeInicio.add(fechaDeInicioPrestamo.DAY_OF_MONTH, (this.nroDeCuota * 30));
		}
	}
	
	public float verInteres(){
		return (this.saldoDeDeuda * this.TEM);
	}
	
	public float verSaldoDeDeuda(){
		return (this.saldoDeDeuda - this.amortizacion);
	}
	
	public float verSeguroDeVida(){
		return (this.saldoDeDeuda * coeficienteSeguro);
	}
	
	public float verGastosMensuales(){
		return this.gastosMensuales;
	}
	
	public float verValorCuota(){
		return this.valorCuota;
	}
	
	public float verValorTotalDeCuota(){
		return this.valorTotalDeCuota;
	}
	
	public Calendar verFechaDePago(){
		return this.fechaDePago;
	}
	
	

}
