
public class NumComplejo {
	
	private double numReal;
	private double numImag;
	 /**
	  * Constructor de la clase NumComplejo
	  * @param numReal
	  * @param numImag
	  */
	public NumComplejo(double numReal,double numImag) {
		this.numReal= numReal;
		this.numImag = numImag;
	}
	
	public double getReal() {
		return numReal;
	}
	
	public double getImag() {
		return numImag;
	}
	
	public NumComplejo getConjugado() {
		return new NumComplejo( numReal, numImag*-1);
	}
	
	public void fase() {
	
	}
	
	public void modulo() {
	
	}
}
