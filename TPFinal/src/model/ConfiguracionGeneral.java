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
	public TEM getTem() {
		return tem;
	}
	public float recotizarValorGlobal(float monto) {
		return this.gastoGlobal.recotizarValor(monto);
	}
	public float recotizarValorMensual(float cuotaBase) {
		// TODO Auto-generated method stub
		return (this.gastoMensual.recotizarValor(cuotaBase));
	}
	public float recotizarTEM(float cuotaBase, int cantidadCuotas) {
		// TODO Auto-generated method stub
		return (this.tem.recotizarValor(cuotaBase, cantidadCuotas));
	}

}
