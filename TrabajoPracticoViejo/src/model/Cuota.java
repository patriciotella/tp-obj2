package model;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cuota {
	
	private int nroDeCuota;
	private float valorCuota;
	private Calendar fechaPeriodo;
	private Calendar fechaDeVencimiento = Calendar.getInstance();
	private Calendar fechaDePago;
	private float amortizacion;
	private float interes;
	private float saldoDeDeuda;
	private float valorTotalDeCuota;
	private float TEM;
	private float seguroDeVida;
	private float coeficienteSeguro;
	private float gastosMensuales;
	
	
	
	public Cuota(float valorCuota, int nroDeCuota, Calendar fechaDeInicioPrestamo) {
		this.valorCuota = valorCuota;
		this.nroDeCuota = nroDeCuota;
		this.calcularPeriodoCuota(fechaDeInicioPrestamo);
		this.calcularAmortizacion();
		this.calcularVencimiento();
	}

	private void calcularAmortizacion(){
		this.amortizacion = this.valorCuota - this.interes;
	}
	
	private void calcularPeriodoCuota(Calendar fechaDeInicioPrestamo){
		this.fechaPeriodo = fechaDeInicioPrestamo;
			if(fechaDeInicioPrestamo.get(GregorianCalendar.DAY_OF_MONTH )<= 15)
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (1 * this.nroDeCuota));
			else
				this.fechaPeriodo.add(GregorianCalendar.MONTH, (1 * this.nroDeCuota) + 1);
	}
	
	private void calcularVencimiento(){
		this.fechaDeVencimiento = this.fechaPeriodo;
		this.fechaDeVencimiento.add(Calendar.DAY_OF_MONTH, 10);
	}
	
	public float verInteres(){
		return (this.saldoDeDeuda * this.TEM);
	}
	
	public float verSaldoDeDeuda(){
		return (this.saldoDeDeuda - this.amortizacion);
	}
	
	public float verSeguroDeVida(){
		return (this.saldoDeDeuda * coeficienteSeguro);
	}
	
	public float verGastosMensuales(){
		return this.gastosMensuales;
	}
	
	public float getValorCuota(){
		return this.valorCuota;
	}
	
	public float verValorTotalDeCuota(){
		return this.valorTotalDeCuota;
	}
	
	public Calendar verFechaDePago(){
		return this.fechaDePago;
	}
	
	public void setValorCuota(float v) {
		this.valorCuota = v;
		
	}

	public static void main(String[] args) {
	{
		GregorianCalendar c = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		c.add(GregorianCalendar.MONTH, 1);
		Date d = c.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String s = df.format(d);
		System.out.println(s);
	}
	{
		GregorianCalendar x = new GregorianCalendar(2013, Calendar.JANUARY, 30);
		int d = x.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println(d);
	}
	{
		Calendar v = new GregorianCalendar(2012, Calendar.FEBRUARY, 22);
		v.add(Calendar.DAY_OF_MONTH, 10);
		int d = v.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println(d);
		}
		
	}
	}
	
	
