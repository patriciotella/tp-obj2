package model;

public class VariableReal extends SeguroDeVida{

	public VariableReal(float coeficiente) {
		super(coeficiente);
	}

	public float getCoeficiente(int i) {
		return this.coeficiente;
	}


}
