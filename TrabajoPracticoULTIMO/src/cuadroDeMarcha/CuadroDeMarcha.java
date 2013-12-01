package cuadroDeMarcha;

//<cuadroMarcha>
//<cuota>
//	<numero>1</numero>
//	<vencimiento>10/09/2013</vencimiento>
//	<amortizacion>1.533,60</amortizacion>
//	<interes>300,00</interes>
//	<saldodeuda>18.466,40</saldodeuda>
//	<seguro>14,00</seguro>
//	<gastos>4,00</gastos>
//	<valorcuota>1.833,60</valorcuota>
//	<valortotalcuota>1.851,60</valortotalcuota>
//	<fechadepago>11/09/2013</fechadepago>
//	<interesmora>27,77</interesmora>
//</cuota>
//<cuota>
//</cuota>
//</cuadroMarcha>
//
//
//
//
//<!DOCTYPE html PUBLIC "-ï¿½-//W3C//DTD HTML 4.01//EN"
//"http://www.w3.org/TR/html4/strict.dtd">
//<html lang="en">
//<head>
//<meta http-ï¿½-equiv="Content-ï¿½-Type" content="text/html; charset=utf-ï¿½-8">
//<title>Cuadro de Marcha</title>
//</head>
//<body>
//<div id="cuadro">
//<div id="cuota">
//	<ul>
//		<li>Cuota 1</li>
//		<li>Vencimiento 10/09/2013</li>
//		<li>Amortizacion 1.533,60</li>
//		<li>Interï¿½s 300,00</li>
//		<li>Saldo Deuda 18.466,40</li>
//		<li>Seguro 14,00 </li>
//		<li>Gastos 4,00 </li>
//		<li>Valor Cuota 1.833,60</li>
//		<li>Valor total cuota 1.851,60</li>
//		<li>Fecha de Pago 11/09/2013</li>
//		<li>Interes  por mora 27,77<li>
//	</ul>
//	<ul>
//		<li>Cuota 2</li>
//		.....
//	</ul>
//	....
//</div>
//</div>
//</body>
//</html>

import prestamo.Prestamo;

public class CuadroDeMarcha {
	
	private Converter converter;
	
	/**
	 * Setea el conversor al formato deseado (XML o HTML).
	 * @param c Tipo de conversor seleccionado.
	 */
	public void setConverter(Converter c) {
		this.converter = c;
	}
	
	/**
	 * Exporta el cuadro de marcha del préstamo pasado por parámetro.
	 * @param p Préstamo del cual se extrae el cuadro de marcha.
	 */
	public String exportarCuadro(Prestamo p) {
		return converter.loadFile(p);
	}
	
	/**
	 * Devuelve el tipo de conversor actual.
	 */
	public Converter getConverter() {
		return this.converter;
	}
}