package model;

import java.io.IOException;

public class ClienteConPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, int monto, int cuotas) {
		// REVISAR por qué adrian es trolo. y por què cuando es 'n' sale dos veces el syso
		int tecla = 0; 
		int cuotasAgregadas = cuotas;
		System.out.println("Tu prestamo de $" + monto + " se dividira en " + cuotas + " cuotas de $" + this.calcularCuotas(monto,cuotas) + ". Pulse 'y' si esta de acuerdo o 'n' si quiere mas cuotas:");
		if(tecla == 0){
			try {
				tecla = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*
		 * 
		 
		while(tecla == 'n'){
			cuotasAgregadas++;
			System.out.println("nTu prestamo de $" + monto + " se dividira en " + cuotasAgregadas + " cuotas de $" + this.calcularCuotas(monto,cuotasAgregadas) + ". Pulse 'y' si esta de acuerdo o 'n' si quiere mas cuotas:");
			try {
				tecla = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Prestamo en etapa de revision"); 
		*/
		//CLICKEO SI:
		/*
		 *  Prestamo p= new Prestamo(cosas de prestamo);
		 *  prestamos.add(p);
		 *  new g�indou; te notificamos los vencimientos?
		 */
		if(tecla == 'y'){
			System.out.println("Prestamo en etapa de revision"); 
		}
		else{
		//	if(tecla == 'n'){
				this.solicitarPrestamo( monto, cuotasAgregadas+3);	//si se saca este if entra a 'n' dos veces
			//}
		} 
	}
	
	private float calcularCuotas(int monto, int cuotas) {
		return (monto/cuotas);
	}


}
