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
	
	/**
	 * Cambia el estado del préstamo a EnCurso, crea las cuotas y aplica la configuración general correspondiente.
	 */
	public void cambiarEstadoAEnCursoYAplicarCG() {
		this.aplicarConfigGral();
		this.crearCuotas(this.cantidadDeCuotas);
		this.estado = new EnCurso();	 
	}
	
	/**
	 * Cambia el estado del préstamo a EnCurso.
	 */
	public void cambiarEstadoAEnCurso(){
		this.estado = new EnCurso();
	}

	/**
	 * Cambia el estado del préstamo a EnDeuda.
	 */
	public void cambiarEstadoAEnDeuda() {
		this.estado = new EnDeuda();
	}

	/**
	 * Cambia el estado del préstamo a Rechazado.
	 */
	public void cambiarEstadoARechazado() {
		this.estado = new Rechazado();
	}

	/**
	 * Chequea si el préstamo posee cuotas en deuda; de ser así,
	 * cambia el estado a EnDeuda, sino, lo cambia a EnCurso.
	 */
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

	/**
	 * Retorna true si el estado del Prestamo es EnCurso, false en
	 * caso contrario.
	 */
	public boolean estaEnCurso() {
		return this.estado.estaEnCurso();
	}

	/**
	 * Retorna true si el estado del Prestamo es EnDeuda, false en
	 * caso contrario.
	 */
	public boolean estaEnDeuda() {
		return this.estado.estaEnDeuda();
	}

	/**
	 * Retorna la configuración general correspondiente al préstamo.
	 */
	public ConfiguracionGeneral getConfigGral() {
		return configGral;
	}

	/**
	 * Retorna las cuotas correspondientes al préstamo.
	 */
	public List<Cuota> getCuotas(){
		return this.cuotas;
	}

	/**
	 * Retorna el número de cuota que corresponde pagar.
	 */
	public int getNroCuotaAPagar() {
		return cuotaAPagar;
	}

	/**
	 * Retorna el estado correspondiente al préstamo.
	 */
	public EstadoPrestamo getEstado(){
		return this.estado;
	}
	
	/**
	 * Retorna el monto correspondiente al préstamo.
	 */
	public float getMonto() {
		return this.monto;
	}
	
	/**
	 * Retorna la fecha en la que se inicio el préstamo.
	 */
	public Calendar getFechaPrestamo() {
		return this.fechaDeInicio;
	}
	
	/**
	 * Retorna el cliente correspondiente al préstamo.
	 */
	public Cliente getCliente() {
		return this.cliente;
	}

	/**
	 * En caso de poder hacerlo, realiza el pago de la cuota correspondiente.
	 */
	public void pagarCuota()  {
		try {
			this.estado.pagarCuota(this, this.obtenerCuotaAPagar());
		} catch (PagoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		this.cuotaAPagar++;
	}
	
	/**
	 * Retorna la Cuota a pagar, comparando el id de cuota que posee el préstamo con el de las cuotas incluidas en su lista.
	 */
	private Cuota obtenerCuotaAPagar(){
		Cuota aux = null;
		for (Cuota c : this.cuotas) {
			if(this.cuotaAPagar == c.getNroCuota()){
				aux = c;
			}
		}
		return aux;
	}

	/**
	 * Retorna true si alguna de las cuotas que posee el préstamo está vencida.
	 */
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

	/**
	 * Aplica la configuración general (valor mensual, valor global y TEM) a las cuotas y al monto. 
	 */
	public void aplicarConfigGral() {
		this.cuota=configGral.recotizarValorMensual (this.cuota);
		this.monto=configGral.recotizarValorGlobal(this.monto);
		try {
			this.cuota = (float) (this.cuota + AdvanceModeInstallment.calculateInstallmentValue(monto, configGral.getTem(), cantidadDeCuotas));
		} catch (InstallmentCountException e) {
			System.out.println(e.getMessage());
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
		}			
	}

	/**
	 * Crea las cuotas y setea el seguro de vida correspondiente para cada una.
	 * @param cantidadCuotas Indica la cantidad de cuotas a crear.
	 */
	private void crearCuotas(int cantidadCuotas) {
		for (int i = 1; i <= cantidadCuotas; i++) {
			float saldoAnterior = this.pedirSaldoAnterior(i);
			this.seguroDeVida.recibirSaldoAnterior(saldoAnterior);
			Cuota c = new Cuota(cuota, i, this.fechaDeInicio, saldoAnterior, configGral.getTem());
			this.cuotas.add(c);
			this.seguroDeVida.calcularSeguro();
			c.setSeguroDeVida(this.seguroDeVida.getPorCuota(i));
		}
	}

	/**
	 * Consigue y retorna el saldo de deuda de la cuota anterior a la indicada, para poder crearla con los datos correspondientes.
	 * @param i Cuota a crear.
	 */
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

	/**
	 * Setea la fecha en la que se inicia el préstamo.
	 */
	private GregorianCalendar setFechaDeInicio() {
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		return hoy;
	}


}
