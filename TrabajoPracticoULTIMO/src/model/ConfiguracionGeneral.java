package model;

import java.util.Calendar;

public class ConfiguracionGeneral {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Gastos gastoMensual;
	private Gastos gastoGlobal;
	private TEM tem;
	
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	public Gastos getGastoMensual() {
		return gastoMensual;
	}
	
	public Gastos getGastoGlobal() {
		return gastoGlobal;
	}
	
	public float getTem() {
		return tem.getCoef();
	}

	public float recotizarValorGlobal(float monto) {
		return this.gastoGlobal.recotizarValor(monto);
	}
	
	public float recotizarValorMensual(float cuota) {
		return (this.gastoMensual.recotizarValor(cuota));
	}

}