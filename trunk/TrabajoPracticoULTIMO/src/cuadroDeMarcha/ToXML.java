package cuadroDeMarcha;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;

import cuota.Cuota;
import prestamo.Prestamo;

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
				factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
				implementation = builder.getDOMImplementation();
				document = implementation.createDocument(null, "documento", null);
				document.setXmlVersion("1.0");
				raiz = document.getDocumentElement();
				for (Cuota c : this.cs) {
					nodoNombreCampo = document.createElement("ElementoHijoDeLaRaíz");
					nodoValorCampo = document.createTextNode("contenido del elemento hijo");
					nodoNombreCampo.appendChild(nodoValorCampo);
					raiz.appendChild(nodoNombreCampo);
				}
				Source source = new DOMSource(document);
				Result result = new StreamResult(new java.io.File("resultado.xml")); //nombre del archivo
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
			}catch(Exception ex) {
				System.out.println(ex);
			}
	}


}
