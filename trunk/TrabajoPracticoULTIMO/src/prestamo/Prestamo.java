package prestamo;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import installment.calculator.model.AdvanceModeInstallment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import configuracionGeneral.ConfiguracionGeneral;
import cuota.Cuota;
import cliente.Cliente;
import seguroDeVida.SeguroDeVida;

public class Prestamo {

	private float monto;
	private List<Cuota> cuotas;
	private GregorianCalendar fechaDeInicio;
	private EstadoPrestamo estado;
	private ConfiguracionGeneral configGral;
	private SeguroDeVida seguroDeVida;
	private int cantidadDeCuotas;
	private float cuota;
	private Cliente cliente;
	private int cuotaAPagar;
	
	public Prestamo(float monto, int cantidadCuotas, ConfiguracionGeneral configGral, SeguroDeVida seguroDeVida, Cliente cliente) {
		this.monto = monto;
		this.estado = new Solicitado();
		this.cantidadDeCuotas = cantidadCuotas;
		this.configGral = configGral;
		this.seguroDeVida = seguroDeVida;
		this.cuota = monto/cantidadCuotas;
		this.cliente = cliente;
		this.cuotaAPagar = 1;
		this.cuotas = new ArrayList<Cuota>();
		this.fechaDeInicio = this.setFechaDeInicio();
	}
	
	public void cambiarEstadoAEnCursoYAplicarCG() {
		this.aplicarConfigGral();
		this.crearCuotas(this.cantidadDeCuotas);
		this.setearSeguroDeVida();
		this.estado = new EnCurso ();	 
	}
	
	public void cambiarEstadoAEnCurso(){
		this.estado = new EnCurso ();
	}

	public void cambiarEstadoAEnDeuda() {
		this.estado = new EnDeuda();
	}

	public void cambiarEstadoARechazado() {
		this.estado = new Rechazado();
	}

	protected void chequearEstado() {
		boolean cuotasEnDeuda = false;
		for (Cuota c : cuotas) {
			if(c.estaVencida()){
				this.cambiarEstadoAEnDeuda();
				cuotasEnDeuda = true;
			}
		}
		if(!cuotasEnDeuda){
			this.cambiarEstadoAEnCurso();
		}
	}

	public boolean estaEnCurso() {
		return this.estado.estaEnCurso();
	}

	public boolean estaEnDeuda() {
		return this.estado.estaEnDeuda();
	}

	public ConfiguracionGeneral getConfigGral() {
		return configGral;
	}

	public List<Cuota> getCuotas(){
		return this.cuotas;
	}

	public int getNroCuotaAPagar() {
		return cuotaAPagar;
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

	public void pagarCuota()  {
		try {
			this.estado.pagarCuota(this, this.obtenerCuotaAPagar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.cuotaAPagar++;
	}
	
	private Cuota obtenerCuotaAPagar(){
		Cuota aux = null;
		for (Cuota c : this.cuotas) {
			if(this.cuotaAPagar == c.getNroCuota()){
				aux = c;
			}
		}
		return aux;
	}

	public boolean tieneCuotasVencidas() {
		boolean aux = false;
		for (Cuota c : cuotas) {
			if(c.estaVencida()){
				aux = true;
				break;
			}
		}
		return aux;
	}

	public void aplicarConfigGral() {
		this.cuota=configGral.recotizarValorMensual (this.cuota);
		this.monto=configGral.recotizarValorGlobal(this.monto);
		try {
			this.cuota = (float) (this.cuota + AdvanceModeInstallment.calculateInstallmentValue(monto, configGral.getTem(), cantidadDeCuotas));
		} catch (InstallmentCountException e) {
			e.getMessage();
		} catch (InvalidAmountException e) {
			e.getMessage();
		}			
	}

	private void crearCuotas(int cantidadCuotas){
		for (int i = 1; i <= cantidadCuotas; i++) {
			float saldoAnterior = this.pedirSaldoAnterior(i);
			this.seguroDeVida.recibirSaldoAnterior(saldoAnterior);
			Cuota c = new Cuota(cuota, i, this.fechaDeInicio, saldoAnterior, configGral.getTem());
			this.cuotas.add(c);
			this.seguroDeVida.calcularSeguro();
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

	private void setearSeguroDeVida() {
		float montoDelSeguro = 0;
		for (Cuota e: cuotas) {
			montoDelSeguro = this.seguroDeVida.getPorCuota(e.getNroCuota());
			e.obtenerSeguro(montoDelSeguro);
		}
	}
	

	private GregorianCalendar setFechaDeInicio() {
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		return hoy;
	}


}
