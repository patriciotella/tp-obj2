package cuadroDeMarcha;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import seguroDeVida.PromedioEnCuotas;
import cliente.ClienteSimple;
import configuracionGeneral.ConfiguracionGeneral;
import configuracionGeneral.GlobalesPorcentuales;
import configuracionGeneral.MensualesPorcentuales;
import configuracionGeneral.TEM;

public class ToHTMLTest {
	
	private Converter html;
	private Prestamo p;
	
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private TEM t;
	private GlobalesPorcentuales g;
	private MensualesPorcentuales m;
	private ConfiguracionGeneral cg;
	private PromedioEnCuotas s;
	private ClienteSimple c;

	@Before
	public void setUp() throws Exception {
		html = new ToHTML();
		
		fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
		fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
		t = new TEM((float) 0.015);
		g = new GlobalesPorcentuales((float)0.08);
		m = new MensualesPorcentuales((float) 0.05);
		cg = new ConfiguracionGeneral(fechaInicio, fechaFin, m, g, t);
		s = new PromedioEnCuotas((float)0.015);
		c = new ClienteSimple("cliente", "prueba", "123456", "calle falsa 123");
		
		Prestamo p = new Prestamo(50000, 10, cg, s, c);
		p.cambiarEstadoAEnCursoYAplicarCG();
	}

	@Test
	public void testLoadFile() {
		assertEquals("a", html.loadFile(p));
	}

}
