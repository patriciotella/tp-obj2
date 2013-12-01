package cuadroDeMarcha;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;
import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;

public class ToXMLTest {
	
	private Converter xml;
	private Prestamo p;
	private String s;

	@Before
	public void setUp() throws Exception {
		xml = new ToXML();
		
		GregorianCalendar fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
		GregorianCalendar fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
		TEM t = new TEM((float) 0.015);
		GlobalesPorcentuales g = new GlobalesPorcentuales((float)0.08);
		MensualesPorcentuales m = new MensualesPorcentuales((float) 0.05);
		ConfiguracionGeneral cg = new ConfiguracionGeneral(fechaInicio, fechaFin, m, g, t);
		PromedioEnCuotas s = new PromedioEnCuotas((float)0.015);
		ClienteSimple c = new ClienteSimple("cliente", "prueba", "123456", "calle falsa 123");
		
		Prestamo p = new Prestamo(50000, 10, cg, s, c);
		p.cambiarEstadoAEnCursoYAplicarCG();
	}

	@Test
	public void testLoadFile() {
		assertEquals("a", xml.loadFile(p));
		
	}

}
