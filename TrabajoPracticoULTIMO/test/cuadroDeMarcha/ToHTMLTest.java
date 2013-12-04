package cuadroDeMarcha;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import cuota.Cuota;

public class ToHTMLTest {
	
	private Converter html;
	private Prestamo p;
	private Prestamo p2;
	private String s;
	private String s2;
	private List<Cuota> cs = new ArrayList<Cuota>();
	private List<Cuota> cs2 = new ArrayList<Cuota>();
	private Cuota c1;
	private Cuota c2;

	@Before
	public void setUp() throws Exception {
		html = new ToHTML();
		s = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN \n    \"http://www.w3.org/TR/html4/strict.dtd\"> \n<html lang=\"en\"> \n<head> \n           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n           <title>Cuadro de Marcha</title> \n</head> \n<body> \n<div id=\"cuadro\"> \n          <div id=\"cuota\"> \n                       <ul> \n                                 <li>Cuota 1.0</li> \n                                 <li>Vencimiento 02/01/2014</li> \n                                 <li>Amortizacion 500.0</li> \n                                 <li>Inter�s 100.0</li> \n                                 <li>Saldo Deuda 18000.0</li> \n                                 <li>Seguro 150.0</li> \n                                 <li>Gastos 80.0</li> \n                                 <li>Valor Cuota 2000.0</li> \n                                 <li>Valor total cuota 2150.0</li> \n                                 <li>Fecha de Pago null</li> \n                                 <li>Interes  por mora 0.0<li> \n                       </ul> \n          </div> \n</div> \n</body> \n</html> ";
		s2 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN \n    \"http://www.w3.org/TR/html4/strict.dtd\"> \n<html lang=\"en\"> \n<head> \n           <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n           <title>Cuadro de Marcha</title> \n</head> \n<body> \n<div id=\"cuadro\"> \n          <div id=\"cuota\"> \n                       <ul> \n                                 <li>Cuota 1.0</li> \n                                 <li>Vencimiento 02/01/2014</li> \n                                 <li>Amortizacion 500.0</li> \n                                 <li>Inter�s 100.0</li> \n                                 <li>Saldo Deuda 18000.0</li> \n                                 <li>Seguro 150.0</li> \n                                 <li>Gastos 80.0</li> \n                                 <li>Valor Cuota 2000.0</li> \n                                 <li>Valor total cuota 2150.0</li> \n                                 <li>Fecha de Pago 02/01/2014</li> \n                                 <li>Interes  por mora 0.0<li> \n                       </ul> \n          </div> \n</div> \n</body> \n</html> ";

		p = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		c1 = mock(Cuota.class);
		c2 = mock(Cuota.class);
		cs.add(c1);
		cs2.add(c2);
		GregorianCalendar f = new GregorianCalendar(2013, 12, 02);
	
		when(p.getCuotas()).thenReturn(cs);
		when(c1.getNroCuota()).thenReturn(1);
		when(c1.getFechaVencimiento()).thenReturn(f);
		when(c1.getAmortizacion()).thenReturn((float)500);
		when(c1.getInteres()).thenReturn((float) 100);
		when(c1.getSaldoDeDeuda()).thenReturn((float)18000);
		when(c1.getSeguroDeVida()).thenReturn((float)150);
		when(c1.getGastoMensual()).thenReturn((float)80);
		when(c1.getValorCuotaNeto()).thenReturn((float)2000);
		when(c1.getValorTotalDeCuota()).thenReturn((float)2150);
		when(c1.getFechaDePago()).thenReturn(null);
		when(c1.getInteresPorMora()).thenReturn((float)0);
		
		GregorianCalendar f2 = new GregorianCalendar(2013, 12, 02);
		when(p2.getCuotas()).thenReturn(cs2);
		when(c2.getNroCuota()).thenReturn(1);
		when(c2.getFechaVencimiento()).thenReturn(f);
		when(c2.getAmortizacion()).thenReturn((float)500);
		when(c2.getInteres()).thenReturn((float) 100);
		when(c2.getSaldoDeDeuda()).thenReturn((float)18000);
		when(c2.getSeguroDeVida()).thenReturn((float)150);
		when(c2.getGastoMensual()).thenReturn((float)80);
		when(c2.getValorCuotaNeto()).thenReturn((float)2000);
		when(c2.getValorTotalDeCuota()).thenReturn((float)2150);
		when(c2.getFechaDePago()).thenReturn(f2);
		when(c2.getInteresPorMora()).thenReturn((float)0);
	}
	
	@Test
	public void testLoadFileConFechaDePago() {
		assertEquals(s2, html.loadFile(p2));	
	}

}
