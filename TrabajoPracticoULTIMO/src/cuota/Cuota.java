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
		this.fechaDePago = null;
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

	public float getInteres() {
		return interes;
	}

	public float getInteresPorMora() {
		return interesPorMora;
	}

	public GregorianCalendar getFechaPeriodo() {
		return this.fechaPeriodo;
	}

	public GregorianCalendar getFechaVencimiento() {
		return this.fechaDeVencimiento;
	}

	public int getNroCuota() {
		return this.nroDeCuota;
	}

	public boolean getPago(){
		return this.pago;
	}

	public float getValorCuotaNeto(){
		return this.valorCuotaNeto;
	}

	public float getValorTotalDeCuota() {
		return valorTotalDeCuota;
	}

	public float getSaldoDeDeuda(){
		return this.saldoDeDeuda;
	}
	
	public float getSeguroDeVida(){
		return this.seguroDeVida;
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

	private void calcularPeriodoCuota(GregorianCalendar fechaDeInicioPrestamo){
		this.fechaPeriodo = (GregorianCalendar)fechaDeInicioPrestamo.clone();
		if(this.nroDeCuota == 1) {
			if(fechaDeInicioPrestamo.get(GregorianCalendar.DAY_OF_MONTH )<= 15) {
				this.fechaPeriodo.add(GregorianCalendar.MONTH, 1);
			} else {
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (2));
			}
		} else {
			this.fechaPeriodo.add(GregorianCalendar.MONTH, (this.nroDeCuota + 1));
		}
	}

	public void calcularVencimiento(){
		this.fechaDeVencimiento  = (GregorianCalendar) this.getFechaPeriodo().clone();
		this.fechaDeVencimiento.set(Calendar.DAY_OF_MONTH, 10);
	}	
	
	public void calcularSaldoDeDeuda() {
		this.saldoDeDeuda = this.saldoDeDeudaCuotaAnterior - this.interes;
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

	public void setSeguroDeVida(float monto) {
		this.seguroDeVida = monto;
	}
}

