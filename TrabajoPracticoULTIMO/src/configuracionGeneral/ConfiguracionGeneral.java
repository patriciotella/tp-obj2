package configuracionGeneral;

import java.util.Calendar;

public class ConfiguracionGeneral {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Gastos gastoMensual;
	private Gastos gastoGlobal;
	private TEM tem;
	
	public ConfiguracionGeneral(Calendar fechaInicio, Calendar fechaFin, Gastos gastosMensuales, Gastos gastosGlobales, TEM tem){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.gastoMensual = gastosMensuales;
		this.gastoGlobal = gastosGlobales;
		this.tem = tem;
	}
	
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	public float getGastoMensual() {
		return this.gastoMensual.getValor();
	}

	public float getTem() {
		return tem.getTEM();
	}

	public float recotizarValorGlobal(float monto) {
		return this.gastoGlobal.recotizarValor(monto);
	}
	
	public float recotizarValorMensual(float cuota) {
		return (this.gastoMensual.recotizarValor(cuota));
	}

}