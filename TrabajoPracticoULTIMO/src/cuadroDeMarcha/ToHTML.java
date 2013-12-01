package cuadroDeMarcha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;
import cuota.Cuota;

public class ToHTML extends Converter {

	 private String file;
	 
	 public ToHTML() {
		this.file = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN \n    \"http://www.w3.org/TR/html4/strict.dtd\"> \n<html lang=\"en\"> \n<head> \n           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n           <title>Cuadro de Marcha</title> \n</head> \n<body> \n<div id=\"cuadro\"> \n          <div id=\"cuota\"> \n";
	 }
	 
	 public String loadFile(Prestamo p) {
		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		 String nroCuotaString;
		 String fechaDeVencimientoString;
		 String amortizacionString;
		 String interesString;
		 String saldoDeudaString;
		 String seguroString;
		 String gastosString;
		 String valorCuotaString;
		 String valorTotalCuotaString;
		 String fechaDePagoString = null;
		 String interesPorMoraString;
		
		 for (Cuota c : p.getCuotas()) {
			 nroCuotaString = Float.toString(c.getNroCuota());
			 fechaDeVencimientoString = sdf1.format(c.getFechaVencimiento().getTime());
			 amortizacionString = Float.toString(c.getAmortizacion());
			 interesString = Float.toString(c.getInteres());
			 saldoDeudaString = Float.toString(c.getSaldoDeDeuda());
			 seguroString = Float.toString(c.getSeguroDeVida());
			 gastosString = Float.toString(p.getConfigGral().getGastoMensual());
			 valorCuotaString = Float.toString(c.getValorCuotaNeto());
			 valorTotalCuotaString = Float.toString(c.getValorTotalDeCuota());
			 if(c.getFechaDePago() != null) fechaDePagoString = sdf1.format(c.getFechaDePago().getTime());
			 interesPorMoraString = Float.toString(c.getInteresPorMora());
			 
			 file += "                       <ul> \n                                 <li> Cuota " + nroCuotaString + "</li> \n                                 <li> Vencimiento " + fechaDeVencimientoString + "</li> \n                                 <li>Amortizacion " + amortizacionString + "</li> \n                                 <li>Interés " + interesString + "</li> \n                                 <li>Saldo Deuda " + saldoDeudaString + "</li> \n                                 <li>Seguro " + seguroString + "</li> \n                                 <li>Gastos " + gastosString + "</li> \n                                 <li>Valor Cuota " + valorCuotaString + "</li> \n                                 <li>Valor total cuota "+ valorTotalCuotaString + "</li> \n                                 <li>Fecha de Pago " + fechaDePagoString + "</li> \n                                 <li>Interes  por mora " + interesPorMoraString + "<li> \n                       </ul> \n";
			}
		 
			file += "          </div> \n</div> \n</body> \n</html> ";
					
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
		 
		 ToHTML html = new ToHTML();
		 System.out.println(html.loadFile(p));
	}
}