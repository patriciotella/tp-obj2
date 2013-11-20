package cuadroDeMarcha;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.w3c.dom.*;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import cuota.Cuota;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class ToXML {
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private DOMImplementation implementation;
	private Document document;
	private Element raiz;
	private Prestamo p;
	private List<Cuota> cs;
	
	private Element nodoNroCuota;
	private Text nodoValorNroCuota;
	private Element nodoVencimiento;
	private Text nodoValorVencimiento;
	private Element nodoAmortizacion;
	private Text nodoValorAmortizacion;
	private Element nodoInteres;
	private Text nodoValorInteres;
	private Element nodoSaldoDeuda;
	private Text nodoValorSaldoDeuda;
	private Element nodoSeguro;
	private Text nodoValorSeguro;
	private Element nodoGastos;
	private Text nodoValorGastos;
	private Element nodoValorCuota;
	private Text nodoVValorCuota;
	private Element nodoValorTotalCuota;
	private Text nodoVValorTotalCuota;
	private Element nodoFechaDePago;
	private Text nodoValorFechaDePago;
	private Element nodoInteresPorMora;
	private Text nodoValorInteresPorMora;

	public ToXML(Prestamo p) {
		this.p = p;
		this.cs = new ArrayList<Cuota>();
		cs = p.getCuotas();
	}
	
	public void loadFile() throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException{		
		try{
			System.out.println("entro al try");
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			implementation = builder.getDOMImplementation();
			document = implementation.createDocument(null, "cuota", null);
			document.setXmlVersion("1.0");
			raiz = document.getDocumentElement();
			for (Cuota c : this.cs) {
				String nroCuotaString = Float.toString(c.getNroCuota());
				nodoNroCuota= document.createElement("numero");
				nodoValorNroCuota = document.createTextNode(nroCuotaString);
				nodoNroCuota.appendChild(nodoValorNroCuota);
				raiz.appendChild(nodoNroCuota);
				
				nodoVencimiento = document.createElement("vencimiento");
				nodoValorVencimiento = document.createTextNode(c.getFechaVencimiento().toString());
				nodoVencimiento.appendChild(nodoValorVencimiento);
				raiz.appendChild(nodoVencimiento);
				
				String amortizacionString = Float.toString(c.getAmortizacion());
				nodoAmortizacion = document.createElement("amortizacion");
				nodoValorAmortizacion = document.createTextNode(amortizacionString);
				nodoAmortizacion.appendChild(nodoValorAmortizacion);
				raiz.appendChild(nodoAmortizacion);				

				String interesString = Float.toString(c.getInteres());
				nodoInteres = document.createElement("interes");
				nodoValorInteres = document.createTextNode(interesString);
				raiz.appendChild(nodoInteres);

				String saldoDeudaString = Float.toString(c.getSaldoDeDeuda());
				nodoSaldoDeuda = document.createElement("saldoDeDeuda");
				nodoValorSaldoDeuda = document.createTextNode(saldoDeudaString);
				nodoSaldoDeuda.appendChild(nodoValorSaldoDeuda);
				raiz.appendChild(nodoSaldoDeuda);

				String seguroString = Float.toString(c.getSeguroDeVida());
				nodoSeguro = document.createElement("seguro");
				nodoValorSeguro = document.createTextNode(seguroString);
				nodoSeguro.appendChild(nodoValorSeguro);
				raiz.appendChild(nodoSeguro);

				String gastosString = Float.toString(p.getConfigGral().getGastoMensual());
				nodoGastos = document.createElement("gastos");
				nodoValorGastos = document.createTextNode(gastosString);
				nodoGastos.appendChild(nodoValorGastos);
				raiz.appendChild(nodoGastos);

				String valorCuotaString = Float.toString(c.getValorCuotaNeto());
				nodoValorCuota = document.createElement("valorCuota");
				nodoVValorCuota = document.createTextNode(valorCuotaString);
				nodoValorCuota.appendChild(nodoVValorCuota);
				raiz.appendChild(nodoValorCuota);

				String valorTotalCuotaString = Float.toString(c.getValorTotalDeCuota());
				nodoValorTotalCuota = document.createElement("valorTotalCuota");
				nodoVValorTotalCuota = document.createTextNode(valorTotalCuotaString);
				nodoValorTotalCuota.appendChild(nodoVValorTotalCuota);
				raiz.appendChild(nodoValorTotalCuota);

				nodoFechaDePago = document.createElement("fechaDePago");
				nodoValorFechaDePago = document.createTextNode(c.getFechaDePago().toString());
				nodoFechaDePago.appendChild(nodoValorFechaDePago);
				raiz.appendChild(nodoFechaDePago);

				String interesPorMoraString = Float.toString(c.getInteresPorMora());
				nodoInteresPorMora = document.createElement("interesPorMora");
				nodoValorInteresPorMora = document.createTextNode(interesPorMoraString);
				nodoInteresPorMora.appendChild(nodoValorInteresPorMora);
				raiz.appendChild(nodoInteresPorMora);				
			}
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("C:\\Users\\Gustavo\\Desktop\\CuadroDeMarchaXML.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		}catch(Exception ex) {
			System.out.println("entro al catch");
			System.out.println(ex);
		}
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
		Prestamo p = new Prestamo(1, 50000, 12, cg, s, c);
		p.cambiarEstadoAEnCursoYAplicarCG();
	}


}
