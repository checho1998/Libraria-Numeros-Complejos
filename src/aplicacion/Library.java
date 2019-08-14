package aplicacion;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
		double resParteRe = num1.getReal()-num2.getReal();
		double resParteIm = num1.getImag()-num2.getImag();
		return new NumComplejo(resParteRe,resParteIm);
	}
	
	/**
	 * Metodo que multiplica dos numeros complejos y retorna el nuevo
	 * numero complejo
	 * @param num1 primer numero complejo
	 * @param num2 segundo numero complejo
	 * @return nuevo numero complejo
	 */
	public static NumComplejo multiplicacion(NumComplejo num1,NumComplejo num2) {
		NumComplejo respuesta = new NumComplejo(num1.getReal()*num2.getReal()+(num1.getImag()*num2.getImag()*-1),
				num1.getReal()*num2.getImag()+num1.getImag()*num2.getReal());
		
		if (respuesta.getImag()<0) {
			System.out.println(""+respuesta.getReal()+" "+respuesta.getImag()+"i");
		}
		else if(respuesta.getImag()==0){
			System.out.println(""+respuesta.getReal());
		}
		else {
			System.out.println(""+respuesta.getReal()+"+"+respuesta.getImag()+"i");
		}
		
		return respuesta;
	}
	
	/**
	 * Metodo que divide dos numeros complejos y retorna el nuevo
	 * numero complejo
	 * @param num1 primer numero complejo
	 * @param num2 segundo numero complejo
	 * @return nuevo numero complejo
	 */
	public static NumComplejo division(NumComplejo num1,NumComplejo num2) {
		
		NumComplejo conju = num2.getConjugado();
		NumComplejo divisor = Library.multiplicacion(num1,conju);
		NumComplejo dividendo = Library.multiplicacion(num2,conju);
		
		NumComplejo respuesta = new NumComplejo(divisor.getReal()/(dividendo.getReal()+dividendo.getImag()),
				    	        divisor.getImag()/(dividendo.getReal()+dividendo.getImag()));
		if (respuesta.getImag()<0) {
			System.out.println(""+respuesta.getReal()+" "+respuesta.getImag()+"i");
		}
		else if(respuesta.getImag()==0){
			System.out.println(""+respuesta.getReal());
		}
		else {
			System.out.println(""+respuesta.getReal()+"+"+respuesta.getImag()+"i");
		}
		return respuesta;
		
	}
	
	/**
	 * metodo que pasa las cordenadas polares a cartesianas
	 * @param num1 numero complejo
	 * @return un arreglo de doubles con las cordenadas
	 */
	
	public static double [] PolaresACartesianas(double r,double ang) {
		double [] arreglo= new double [2];
		arreglo[0] =r * Math.cos(ang) ;
		arreglo[1] =r*Math.sin(ang);
		
		return arreglo;
	}
	
	/**
	 * metodo que pasa las cordenadas cartesianas a polares
	 * @param num1 numero complejo
	 * @return un arreglo de doubles con las cordenadas
	 */
	
	public static double [] CartesianasAPolar(NumComplejo num1) {
		
		double [] arreglo= new double [2];
		arreglo[0] =num1.modulo() ;
		arreglo[1] =num1.fase();
		
		return arreglo;
	}
	
	
	/**
	 * Prubas pruebitas personales
	 */
	
	public static void main(String[] args) {
		
		NumComplejo num = Library.division(new NumComplejo(2,4) , new NumComplejo(3,-3));
		
	}
}
