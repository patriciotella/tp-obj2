package gastos;

import java.util.Calendar;

import model.TEM;

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