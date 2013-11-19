package model;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import installment.calculator.model.AdvanceModeInstallment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Prestamo {

	private int id;
	private float monto;
	private List<Cuota> cuotas;
	private GregorianCalendar fechaDeInicio;
	private GregorianCalendar fechaFin;
	private EstadoPrestamo estado;
	private ConfiguracionGeneral configGral;
	private SeguroDeVida seguroDeVida;
	private int cantidadDeCuotas;
	private float cuota;
	private Cliente cliente;
	private int cuotaAPagar;
	
	public Prestamo(int id, float monto, int cantidadCuotas, ConfiguracionGeneral cg, SeguroDeVida s, Cliente c) {
		this.id = id;
		this.monto = monto;
		this.estado = new Solicitado();
		this.cantidadDeCuotas = cantidadCuotas;
		this.configGral = cg;
		this.seguroDeVida = s;
		this.cuota = monto/cantidadCuotas;
		this.cliente = c;
		this.cuotaAPagar = 1;
		this.cuotas = new ArrayList<Cuota>();

	}
	


	public void cambiarEstadoAEnCursoYAplicarCG() throws InstallmentCountException, InvalidAmountException {
		this.aplicarConfigGral();
		this.crearCuotas(this.cantidadDeCuotas);
		this.estado = new EnCurso ();	 
	}
	
	public void cambiarEstadoAEnCurso(){
		this.estado = new EnCurso ();
	}

	public void cambiarEstadoARechazado() {
		this.estado = new Rechazado();
	}

	public boolean estaEnCurso() {
		return this.estado.estaEnCurso();
	}

	public boolean estaEnDeuda() {
		return this.estado.estaEnDeuda();
	}

	public List<Cuota> getCuotas(){
		return this.cuotas;
	}

	public int getId(){
		return this.id;
	}
	
	public EstadoPrestamo getEstado(){
		return this.estado;
	}
	
	public float getMonto() {
		return this.monto;
	}
	
	public Calendar getFechaPrestamo() {
		return this.fechaDeInicio;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void pagarCuota() throws Exception {
		this.estado.pagarCuota(this, this.obtenerCuotaAPagar());
		this.cuotaAPagar++;
	}
	
	public Cuota obtenerCuotaAPagar(){
		Cuota aux = null;
		for (Cuota c : this.cuotas) {
			if(this.cuotaAPagar == c.getNroCuota()){
				aux = c;
			}
		}
		return aux;
	}

	private void aplicarConfigGral() throws InstallmentCountException, InvalidAmountException{
		this.cuota=configGral.recotizarValorMensual (this.cuota);
		this.monto=configGral.recotizarValorGlobal(this.monto);
		this.cuota = (float) (this.cuota + AdvanceModeInstallment.calculateInstallmentValue(monto, configGral.getTem(), cantidadDeCuotas));
	}

	private void crearCuotas(int cantidadCuotas){
		for (int i = 1; i == cantidadCuotas; i++) {
			float saldoAnterior = this.pedirSaldoAnterior(i);
			Cuota c = new Cuota(cuota, i, this.fechaDeInicio, saldoAnterior, configGral.getTem(), seguroDeVida);
			this.cuotas.add(c);
		}
	}

	private float pedirSaldoAnterior(int i) {
		float ret = 0;
		if(i == 1) ret = this.monto;
		else{
			for (Cuota e : cuotas) {
				if((i - 1) == e.getNroCuota()) ret = e.getSaldoDeDeuda();
			}
		}
		return ret;
	}


	public void cambiarEstadoAEnDeuda() {
		this.estado = new EnDeuda();
		
	}

	public void chequearEstado() {
		boolean cuotasEnDeuda = false;
		for (Cuota c : this.cuotas) {
			if(c.estaVencida()){
				this.cambiarEstadoAEnDeuda();
				cuotasEnDeuda = true;
			}
		}
		if(!cuotasEnDeuda){
			this.cambiarEstadoAEnCurso();
		}
	}

	public static void main(String[] args) {
		/*
		Calendar i = Calendar.getInstance();
		i.set(2013, 11, 07);
		Calendar f = Calendar.getInstance();
		f.set(2013, 12, 07);
		List<Cuota> c= new ArrayList<Cuota>();
		Prestamo p = new Prestamo(30000, c, i, f);
		System.out.println(p.estaEnDeuda()); */
	}


}
