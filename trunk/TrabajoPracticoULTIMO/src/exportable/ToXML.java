package exportable;

import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import cuota.Cuota;
import prestamo.Prestamo;

public class ToXML extends Exportable {
	
	private String configFile;
	private Prestamo p;
	private java.util.List<Cuota> cs;
	
	public ToXML(Prestamo p) {
		this.p = p;
		this.cs = p.getCuotas();
	}

  public void setFile(String configFile) {
	    this.configFile = configFile;
}

  public void saveConfig() throws Exception {
    // create an XMLOutputFactory
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    // create XMLEventWriter
    XMLEventWriter eventWriter = outputFactory
        .createXMLEventWriter(new FileOutputStream(configFile));
    // create an EventFactory
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");
    // create and write Start Tag
    StartDocument startDocument = eventFactory.createStartDocument();
    eventWriter.add(startDocument);

    // create config open tag
    StartElement configStartElement = eventFactory.createStartElement("",
        "", "cuota");
    eventWriter.add(configStartElement);
    eventWriter.add(end);
    // Write the different nodes
//    <numero>1</numero>
//    <vencimiento>10/09/2013</vencimiento>
//    <amortizacion>1.533,60</amortizacion>
//    <interes>300,00</interes>
//    <saldodeuda>18.466,40</saldodeuda>
//    <seguro>
//    14,00</seguro>
//    <gastos>4,00</gastos>
//    <valorcuota>1.833,60</valorcuota>
//    <valortotalcuota>1.851,60</valortotalcuota>
//    <fechadepago>11/09/2013</fechadepago>
//    <interesmora>27,77</interesmora>
    createNode(eventWriter, "numero", "1");
    createNode(eventWriter, "vencimiento", cs.get(1).getFechaVencimiento().toString());
    createNode(eventWriter, "amortizacion", "0.3" /*cs.get(1).getAmortizacion()*/);
    createNode(eventWriter, "saldo de deuda", "0.3" /*cs.get(1).getSaldoDeDeuda().toString() */);
    createNode(eventWriter, "seguro", "0.3" /*cs.get(1).getSeguroDeVida().toString() */);
    createNode(eventWriter, "gastos", "0.3" /* p.getConfigGral().getGastoMensual().toString() */ );
    createNode(eventWriter, "valor cuota", "0.3"/* cs.get(1).getValorCuotaNeto().toString() */ );
    createNode(eventWriter, "fecha de pago", cs.get(1).getFechaDePago().toString());
    createNode(eventWriter, "interes por mora", "0.3" /*cs.get(1).getInteresPorMora().toString()*/);
    
    eventWriter.add(eventFactory.createEndElement("", "", "cuota"));
    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndDocument());
    eventWriter.close();
  }

  private void createNode(XMLEventWriter eventWriter, String name,
      String value) throws XMLStreamException {

    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");
    XMLEvent tab = eventFactory.createDTD("\t");
    // create Start node
    StartElement sElement = eventFactory.createStartElement("", "", name);
    eventWriter.add(tab);
    eventWriter.add(sElement);
    // create Content
    Characters characters = eventFactory.createCharacters(value);
    eventWriter.add(characters);
    // create End node
    EndElement eElement = eventFactory.createEndElement("", "", name);
	    eventWriter.add(eElement);
	    eventWriter.add(end);

	  }
}
