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
import sun.applet.Main;

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
	private Element nodoNombreCampo;
	private Text nodoValorCampo;
	private Prestamo p;
	private List<Cuota> cs;
	
	public ToXML(Prestamo p) {
		this.p = p;
		this.cs = new ArrayList<Cuota>();
		cs = p.getCuotas();
	}
	
	public void loadFile() throws TransformerFactoryConfigurationError, TransformerException{		
		try{
			System.out.println("entro al try");
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			implementation = builder.getDOMImplementation();
			document = implementation.createDocument(null, "documento", null);
			document.setXmlVersion("1.0");
			raiz = document.getDocumentElement();
			for (Cuota c : this.cs) {
				nodoNombreCampo = document.createElement("cuota");
				nodoValorCampo = document.createTextNode("cuota " + c.getNroCuota());
				nodoNombreCampo.appendChild(nodoValorCampo);
				raiz.appendChild(nodoNombreCampo);
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
