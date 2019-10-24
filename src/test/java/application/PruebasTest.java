package application;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasTest {

	@Test
	public void pruebaGetConjugado() {
		NumComplejo num1 = new NumComplejo(2,7);
		NumComplejo conju = num1.getConjugado();
		assertEquals(conju.getReal(),2,0);
		assertEquals(conju.getImag(),-7,0);
	}
	
	@Test
	public void pruebaFase() {
		NumComplejo num1 = new NumComplejo(3,5);
		double fase = num1.fase();
		assertEquals(fase,59.04,0);
	}
	
	@Test
	public void pruebaModulo() {
		NumComplejo num1 = new NumComplejo(5,4);
		double modulo = num1.modulo();
		assertEquals(modulo,Math.sqrt(41),0);
	}
	
	@Test
	public void pruebaMultiplicacion() {
		NumComplejo num1 = new NumComplejo(8,5);
		NumComplejo num2 = new NumComplejo(7,3);
		NumComplejo Resp = Library.multiplicacion(num1, num2);
		assertEquals(Resp.getReal(),41,0);
		assertEquals(Resp.getImag(),59,0);
	}
	
	@Test
	public void pruebaDivision() {
		NumComplejo num1 = new NumComplejo(3,2);
		NumComplejo num2 = new NumComplejo(-1,2);
		NumComplejo Resp = Library.division(num1, num2);
		assertEquals(Resp.getReal(),0.2,0);
		assertEquals(Resp.getImag(),-1.6,0);
	}
	
	@Test
	public void pruebaSuma() {
		NumComplejo num1 = new NumComplejo(4,3);
		NumComplejo num2 = new NumComplejo(7,-2);
		NumComplejo Resp = Library.suma(num1, num2);
		assertEquals(Resp.getReal(),11,0);
		assertEquals(Resp.getImag(),1,0);
	}
	
	@Test
	public void pruebaResta() {
		NumComplejo num1 = new NumComplejo(15,8);
		NumComplejo num2 = new NumComplejo(6,1);
		NumComplejo Resp = Library.resta(num1, num2);
		assertEquals(Resp.getReal(),9,0);
		assertEquals(Resp.getImag(),7,0);
	}
	
	@Test
	public void pruebaCartesianasAPolares() {
		NumComplejo num1 = new NumComplejo(-5,3);
		double[] Resp = Library.CartesianasAPolar(num1);
		assertEquals(Resp[0],Math.sqrt(34),0);
		assertEquals(Resp[1],149.04,0);
	}
	
	@Test
	public void pruebaPolaresACartesianas() {
		NumComplejo num1 = new NumComplejo(5,30);
		double[] Resp = Library.PolaresACartesianas(5,30);
		assertEquals(Resp[0],4.330127018922194,0);
		assertEquals(Resp[1],2.4999999999999996,0);
	}
	
	
	@Test
	public void pruebaSumarMatrices() {
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
				assertEquals(res.getNum(i, j).getReal(),matrix3.getNum(i, j).getReal(),0);
			}
		}
		
	}
	
	@Test
	public void pruebaRestarMatrices() {
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
				assertEquals(res.getNum(i, j).getReal(),matrix3.getNum(i, j).getReal(),0);
			}
		}
		
	}
	
	
	@Test
	public void pruebaMatrizTranspuesta() {
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
				assertEquals(res.getNum(2, 0).getReal(),matrix1.getNum(0,2).getReal(),0);
			}
		}
	}
	
	@Test
	public void pruebaMatrizInversa() {
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
				assertEquals(res.getNum(i,j).getReal(),matrix2.getNum(i,j).getReal(),0);
			}
		}
	}
	
	@Test
	public void pruebaMatrizConjugada() {
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
				assertEquals(res.getNum(i,j).getImag(),matrix2.getNum(i,j).getImag(),0);
			}
		}
	}
	
	@Test
	public void pruebaMatrizadjunta() {
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
				assertEquals(res.getNum(i,j).getImag(),matrix2.getNum(i,j).getImag(),0);
			}
		}
	}
	
	@Test
	public void pruebamultiplicacionMatriz() {
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
				assertEquals(res.getNum(i,j).getReal(),matrix3.getNum(i,j).getReal(),0);
			}
		}
	}
	
	@Test
	public void pruebaNormalMatriz() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(2,2));
		matrix1.addNum(0,1,new NumComplejo(3,3));
		matrix1.addNum(1,0,new NumComplejo(1,3));
		matrix1.addNum(1,1,new NumComplejo(4,4));
		
		double res = Library.normalMatrices(matrix1);
		
		assertEquals(res,Math.sqrt(68),0);
		
	}
	
	@Test
	public void distanciaEntreMatriz() {
		Matriz matrix1 = new Matriz(3,1);
		matrix1.addNum(0,0,new NumComplejo(3,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(2,0,new NumComplejo(2,0));
		
		Matriz matrix2 = new Matriz(3,1);
		matrix2.addNum(0,0,new NumComplejo(2,0));
		matrix2.addNum(1,0,new NumComplejo(2,0));
		matrix2.addNum(2,0,new NumComplejo(-1,0));
		
		double res = Library.DistanciaEntreMatrices(matrix1,matrix2);
		
		assertEquals(res,Math.sqrt(11),0);
		
	}
	
	@Test
	public void laMatrizesUnitaria() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(0,0));
		matrix1.addNum(0,1,new NumComplejo(1,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(1,1,new NumComplejo(0,0));
		
		assertEquals(true,matrix1.isUniaria());
		
	}
	
	@Test
	public void laMatrizesHermintania() {
		Matriz matrix1 = new Matriz(2,2);
		matrix1.addNum(0,0,new NumComplejo(-1,0));
		matrix1.addNum(0,1,new NumComplejo(0,-1));
		matrix1.addNum(1,0,new NumComplejo(0,1));
		matrix1.addNum(1,1,new NumComplejo(1,0));
		
		assertEquals(true,matrix1.isHermintania());
	}
        //
        @Test
	public void tensor() {
		Matriz matrix1 = new Matriz(2,1);
		matrix1.addNum(0,0,new NumComplejo(1,0));
		matrix1.addNum(1,0,new NumComplejo(2,0));
               
		
		Matriz matrix2 = new Matriz(2,2);
		matrix2.addNum(0,0,new NumComplejo(1,0));
		matrix2.addNum(1,0,new NumComplejo(3,0));
		matrix2.addNum(0,1,new NumComplejo(2,0));
		matrix2.addNum(1,1,new NumComplejo(4,0));
                
                Matriz res = new Matriz(4,2);
		res.addNum(0,0,new NumComplejo(1,0));
		res.addNum(1,0,new NumComplejo(3,0));
		res.addNum(0,1,new NumComplejo(2,0));
		res.addNum(1,1,new NumComplejo(4,0));
		res.addNum(2,0,new NumComplejo(2,0));
		res.addNum(3,0,new NumComplejo(6,0));
		res.addNum(2,1,new NumComplejo(4,0));
		res.addNum(3,1,new NumComplejo(8,0));
                Matriz comp = Library.productoTensor(matrix1, matrix2);
		
                System.out.println(comp.getNum(0, 0).getReal()+"sergio"+res.getNum(0,0).getReal());
	}
        
        @Test
	public void deberiaSimularExperimentoDeCanicas() {

		double[][] matr1 = {{0,0,0,0,0,0,0,0},{0.5,0,0,0,0,0,0,0},{0.5,0,0,0,0,0,0,0},{0,0.33,0,1,0,0,0,0},{0,0.33,0,0,1,0,0,0},{0,0.33,0.33,0,0,1,0,0},{0,0,0.33,0,0,0,1,0},{0,0,0.33,0,0,0,0,1}};
		
		NumComplejo num1 = new NumComplejo(1,0);
		NumComplejo num2 = new NumComplejo(0,0);
		NumComplejo num3 = new NumComplejo(0,0);
		NumComplejo num4 = new NumComplejo(0,0);
		NumComplejo num5 = new NumComplejo(0,0);
		NumComplejo num6 = new NumComplejo(0,0);
		NumComplejo num7 = new NumComplejo(0,0);
		NumComplejo num8 = new NumComplejo(0,0);
		
		NumComplejo[] vect1 = new NumComplejo[8];
		
		vect1[0] = num1;
		vect1[1] = num2;
		vect1[2] = num3;
		vect1[3] = num4;
		vect1[4] = num5;
		vect1[5] = num6;
		vect1[6] = num7;
		vect1[7] = num8;
		
		NumComplejo[] res = Library.multiplesRendijas(matr1, 1, 2, vect1);
		
		assertEquals(0,res[0].getReal(),0);
		assertEquals(0,res[0].getImag(),0);
		assertEquals(0,res[1].getReal(),0);
		assertEquals(0,res[1].getImag(),0);
		assertEquals(0,res[2].getReal(),0);
		assertEquals(0,res[2].getImag(),0);
		assertEquals(0.165,res[3].getReal(),0);
		assertEquals(0,res[3].getImag(),0);
		assertEquals(0.165,res[4].getReal(),0);
		assertEquals(0,res[4].getImag(),0);
		assertEquals(0.33,res[5].getReal(),0);
		assertEquals(0,res[5].getImag(),0);
		assertEquals(0.165,res[6].getReal(),0);
		assertEquals(0,res[6].getImag(),0);
		assertEquals(0.165,res[7].getReal(),0);
		assertEquals(0,res[7].getImag(),0);
	}
        
        @Test
	public void deberiaSimularExperimentoDeMultiplesRendijas() {
		NumComplejo num1 = new NumComplejo(3,-2);
		NumComplejo num2 = new NumComplejo(1,1);
		NumComplejo num3 = new NumComplejo(5,-6);
		NumComplejo num4 = new NumComplejo(0,1);
		NumComplejo num5 = new NumComplejo(4,2);
		NumComplejo num6 = new NumComplejo(3,-1);
		NumComplejo num7 = new NumComplejo(4,-1);
		NumComplejo num8 = new NumComplejo(2,-2);
		NumComplejo num9 = new NumComplejo(1,-2);
		
		NumComplejo num10 = new NumComplejo(5,-1);
		NumComplejo num11 = new NumComplejo(2,-1);
		NumComplejo num12 = new NumComplejo(2,-1);

		NumComplejo[][] matr1 = new NumComplejo [3][3];
		NumComplejo[] vect1 = new NumComplejo[3];
		
		matr1[0][0] = num1;
		matr1[0][1] = num2;
		matr1[0][2] = num3;
		matr1[1][0] = num4;
		matr1[1][1] = num5;
		matr1[1][2] = num6;
		matr1[2][0] = num7;
		matr1[2][1] = num8;
		matr1[2][2] = num9;
		
		vect1[0] = num10;
		vect1[1]= num11;
		vect1[2]= num12;
		
		NumComplejo[] res = Library.multiplesRendijasComplejos(matr1, 2, 3, vect1);
	}
        
        @Test 
	public void deberiaSacarLaProbabilidadDeUnaParticulaEnUnaPosicion() {
		NumComplejo num1 = new NumComplejo(-3,-1);
		NumComplejo num2 = new NumComplejo(0,-2);
		NumComplejo num3 = new NumComplejo(0,1);
		NumComplejo num4 = new NumComplejo(2,0);
		
		NumComplejo[] vect1 = new NumComplejo[4];
		
		vect1[0] = num1;
		vect1[1]= num2;
		vect1[2]= num3;
		vect1[3]= num4;
		
		double res = Library.calcularProbabilidadDeParticulaEnUnaPosicionDeSistemaCuantico(4, 2, vect1);
		
		assertEquals(0.05263157894736841,res,0);
	}
        
        @Test
	public void deberiaSacarDistanciaEntreKets() {
		NumComplejo c1 = new NumComplejo(3, 2);
		NumComplejo c2 = new NumComplejo(0, 0);
		NumComplejo c3 = new NumComplejo(5, -6);
		NumComplejo c4 = new NumComplejo(1, 0);
		NumComplejo c5 = new NumComplejo(4, 2);
		NumComplejo c6 = new NumComplejo(0, 1);
		
		NumComplejo[] k1 = new NumComplejo[] { c1, c2, c3 };
		NumComplejo[] k2 = new NumComplejo[] { c4, c5, c6 };
		
		double res = Library.calcularDistanciaEntreKets(k1, k2);
		
		assertEquals(Math.sqrt(102),res,0);
	}
        
        @Test
	public void deberiaSacarLaMedia() {
		NumComplejo c1 = new NumComplejo(3, 2);
		NumComplejo c2 = new NumComplejo(0, 0);
		NumComplejo c3 = new NumComplejo(5, -6);
		NumComplejo c4 = new NumComplejo(1, 0);
		NumComplejo c5 = new NumComplejo(4, 2);
		NumComplejo c6 = new NumComplejo(0, 1);
		
		NumComplejo[] k1 = new NumComplejo[] { c1, c2, c3 };
		NumComplejo[] k2 = new NumComplejo[] { c4, c5, c6 };
		
		double res = Library.calcularDistanciaEntreKets(k1, k2);
		
		assertEquals(Math.sqrt(102),res,0);
	}
	
	@Test
	public void deberiaCalcularLaVarianza() {
		
		Matriz matrix1 = new Matriz(3,1);
		matrix1.addNum(0,0,new NumComplejo(3,0));
		matrix1.addNum(1,0,new NumComplejo(1,0));
		matrix1.addNum(2,0,new NumComplejo(2,0));
		
		Matriz matrix2 = new Matriz(3,1);
		matrix2.addNum(0,0,new NumComplejo(2,0));
		matrix2.addNum(1,0,new NumComplejo(2,0));
		matrix2.addNum(2,0,new NumComplejo(-1,0));
		
		double res = Library.DistanciaEntreMatrices(matrix1,matrix2);
		
		assertEquals(res,Math.sqrt(11),0);
	}
	
	
}