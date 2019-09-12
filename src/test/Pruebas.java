package test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aplicacion.Library;
import aplicacion.Matriz;
import aplicacion.NumComplejo;

class Pruebas {

	@Test
	void pruebaGetConjugado() {
		NumComplejo num1 = new NumComplejo(2,7);
		NumComplejo conju = num1.getConjugado();
		assertEquals(conju.getReal(),2);
		assertEquals(conju.getImag(),-7);
	}
	
	@Test
	void pruebaFase() {
		NumComplejo num1 = new NumComplejo(3,5);
		double fase = num1.fase();
		assertEquals(fase,59.04);
	}
	
	@Test
	void pruebaModulo() {
		NumComplejo num1 = new NumComplejo(5,4);
		double modulo = num1.modulo();
		assertEquals(modulo,Math.sqrt(41));
	}
	
	@Test
	void pruebaMultiplicacion() {
		NumComplejo num1 = new NumComplejo(8,5);
		NumComplejo num2 = new NumComplejo(7,3);
		NumComplejo Resp = Library.multiplicacion(num1, num2);
		assertEquals(Resp.getReal(),41);
		assertEquals(Resp.getImag(),59);
	}
	
	@Test
	void pruebaDivision() {
		NumComplejo num1 = new NumComplejo(3,2);
		NumComplejo num2 = new NumComplejo(-1,2);
		NumComplejo Resp = Library.division(num1, num2);
		assertEquals(Resp.getReal(),0.2);
		assertEquals(Resp.getImag(),-1.6);
	}
	
	@Test
	void pruebaSuma() {
		NumComplejo num1 = new NumComplejo(4,3);
		NumComplejo num2 = new NumComplejo(7,-2);
		NumComplejo Resp = Library.suma(num1, num2);
		assertEquals(Resp.getReal(),11);
		assertEquals(Resp.getImag(),1);
	}
	
	@Test
	void pruebaResta() {
		NumComplejo num1 = new NumComplejo(15,8);
		NumComplejo num2 = new NumComplejo(6,1);
		NumComplejo Resp = Library.resta(num1, num2);
		assertEquals(Resp.getReal(),9);
		assertEquals(Resp.getImag(),7);
	}
	
	@Test
	void pruebaCartesianasAPolares() {
		NumComplejo num1 = new NumComplejo(-5,3);
		double[] Resp = Library.CartesianasAPolar(num1);
		assertEquals(Resp[0],Math.sqrt(34));
		assertEquals(Resp[1],149.04);
	}
	
	@Test
	void pruebaPolaresACartesianas() {
		NumComplejo num1 = new NumComplejo(5,30);
		double[] Resp = Library.PolaresACartesianas(5,30);
		assertEquals(Resp[0],4.330127018922194);
		assertEquals(Resp[1],2.4999999999999996);
	}
	
	
	@Test
	void pruebaSumarMatrices() {
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
		Matriz matrix3 = new Matriz(2,2);
		matrix3.addNum(0,0,new NumComplejo(3,0));
		matrix3.addNum(0,1,new NumComplejo(5,0));
		matrix3.addNum(1,0,new NumComplejo(4,0));
		matrix3.addNum(1,1,new NumComplejo(8,0));
		Matriz res = Library.sumarMatrices(matrix1, matrix2);
		
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(i, j).getReal(),matrix3.getNum(i, j).getReal());
			}
		}
		
	}
	
	@Test
	void pruebaRestarMatrices() {
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
		
		Matriz matrix3 = new Matriz(2,2);
		matrix3.addNum(0,0,new NumComplejo(1,0));
		matrix3.addNum(0,1,new NumComplejo(1,0));
		matrix3.addNum(1,0,new NumComplejo(-2,0));
		matrix3.addNum(1,1,new NumComplejo(0,0));
		Matriz res = Library.restaMatrices(matrix1, matrix2);
		
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(i, j).getReal(),matrix3.getNum(i, j).getReal());
			}
		}
		
	}
	
	
	@Test
	void pruebaMatrizTranspuesta() {
		Matriz matrix1 = new Matriz(2,3);
		matrix1.addNum(0,0,new NumComplejo(2,0));
		matrix1.addNum(0,1,new NumComplejo(3,0));
		matrix1.addNum(0,2,new NumComplejo(4,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(1,1,new NumComplejo(4,0));
		matrix1.addNum(1,2,new NumComplejo(4,0));
		
		Matriz matrix2 = new Matriz(2,3);
		matrix2.addNum(0,0,new NumComplejo(2,0));
		matrix2.addNum(0,1,new NumComplejo(3,0));
		matrix2.addNum(0,2,new NumComplejo(4,0));
		matrix2.addNum(1,0,new NumComplejo(1,0));
		matrix2.addNum(1,1,new NumComplejo(4,0));
		matrix2.addNum(1,2,new NumComplejo(4,0));
		Matriz res = matrix1.transpuesta();
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(2, 0).getReal(),matrix1.getNum(0,2).getReal());
			}
		}
	}
	
	@Test
	void pruebaMatrizInversa() {
		Matriz matrix1 = new Matriz(2,3);
		matrix1.addNum(0,0,new NumComplejo(2,0));
		matrix1.addNum(0,1,new NumComplejo(3,0));
		matrix1.addNum(0,2,new NumComplejo(4,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(1,1,new NumComplejo(4,0));
		matrix1.addNum(1,2,new NumComplejo(4,0));
		
		Matriz matrix2 = new Matriz(2,3);
		matrix2.addNum(0,0,new NumComplejo(-2,0));
		matrix2.addNum(0,1,new NumComplejo(-3,0));
		matrix2.addNum(0,2,new NumComplejo(-4,0));
		matrix2.addNum(1,0,new NumComplejo(-1,0));
		matrix2.addNum(1,1,new NumComplejo(-4,0));
		matrix2.addNum(1,2,new NumComplejo(-4,0));
		Matriz res = matrix1.inversa();
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(i,j).getReal(),matrix2.getNum(i,j).getReal());
			}
		}
	}
	
	@Test
	void pruebaMatrizConjugada() {
		Matriz matrix1 = new Matriz(2,3);
		matrix1.addNum(0,0,new NumComplejo(2,1));
		matrix1.addNum(0,1,new NumComplejo(3,2));
		matrix1.addNum(0,2,new NumComplejo(4,2));
		matrix1.addNum(1,0,new NumComplejo(1,2));
		matrix1.addNum(1,1,new NumComplejo(4,1));
		matrix1.addNum(1,2,new NumComplejo(4,2));
		
		Matriz matrix2 = new Matriz(2,3);
		matrix2.addNum(0,0,new NumComplejo(2,-1));
		matrix2.addNum(0,1,new NumComplejo(3,-2));
		matrix2.addNum(0,2,new NumComplejo(4,-2));
		matrix2.addNum(1,0,new NumComplejo(1,-2));
		matrix2.addNum(1,1,new NumComplejo(4,-1));
		matrix2.addNum(1,2,new NumComplejo(4,-2));
		Matriz res = matrix1.conjugada();
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(i,j).getImag(),matrix2.getNum(i,j).getImag());
			}
		}
	}
	
	@Test
	void pruebaMatrizadjunta() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(2,1));
		matrix1.addNum(0,1,new NumComplejo(3,2));
		matrix1.addNum(1,0,new NumComplejo(1,2));
		matrix1.addNum(1,1,new NumComplejo(4,1));
		
		Matriz matrix2 = new Matriz(2,2);
		matrix2.addNum(0,0,new NumComplejo(2,-1));
		matrix2.addNum(1,0,new NumComplejo(3,-2));
		matrix2.addNum(0,1,new NumComplejo(1,-2));
		matrix2.addNum(1,1,new NumComplejo(4,-1));
		Matriz res = matrix1.adjunta();
		for(int i = 0 ; i < res.getI();i++ ) {
			for(int j = 0 ; j < res.getJ();j++ ) {
				assertEquals(res.getNum(i,j).getImag(),matrix2.getNum(i,j).getImag());
			}
		}
	}
	
	@Test
	void pruebamultiplicacionMatriz() {
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
		
		Matriz matrix3 = new Matriz(2,2);
		matrix3.addNum(0,0,new NumComplejo(11,0));
		matrix3.addNum(0,1,new NumComplejo(16,0));
		matrix3.addNum(1,0,new NumComplejo(13,0));
		matrix3.addNum(1,1,new NumComplejo(18,0));
		
		Matriz res = Library.multiplicacionMatrices(matrix1, matrix2);
		
		for(int i = 0 ; i < matrix3.getI();i++ ) {
			for(int j = 0 ; j < matrix3.getJ();j++ ) {
				assertEquals(res.getNum(i,j).getReal(),matrix3.getNum(i,j).getReal());
			}
		}
	}
	
	@Test
	void pruebaNormalMatriz() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(2,2));
		matrix1.addNum(0,1,new NumComplejo(3,3));
		matrix1.addNum(1,0,new NumComplejo(1,3));
		matrix1.addNum(1,1,new NumComplejo(4,4));
		
		double res = Library.normalMatrices(matrix1);
		
		assertEquals(res,Math.sqrt(68));
		
	}
	
	@Test
	void distanciaEntreMatriz() {
		Matriz matrix1 = new Matriz(3,1);
		matrix1.addNum(0,0,new NumComplejo(3,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(2,0,new NumComplejo(2,0));
		
		Matriz matrix2 = new Matriz(3,1);
		matrix2.addNum(0,0,new NumComplejo(2,0));
		matrix2.addNum(1,0,new NumComplejo(2,0));
		matrix2.addNum(2,0,new NumComplejo(-1,0));
		
		double res = Library.DistanciaEntreMatrices(matrix1,matrix2);
		
		assertEquals(res,Math.sqrt(11));
		
	}
	
	@Test
	void laMatrizesUnitaria() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(0,0));
		matrix1.addNum(0,1,new NumComplejo(1,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(1,1,new NumComplejo(0,0));
		
		assertEquals(true,matrix1.isUniaria());
		
	}
	
	@Test
	void laMatrizesHermintania() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(-1,0));
		matrix1.addNum(0,1,new NumComplejo(0,-1));
		matrix1.addNum(1,0,new NumComplejo(0,1));
		matrix1.addNum(1,1,new NumComplejo(1,0));
		
		assertEquals(true,matrix1.isHermintania());
	}
	
}