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
	
	/**
	 * Retorna la fecha de inicio de la configuraci�n.
	 */
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Retorna la fecha de fin de la configuraci�n.
	 */
	public Calendar getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Retorna el valor del gasto mensual correspondiente a la
	 * configuraci�n.
	 */
	public float getGastoMensual() {
		return this.gastoMensual.getValor();
	}

	/**
	 * Retorna el valor del TEM correspondiente a la
	 * configuraci�n.
	 */
	public float getTem() {
		return tem.getTEM();
	}

	/**
	 * Modifica el valor del monto pasado por par�metro,
	 * agreg�ndole el valor global.
	 * @param monto Monto a recotizar.
	 */
	public float recotizarValorGlobal(float monto) {
		return this.gastoGlobal.recotizarValor(monto);
	}
	
	/**
	 * Modifica el valor del monto pasado por par�metro,
	 * agreg�ndole el valor mensual.
	 * @param monto Monto a recotizar.
	 */
	public float recotizarValorMensual(float cuota) {
		return (this.gastoMensual.recotizarValor(cuota));
	}

}