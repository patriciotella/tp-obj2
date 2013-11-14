package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
	
	public static void main(String[] args) {
		Calendar fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
		Calendar fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
		Gastos mensual = new MensualesValorFijo(100);
		Gastos global = new GlobalesValorFijo(600);
		TEM tem = new TEM(((float) 0.5));
		ConfiguracionGeneral cf= new ConfiguracionGeneral(fechaInicio, fechaFin, mensual, global, tem);
		
		float aux = cf.recotizarValorMensual(500);
		System.out.println(aux);
	}

}