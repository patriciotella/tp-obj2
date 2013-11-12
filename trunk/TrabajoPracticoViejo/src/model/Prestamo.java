package model;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Prestamo {

	private int id;
	private float monto;
	private List<Cuota> cuotas;
	private Calendar fechaDeInicio;
	private Calendar fechaFin;
	private EstadoPrestamo estado;
	private ConfiguracionGeneral configGral;
	private SeguroDeVida seguroDeVida;
	private int cantidadDeCuotas;
	private float cuota;
	private Cliente cliente;
	
	public Prestamo(int id, float monto, int cantidadCuotas, ConfiguracionGeneral cg, SeguroDeVida s, Cliente c) {
		this.id = id;
		this.monto = monto;
		this.estado = new Solicitado();
		this.cantidadDeCuotas = cantidadCuotas;
		this.configGral = cg;
		this.seguroDeVida = s;
		this.cuota = monto/cantidadCuotas;
		this.cliente = c;
	}
	
	public void cambiarEstadoAEnCurso() {
		this.aplicarConfigGral();
		this.crearCuotas(cantidadCuotas);
		this.estado = new EnCurso ();		
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
		return cliente;
	}

	// ES NECESARIO ESTE METODO?
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void crearCuotas(int cantidadCuotas){
		for (int i = 1; i == cantidadCuotas; i++) {
			Cuota c = new Cuota(cuota, i, this.fechaDeInicio);
			this.cuotas.add(c);
		}
	}

	public void pagarCuota(List<Cuota> cs) {
		this.estado.pagarCuota(this, cs);
	}

	public List<Cuota> getCuotas(){
		return this.cuotas;
	}
	
	public boolean estaEnDeuda() {
		return this.estado.estaEnDeuda();
	}
	
	public boolean estaEnCurso() {
		return this.estado.estaEnCurso();
	}

	private void aplicarConfigGral(){
		this.cuota=configGral.recotizarValorMensual (this.cuota);
		this.monto=configGral.recotizarValorGlobal(this.monto);
		this.cuota = configGral.recotizarTEM(this.cuota, this.cantidadDeCuotas);		
	}

	public void cambiarEstadoARechazado() {
		this.estado = new Rechazado();
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
