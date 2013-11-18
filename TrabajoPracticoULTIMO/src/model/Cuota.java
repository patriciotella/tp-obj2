package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cuota {
	
	private int nroDeCuota;
	private float valorCuota;
	private GregorianCalendar fechaPeriodo;
	private GregorianCalendar fechaDeVencimiento;
	private GregorianCalendar fechaDePago;
	private float amortizacion;
	private float interes;
	private float saldoDeDeuda;
	private float saldoDeDeudaCuotaAnterior;
	private float valorTotalDeCuota;
	private float seguroDeVida;
	private float coeficienteSeguro;

	private boolean pago;
	
	public Cuota(float valorCuota, int nroDeCuota, GregorianCalendar fechaDeInicioPrestamo, float saldoAnterior) {
		this.valorCuota = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.saldoDeDeudaCuotaAnterior = saldoAnterior;
		this.calcularPeriodoCuota(fechaDeInicioPrestamo);
		this.calcularAmortizacion();
		this.calcularVencimiento();
		this.calcularSaldoDeDeuda();
		this.pago = false;
	}
	public boolean estaVencida(){
		Calendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		boolean aux = false;
		if(this.fechaDeVencimiento.compareTo(hoy) < 0){
			aux = true;
		}
		return aux;
	}

	public int getNroCuota() {
		return this.nroDeCuota;
	}

	public float getValorCuota(){
		return this.valorCuota;
	}

	public Calendar getFechaPeriodo() {
		return this.fechaPeriodo;
	}
	
	public void pagarCuota() {
		this.pago = true;
		
	}
	
	public float getSaldoDeDeuda(){
		return this.saldoDeDeuda;
	}

	public Calendar getFechaVencimiento() {
		return this.fechaDeVencimiento;
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
		GregorianCalendar aux = this.fechaPeriodo;
		aux.add(Calendar.DAY_OF_MONTH, 10);
		this.fechaDeVencimiento = aux;
	}
	
	public void calcularSaldoDeDeuda() {
		this.saldoDeDeuda = this.saldoDeDeudaCuotaAnterior - this.interes;
	}

	public void calcularSeguroDeVida(){
		this.seguroDeVida = this.saldoDeDeudaCuotaAnterior + this.coeficienteSeguro;
	}
	
	public void calcularValorTotalDeCuota(){
		this.valorTotalDeCuota = this.valorCuota + this.seguroDeVida;
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

