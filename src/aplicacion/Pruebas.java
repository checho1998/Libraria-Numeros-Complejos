package aplicacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
