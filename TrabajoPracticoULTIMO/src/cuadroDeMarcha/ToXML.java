package cuadroDeMarcha;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import cuota.Cuota;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;

public class ToXML extends Converter {
	
	public ToXML() {
		this.file = "<cuadroMarcha> \n";
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
			gastosString = Float.toString(c.getGastoMensual());
			valorCuotaString = Float.toString(c.getValorCuotaNeto());
			valorTotalCuotaString = Float.toString(c.getValorTotalDeCuota());
			if(c.getFechaDePago() != null) fechaDePagoString = sdf1.format(c.getFechaDePago().getTime());
			interesPorMoraString = Float.toString(c.getInteresPorMora());
		
			file += "     <cuota> \n					<numero>" + nroCuotaString + "</numero> \n					<vencimiento>" + fechaDeVencimientoString + "</vencimiento> \n					<amortizacion>" + amortizacionString + "</amortizacion> \n					<interes>" + interesString + "</interes> \n					<saldodeuda>" + saldoDeudaString + "</saldodeuda> \n					<seguro>" + seguroString + "</seguro> \n					<gastos>" + gastosString + "</gastos> \n					<valorcuota>" + valorCuotaString + "</valorcuota> \n					<valortotalcuota>"+ valorTotalCuotaString + "</valortotalcuota> \n					<fechadepago>" + fechaDePagoString + "</fechadepago> \n					<interesmora>" + interesPorMoraString + "</interesmora> \n     </cuota> \n";
			}
		file += "</cuadroMarcha>";
		return file;
	}		
	
//	MAIN DE PRUEBA
//	public static void main(String[] args) throws InstallmentCountException, InvalidAmountException {
//		GregorianCalendar fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
//		GregorianCalendar fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
//		TEM t = new TEM((float) 0.015);
//		GlobalesPorcentuales g = new GlobalesPorcentuales((float)0.08);
//		MensualesPorcentuales m = new MensualesPorcentuales((float) 0.05);
//		ConfiguracionGeneral cg = new ConfiguracionGeneral(fechaInicio, fechaFin, m, g, t);
//		
//		PromedioEnCuotas s = new PromedioEnCuotas((float)0.015);
//		ClienteSimple c = new ClienteSimple("cliente", "prueba", "123456", "calle falsa 123");
//		Prestamo p = new Prestamo(20000, 12, cg, s, c);
//		p.cambiarEstadoAEnCursoYAplicarCG();
//		
//		ToXML xml = new ToXML();
//		System.out.println(xml.loadFile(p));
//	}


}
