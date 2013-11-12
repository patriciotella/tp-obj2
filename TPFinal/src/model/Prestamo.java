package model;

import Rechazado;
import Solicitado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Prestamo {

	private float monto;
	private List<Cuota> cuotas;
	private Calendar fechaDeInicio;
	private Calendar fechaFin;
	private EstadoPrestamo estado;
	private ConfiguracionGeneral configGral;
	private SeguroDeVida seguroDeVida;
	private int cantidadDeCuotas;
	private float cuotaBase;
	
	public Prestamo(float monto, int cantidadCuotas, ConfiguracionGeneral cg, SeguroDeVida s) {
		this.monto = monto;
		this.estado = new Solicitado();
		this.cantidadDeCuotas = cantidadCuotas;
		this.configGral = cg;
		this.seguroDeVida = s;
		this.cuotaBase = monto/cantidadCuotas;
	}
	
	private void calcularCuotas(int cantidadCuotas){
		for (int i = 1; i == cantidadCuotas; i++) {
			Cuota c = new Cuota(30000, i, this.fechaDeInicio); // ARREGLAR PARAMETROS
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

	public void cambiarEstadoAEnCurso() {
		// el sistema decide acepta el prestamos en estado solicitado
		//por lo que se deben agregar los gastos mensuales y globales.
		//IMPLEMENTAR LA CONFIGURACION GENERAL, XQ MODIFICA EL PRESTAMO.
		this.cuotaBase=configGral.recotizarValorMensual (this.cuotaBase);
		this.monto=configGral.recotizarValorGlobal(this.monto);
		this.cuotaBase = configGral.recotizarTEM(this.cuotaBase, this.cantidadDeCuotas);
		this.estado = new EnCurso ();
		
	}
	
	private void aplicarConfigGral(){
		// falta TEM
	/*	int gastoMensualAux = configGral.getGastoMensual().getValor();
		int gastoGlobalAux = configGral.getGastoGlobal().getValor();
		this.aplicarGastoMensual(gastoMensualAux);
		this.aplicarGastoGlobal(gastoGlobalAux);
		//configGral.getTem().aplicarAPrestamo; */
		
		
	}

	private void aplicarGastoGlobal(int gastoGlobalAux) {
		this.monto = this.monto - gastoGlobalAux;
		
	}

	private void aplicarGastoMensual(int gastoMensualAux) {
		for (Cuota c : this.cuotas) {
			c.setValorCuota(c.getValorCuota() + gastoMensualAux);
		}
		
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
