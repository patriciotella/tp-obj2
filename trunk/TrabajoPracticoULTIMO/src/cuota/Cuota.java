package cuota;

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
	
	public Cuota(float valorCuota, int nroDeCuota, GregorianCalendar fechaDeInicioPrestamo, float saldoAnterior, float tem, float seguroDeVida) {
		this.valorCuotaNeto = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.saldoDeDeudaCuotaAnterior = saldoAnterior;
		this.tem = tem;
		this.seguroDeVida = seguroDeVida;
		this.calcularInteres();
		this.calcularPeriodoCuota(fechaDeInicioPrestamo);
		this.calcularAmortizacion();
		this.calcularVencimiento();
		this.calcularSaldoDeDeuda();
		this.calcularValorTotalDeCuota();
		this.pago = false;
		this.fechaDePago = null;
	}
	
	/**
	 * Calcula el valor total de la cuota, sumando el valor neto y el seguro de vida.
	 */
	public void calcularValorTotalDeCuota(){
		this.valorTotalDeCuota = this.valorCuotaNeto + this.seguroDeVida;
	}
	
	/**
	 * Retorna true si su fecha de vencimiento es anterior al d�a actual.
	 */
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

	/**
	 * Retorna la amortizaci�n correspondiente a la cuota.
	 */
	public float getAmortizacion() {
		return this.amortizacion;
	}

	/**
	 * Retorna la fecha de pago correspondiente a la cuota.
	 */
	public GregorianCalendar getFechaDePago() {
		return fechaDePago;
	}

	/**
	 * Retorna el inter�s correspondiente a la cuota.
	 */
	public float getInteres() {
		return interes;
	}

	/**
	 * Retorna el inter�s por mora correspondiente a la cuota.
	 */
	public float getInteresPorMora() {
		return interesPorMora;
	}

	/**
	 * Retorna la fecha de per�odo correspondiente a la cuota.
	 */
	public GregorianCalendar getFechaPeriodo() {
		return this.fechaPeriodo;
	}

	/**
	 * Retorna la fecha de vencimiento correspondiente a la cuota.
	 */
	public GregorianCalendar getFechaVencimiento() {
		return this.fechaDeVencimiento;
	}

	/**
	 * Retorna el n�mero de cuota correspondiente.
	 */
	public int getNroCuota() {
		return this.nroDeCuota;
	}

	/**
	 * Retorna true si la cuota ya fue abonada, false en caso contrario.
	 */
	public boolean getPago(){
		return this.pago;
	}

	/**
	 * Retorna el valor de cuota neto correspondiente a la cuota.
	 */
	public float getValorCuotaNeto(){
		return this.valorCuotaNeto;
	}

	/**
	 * Retorna el valor total de cuota correspondiente.
	 */
	public float getValorTotalDeCuota() {
		return valorTotalDeCuota;
	}

	/**
	 * Retorna el saldo de deuda correspondiente a la cuota.
	 */
	public float getSaldoDeDeuda(){
		return this.saldoDeDeuda;
	}

	/**
	 * Retorna el seguro de vida correspondiente a la cuota.
	 */
	public float getSeguroDeVida(){
		return this.seguroDeVida;
	}

	/**
	 * Realiza el pago de la cuota, y en caso de estar vencida, le agrega el inter�s por mora.
	 */
	public void pagarCuota() {
		this.pago = true;
		this.calcularInteresPorMora();
		this.valorTotalDeCuota += this.interesPorMora;
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		this.fechaDePago = hoy;
	}
	
	/**
	 * Calcula la amortizaci�n rest�ndole el inter�s al valor de cuota neto.
	 */
	public void calcularAmortizacion(){
		this.amortizacion = this.valorCuotaNeto - this.interes;
	}

	/**
	 * Calcula el mes correspondiente a la cuota.
	 * De ser la primer cuota, sumar� uno o dos meses a la fecha de inicio del pr�stamo, dependiendo si el d�a de comienzo fue anterior al 15 o no.
	 * @param fechaDeInicioPrestamo La fecha correspondiente al momento en el que el pr�stamo fue pasado a EnCurso.
	 */
	private void calcularPeriodoCuota(GregorianCalendar fechaDeInicioPrestamo){
		this.fechaPeriodo = (GregorianCalendar)fechaDeInicioPrestamo.clone();
			if(fechaDeInicioPrestamo.get(GregorianCalendar.DAY_OF_MONTH )<= 15) {
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (this.nroDeCuota));
			} else {
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (this.nroDeCuota + 1));
			}
	}

	/**
	 * Calcula el vencimiento de la cuota, agreg�ndole diez d�as a la fecha de inicio del per�odo.
	 */
	public void calcularVencimiento(){
		this.fechaDeVencimiento  = (GregorianCalendar) this.getFechaPeriodo().clone();
		this.fechaDeVencimiento.add(GregorianCalendar.DAY_OF_MONTH, 10);
	}	
	
	/**
	 * Calcula el saldo de deuda, rest�ndole la amortizaci�n al saldo de deuda anterior.
	 */
	public void calcularSaldoDeDeuda() {
		this.saldoDeDeuda = this.saldoDeDeudaCuotaAnterior - this.amortizacion;
	}
	
	/**
	 * Calcula el inter�s, multiplicando el saldo de deuda de la cuota anterior por el TEM recibido por par�metro.
	 */
	private void calcularInteres() {
		this.interes = saldoDeDeudaCuotaAnterior * this.tem;
	}
	
	/**
	 * En caso de estar vencida, calcula el inter�s por mora multiplicando el valor total de cuota por el TEM.
	 */
	private void calcularInteresPorMora() {
		if(this.estaVencida()){
			this.interesPorMora = this.valorTotalDeCuota * this.tem;
		}else{
			this.interesPorMora = (float) 0;
		}
	}
}

