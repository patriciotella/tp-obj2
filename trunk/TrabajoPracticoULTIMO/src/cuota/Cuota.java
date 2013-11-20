package cuota;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cuota {

	private GregorianCalendar fechaPeriodo;
	private GregorianCalendar fechaDeVencimiento;
	private GregorianCalendar fechaDePago;
	private float amortizacion;
	private float interes;
	private float interesPorMora;
	private float saldoDeDeuda;
	private float saldoDeDeudaCuotaAnterior;
	private float seguroDeVida;
	private float tem;
	private float valorTotalDeCuota;
	private float valorCuotaNeto;
	private int nroDeCuota;
	private boolean pago;
	
	public Cuota(float valorCuota, int nroDeCuota, GregorianCalendar fechaDeInicioPrestamo, float saldoAnterior, float tem) {
		this.valorCuotaNeto = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.saldoDeDeudaCuotaAnterior = saldoAnterior;
		this.tem = tem;
		this.calcularInteres(this.tem);
		this.calcularPeriodoCuota(fechaDeInicioPrestamo);
		this.calcularAmortizacion();
		this.calcularVencimiento();
		this.calcularSaldoDeDeuda();
		this.calcularValorTotalDeCuota();
		this.pago = false;
	}
	
	public void calcularValorTotalDeCuota(){
		this.valorTotalDeCuota = this.valorCuotaNeto + this.seguroDeVida;
	}
	
	public boolean estaVencida(){
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		boolean aux = false;
		if(this.fechaDeVencimiento.compareTo(hoy) < 0){
			aux = true;
		}
		return aux;
	}

	public float getAmortizacion() {
		return this.amortizacion;
	}

	public GregorianCalendar getFechaDePago() {
		return fechaDePago;
	}

	public int getNroCuota() {
		return this.nroDeCuota;
	}

	public float getValorCuotaNeto(){
		return this.valorCuotaNeto;
	}

	public GregorianCalendar getFechaPeriodo() {
		return this.fechaPeriodo;
	}
	
	public GregorianCalendar getFechaVencimiento() {
		return this.fechaDeVencimiento;
	}
	public boolean getPago(){
		return this.pago;
	}
	public float getSaldoDeDeuda(){
		return this.saldoDeDeuda;
	}
	
	public float getInteresPorMora() {
		return interesPorMora;
	}

	public void pagarCuota() {
		this.pago = true;
		this.calcularInteresPorMora();
		this.valorTotalDeCuota += this.interesPorMora;
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		this.fechaDePago = hoy;
	}
	
	public void calcularAmortizacion(){
		this.amortizacion = this.valorCuotaNeto - this.interes;
	}

	public void calcularPeriodoCuota(GregorianCalendar fechaDeInicioPrestamo){
		this.fechaPeriodo = fechaDeInicioPrestamo;
			if(fechaDeInicioPrestamo.get(GregorianCalendar.DAY_OF_MONTH )<= 15)
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (this.nroDeCuota));
			else
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (this.nroDeCuota + 1));
	}

	public void calcularVencimiento(){
		this.fechaDeVencimiento  = (GregorianCalendar) this.getFechaPeriodo().clone();
		this.fechaDeVencimiento.add(Calendar.DAY_OF_MONTH, 10);
	}	
	
	public void calcularSaldoDeDeuda() {
		this.saldoDeDeuda = this.saldoDeDeudaCuotaAnterior - this.interes;
	}
	
	public void obtenerSeguro(float montoDelSeguro) {
		this.seguroDeVida = montoDelSeguro;
	}
	
	public float getSeguroDeVida(){
		return this.seguroDeVida;
	}
	
	private void calcularInteres(float tem) {
		this.interes = saldoDeDeudaCuotaAnterior * tem;
	}
	
	private void calcularInteresPorMora() {
		if(this.estaVencida()){
			this.interesPorMora = this.valorTotalDeCuota * this.tem;
		}else{
			this.interesPorMora = (float) 0;
		}
	}
}

