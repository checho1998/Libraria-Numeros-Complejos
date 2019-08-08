
public class Library {
	
	/**
	 * Metodo que suma dos numeros complejos y retorna el nuevo
	 * numero complejo
	 * @param num1 primer numero complejo
	 * @param num2 segundo numero complejo
	 * @return nuevo numero complejo
	 */
	public static NumComplejo suma(NumComplejo num1,NumComplejo num2) {
		double sumParteRe = num1.getReal()+num2.getReal();
		double sumParteIm = num1.getImag()+num2.getImag();
		return new NumComplejo(sumParteRe,sumParteIm);
	}
	
	/**
	 * Metodo que resta dos numeros complejos y retorna el nuevo
	 * numero complejo
	 * @param num1 primer numero complejo
	 * @param num2 segundo numero complejo
	 * @return nuevo numero complejo
	 */
	public static NumComplejo resta(NumComplejo num1,NumComplejo num2) {
		double sumParteRe = num1.getReal()-num2.getReal();
		double sumParteIm = num1.getImag()-num2.getImag();
		return new NumComplejo(sumParteRe,sumParteIm);
	}
	
	/**
	 * Metodo que multiplica dos numeros complejos y retorna el nuevo
	 * numero complejo
	 * @param num1 primer numero complejo
	 * @param num2 segundo numero complejo
	 * @return nuevo numero complejo
	 */
	public static NumComplejo multiplicacion(NumComplejo num1,NumComplejo num2) {
		double sumParteRe = num1.getReal()-num2.getReal();
		double sumParteIm = num1.getImag()-num2.getImag();
		return new NumComplejo(sumParteRe,sumParteIm);
	}
}
