package busqueda;

import cliente.ClienteSimple;
import prestamo.Prestamo;

public class ApellidoCliente extends Filtro {
	
	private String apellido;

	public ApellidoCliente(String apellido) {
		super();
		this.apellido = apellido;
	}

	public boolean filtrarPor(Prestamo p) {
		if(p.getCliente().equals(ClienteSimple.class))
			return (this.apellido.startsWith(p.getCliente().getApellido()));
		else{
			boolean aux = true;
			for (int i = 0; i < p.getCliente().getClientes(); i++) {
				
			}
		}
	}

}
