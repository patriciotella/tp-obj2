package cuadroDeMarcha;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import cuota.Cuota;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;

public class ToXML extends Convert{
	
	private Prestamo p;
	private List<Cuota> cs;
	private String file;
	
	public ToXML(Prestamo p) {
		this.p = p;
		this.cs = new ArrayList<Cuota>();
		cs = p.getCuotas();
	}
	
	public String loadFile() {
		String nroCuotaString;
		String amortizacionString;
		String interesString;
		String saldoDeudaString;
		String seguroString;
		String gastosString;
		String valorCuotaString;
		String valorTotalCuotaString;
		String interesPorMoraString;
		
		file = "<cuadroMarcha>" +
				"";
		for (Cuota c : this.cs) {
			nroCuotaString = Float.toString(c.getNroCuota());
			amortizacionString = Float.toString(c.getAmortizacion());
			interesString = Float.toString(c.getInteres());
			saldoDeudaString = Float.toString(c.getSaldoDeDeuda());
			seguroString = Float.toString(c.getSeguroDeVida());
			gastosString = Float.toString(p.getConfigGral().getGastoMensual());
			valorCuotaString = Float.toString(c.getValorCuotaNeto());
			valorTotalCuotaString = Float.toString(c.getValorTotalDeCuota());
			interesPorMoraString = Float.toString(c.getInteresPorMora());
		
			file += "	<cuota>" +
					"		<numero>" + nroCuotaString + "</numero>" +
					"		<vencimiento>" + (c.getFechaVencimiento().toString()) + "</vencimiento>" +
					"		<amortizacion>" + amortizacionString + "</amortizacion>" +
					"		<interes>" + interesString + "</interes>" +
					"		<saldodeuda>" + saldoDeudaString + "</saldodeuda>" +
					"		<seguro>" + seguroString + "</seguro>" +
					"		<gastos>" + gastosString + "</gastos>" +
					"		<valorcuota>" + valorCuotaString + "</valorcuota>" +
					"		<valortotalcuota>"+ valorTotalCuotaString + "</valortotalcuota>" +
					"		<fechadepago>" + (c.getFechaDePago().toString()) + "</fechadepago>" +
					"		<interesmora>" + interesPorMoraString + "</interesmora>" +
					"	</cuota>";
			}
		file += ""
				+ "</cuadroMarcha>";
		return file;
	}		
	
	public static void main(String[] args) throws InstallmentCountException, InvalidAmountException {
		GregorianCalendar fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
		GregorianCalendar fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
		TEM t = new TEM((float) 0.015);
		GlobalesPorcentuales g = new GlobalesPorcentuales((float)0.08);
		MensualesPorcentuales m = new MensualesPorcentuales((float) 0.05);
		ConfiguracionGeneral cg = new ConfiguracionGeneral(fechaInicio, fechaFin, m, g, t);
		
		PromedioEnCuotas s = new PromedioEnCuotas((float)0.015);
		ClienteSimple c = new ClienteSimple("cliente", "prueba", "123456", "calle falsa 123");
		Prestamo p = new Prestamo(50000, 12, cg, s, c);
		p.cambiarEstadoAEnCursoYAplicarCG();
		
		ToXML xml = new ToXML(p);
		System.out.println(xml.loadFile());
		
//		error:
//		Exception in thread "main" java.lang.NullPointerException
//		at cuadroDeMarcha.ToXML.loadFile(ToXML.java:73)
//		at cuadroDeMarcha.ToXML.main(ToXML.java:96)
	}


}
