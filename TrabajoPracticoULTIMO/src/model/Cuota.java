package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import seguroDeVida.SeguroDeVida;

public class Cuota {
	
	private float amortizacion;
	private GregorianCalendar fechaPeriodo;
	private GregorianCalendar fechaDeVencimiento;
	private GregorianCalendar fechaDePago;
	private float interes;
	private float interesPorMora;
	private int nroDeCuota;
	private boolean pago;
	private float saldoDeDeuda;
	private float saldoDeDeudaCuotaAnterior;
	private float seguroDeVida;
	private float tem;
	private float valorTotalDeCuota;
	private float valorCuota;
	
	public Cuota(float valorCuota, int nroDeCuota, GregorianCalendar fechaDeInicioPrestamo, float saldoAnterior, float tem, SeguroDeVida s) {
		this.valorCuota = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.saldoDeDeudaCuotaAnterior = saldoAnterior;
		this.tem = tem;
		this.calcularInteres(this.tem);
		this.calcularPeriodoCuota(fechaDeInicioPrestamo);
		this.calcularAmortizacion();
		this.calcularVencimiento();
		this.calcularSeguroDeVida(s);
		this.seguroDeVida = s.calcularSeguro(this);
		this.calcularSaldoDeDeuda();
		this.pago = false;
	}
	public void calcularValorTotalDeCuota(){
		this.valorTotalDeCuota = this.valorCuota + this.seguroDeVida;
	}
	public boolean estaVencida(){
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		boolean aux = false;
		if(this.fechaDeVencimiento.compareTo(hoy) < 0){
			aux = true;
		}
		return aux;//hola
	}

	public int getNroCuota() {
		return this.nroDeCuota;
	}

	public float getValorCuota(){
		return this.valorCuota;
	}

	public GregorianCalendar getFechaPeriodo() {
		return this.fechaPeriodo;
	}
	
	public GregorianCalendar getFechaVencimiento() {
		return this.fechaDeVencimiento;
	}
	public void pagarCuota() {
		this.pago = true;
		this.calcularInteresPorMora();
		this.valorTotalDeCuota += this.interesPorMora;
	}
	
	public boolean getPago(){
		return this.pago;
	}
	public float getSaldoDeDeuda(){
		return this.saldoDeDeuda;
	}

	public void calcularAmortizacion(){
		this.amortizacion = this.valorCuota - this.interes;
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

	public void calcularSeguroDeVida(SeguroDeVida s){
		s.recibirSaldoAnterior(this.saldoDeDeudaCuotaAnterior);
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
	public static void main(String[] args) {		
//		GregorianCalendar c = new GregorianCalendar(2013, Calendar.JANUARY, 30);
//		c.add(GregorianCalendar.MONTH, 1);
//		Date d = c.getTime();
//		DateFormat df = DateFormat.getDateInstance();
//		String s = df.format(d);
//		System.out.println(s);
//	}
//	{
//		GregorianCalendar x = new GregorianCalendar(2013, Calendar.JANUARY, 30);
//		int d = x.get(GregorianCalendar.DAY_OF_MONTH);
//		System.out.println(d);
//	}
//	{
//		Calendar v = new GregorianCalendar(2012, Calendar.FEBRUARY, 22);
//		v.add(Calendar.DAY_OF_MONTH, 10);
//		int d = v.get(GregorianCalendar.DAY_OF_MONTH);
//		System.out.println(d);
		
//	GregorianCalendar ca = new GregorianCalendar(2013, Calendar.JANUARY, 30);
//	Cuota c= new Cuota(150, 1, ca);
//	System.out.println(c.estaVencida()); //DA TRUE
//	GregorianCalendar ca1 = new GregorianCalendar(2014, Calendar.JANUARY, 30);
//	Cuota c1= new Cuota(150, 1, ca1);
//	System.out.println(c1.estaVencida()); //DA FALSE
//	
	}
}

