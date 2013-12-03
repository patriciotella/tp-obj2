package cuadroDeMarcha;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;
import prestamo.Prestamo;

public class ToXMLTest {
	
	private Converter xml;
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
		xml = new ToXML();
		s = "<cuadroMarcha> \n     <cuota> \n					<numero>1.0</numero> \n					<vencimiento>02/01/2014</vencimiento> \n					<amortizacion>500.0</amortizacion> \n					<interes>100.0</interes> \n					<saldodeuda>18000.0</saldodeuda> \n					<seguro>150.0</seguro> \n					<gastos>80.0</gastos> \n					<valorcuota>2000.0</valorcuota> \n					<valortotalcuota>2150.0</valortotalcuota> \n					<fechadepago>null</fechadepago> \n					<interesmora>0.0</interesmora> \n     </cuota> \n</cuadroMarcha>";
		s2 = "<cuadroMarcha> \n     <cuota> \n					<numero>1.0</numero> \n					<vencimiento>02/01/2014</vencimiento> \n					<amortizacion>500.0</amortizacion> \n					<interes>100.0</interes> \n					<saldodeuda>18000.0</saldodeuda> \n					<seguro>150.0</seguro> \n					<gastos>80.0</gastos> \n					<valorcuota>2000.0</valorcuota> \n					<valortotalcuota>2150.0</valortotalcuota> \n					<fechadepago>02/01/2014</fechadepago> \n					<interesmora>0.0</interesmora> \n     </cuota> \n</cuadroMarcha>";

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
	public void testLoadFileConFechaDePagoNull() {
		assertEquals(s, xml.loadFile(p));
		
	}
	
	@Test
	public void testLoadFileConFechaDePago() {
		assertEquals(s2, xml.loadFile(p2));	
	}
}
