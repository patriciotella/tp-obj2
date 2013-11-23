package cuadroDeMarcha;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;
import cuota.Cuota;

public class ToHTML extends Convert{
  
	 private Prestamo p;
	 private List<Cuota> cs;
	 private String file;
	 
	 public ToHTML(Prestamo p) {
		this.p = p;
		this.cs = new ArrayList<Cuota>();
		cs = p.getCuotas();
		file = "<!DOCTYPE html PUBLIC \"-ï¿½-//W3C//DTD HTML 4.01//EN" +
				" \"http://www.w3.org/TR/html4/strict.dtd\"> " +
				" <html lang=\"en\"> " +
				" <head> " +
				" <meta http-ï¿½-equiv=\"Content-ï¿½-Type\" content=\"text/html; charset=utf-ï¿½-8\"> " +
				" <title>Cuadro de Marcha</title> " +
				" </head> " +
				" <body> " +
				" <div id=\"cuadro\"> " +
				" <div id=\"cuota\"> " +
				"";
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
			 
			 file += " <ul> " +
					 " <li> Cuota " + nroCuotaString + "</li> " +
					 " <li> Vencimiento " + (c.getFechaVencimiento().toString()) + "</li> " +
					 " <li>Amortizacion " + amortizacionString + "</li> " +
					 " <li>Interés " + interesString + "</li> " +
					 " <li>Saldo Deuda " + saldoDeudaString + "</li> " +
					 " <li>Seguro " + seguroString + "</li> " +
					 " <li>Gastos " + gastosString + "</li> " +
					 " <li>Valor Cuota " + valorCuotaString + "</li> " +
					 " <li>Valor total cuota "+ valorTotalCuotaString + "</li> " +
					 " <li>Fecha de Pago " + (c.getFechaDePago().toString()) + "</li> " +
					 " <li>Interes  por mora " + interesPorMoraString + "<li> " +
					 " </ul> " +
					 " <ul> " +
					 "";
			}
		 
			file += " </div> " +
					" </div> " +
					" </body> " +
					" </html> ";
					
			return file;
	}
		 
	 public static void main(String[] args) {
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
			
			ToHTML html = new ToHTML(p);
			System.out.println(html.loadFile());
			
//			error:
//				Exception in thread "main" java.lang.NullPointerException
//				at cuadroDeMarcha.ToHTML.loadFile(ToHTML.java:72)
//				at cuadroDeMarcha.ToHTML.main(ToHTML.java:101)
	}
}