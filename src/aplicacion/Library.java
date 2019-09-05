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
			//System.out.println(""+respuesta.getReal()+" "+respuesta.getImag()+"i");
		}
		else if(respuesta.getImag()==0){
			//System.out.println(""+respuesta.getReal());
		}
		else {
			//System.out.println(""+respuesta.getReal()+"+"+respuesta.getImag()+"i");
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
		arreglo[0] =r * Math.cos(Math.toRadians(ang) ) ;
		arreglo[1] =r*Math.sin(Math.toRadians(ang));
		
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
		if(arreglo[1]<0) {
			arreglo[1] = 180 + arreglo[1];
		}
		
		return arreglo;
	}
	
	/**
	 * metodo resta dos matrices
	 * @param num1 numero complejo
	 * @return un arreglo de doubles con las cordenadas
	 */
	
	public static Matriz sumarMatrices(Matriz matrix1,Matriz matrix2) {
		
		if(matrix1.getI()==matrix2.getI()) {
			Matriz matrxNew = new Matriz(matrix1.getI(), matrix2.getJ());
			for(int x = 0;x<matrxNew.getI();x++) {
				for(int y = 0;y<matrxNew.getJ();y++) {
					matrxNew.addNum(x, y,suma( matrix1.getNum(x, y),matrix2.getNum(x, y)));
				}
			}
			return matrxNew;
		}
		return null;
	}
	
	/**
	 * metodo resta dos matrices
	 * @param num1 numero complejo
	 * @return un arreglo de doubles con las cordenadas
	 */
	public static Matriz restaMatrices(Matriz matrix1,Matriz matrix2) {
		
		if(matrix1.getI()==matrix2.getI()) {
			Matriz matrxNew = new Matriz(matrix1.getI(), matrix2.getJ());
			for(int x = 0;x<matrxNew.getI();x++) {
				for(int y = 0;y<matrxNew.getJ();y++) {
					matrxNew.addNum(x, y,resta( matrix1.getNum(x, y),matrix2.getNum(x, y)));
				}
			}
			return matrxNew;
		}
		return null;
	}
	
	/**
	 * Prubas pruebitas personales
	 */
	
	public static void main(String[] args) {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(2,0));
		matrix1.addNum(0,1,new NumComplejo(3,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(1,1,new NumComplejo(4,0));
		Matriz matrix2 = new Matriz(2,2);
		matrix2.addNum(0,0,new NumComplejo(1,0));
		matrix2.addNum(0,1,new NumComplejo(2,0));
		matrix2.addNum(1,0,new NumComplejo(3,0));
		matrix2.addNum(1,1,new NumComplejo(4,0));
		
		Matriz num = Library.sumarMatrices(matrix1, matrix2);
		
		System.out.println(num.getNum(0,0).getReal());
		System.out.println(num.getNum(0,1).getReal());
		System.out.println(num.getNum(1,0).getReal());
		System.out.println(num.getNum(1,1).getReal());
		
	}
}
