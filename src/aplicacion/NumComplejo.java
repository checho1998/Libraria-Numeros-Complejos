package aplicacion;
import java.text.DecimalFormat;
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
	
	public double fase() {
		double anguloRadianes = Math.atan(getImag()/getReal());
		double angulo = Math.toDegrees(anguloRadianes);
		DecimalFormat df = new DecimalFormat("#.##");
		double resp = Double.parseDouble(df.format(angulo));
		return resp;
	}
	
	public double modulo() {
		return Math.sqrt(getReal()*getReal()+getImag()*getImag());
	}
	
	
	
	/**
	 * Pruebitas personales
	 */
	
	public static void main(String[] args) {
		NumComplejo comple = new NumComplejo(4,-3);
		System.out.println(comple.fase());
		System.out.println(comple.modulo());
	}
}
