package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Prestamo {

	private float monto;
	private List<Cuota> cuotas;
	private Calendar fechaDeInicio;
	private Calendar fechaFin;
	private EstadoPrestamo state;
	
	public Prestamo(float monto, int cantidadCuotas, Calendar fechaDeInicio, Calendar fechaFin) {
		this.monto = monto;
		this.cuotas = this.calcularCuotas(cantidadCuotas);
		this.fechaDeInicio = fechaDeInicio;
		this.fechaFin = fechaFin;
		this.state = new Solicitado();
	}
	
	private List<Cuota> calcularCuotas(int cantidadCuotas){
		for (int i = 1; i == cantidadCuotas; i++) {
			Cuota c = new Cuota(30000, i, this.fechaDeInicio); // ARREGLAR PARAMETROS
			this.cuotas.add(c);
		}
	}

	public void pagarCuota(Cuota c) {
		this.state.pagarCuota(this, c);
	}
	
	//public int getCuotas(){
//		public int getCuotas(){
//		return this.cuotas;
//	}	return this.cuotas;
	//

	public boolean estaEnDeuda() {
		return this.state.estaEnDeuda();
	}
	
	public boolean estaEnCurso() {
		return this.state.estaEnCurso();
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
