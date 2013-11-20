package configuracionGeneral;

import java.util.Calendar;

public class ConfiguracionGeneral {
	
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Gastos gastoMensual;
	private Gastos gastoGlobal;
	private TEM tem;
	
	public ConfiguracionGeneral(Calendar fi, Calendar ff, Gastos m, Gastos g, TEM t){
		this.fechaInicio = fi;
		this.fechaFin = ff;
		this.gastoMensual = m;
		this.gastoGlobal = g;
		this.tem = t;
	}
	
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	public float getGastoMensual() {
		return this.getGastoMensual();
	}

	public float getTem() {
		return tem.getTEM();
	}

	public float recotizarValorGlobal(float monto) {
		return this.gastoGlobal.recotizarValor(monto);
	}
	public Gastos getGastoGlobal(){
		return this.gastoGlobal;
	}
	
	public float recotizarValorMensual(float cuota) {
		return (this.gastoMensual.recotizarValor(cuota));
	}

}