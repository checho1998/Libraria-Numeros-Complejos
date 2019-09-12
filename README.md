# Libreria-Numeros-Complejos

## Como Instalar y Correr el Codigo

- Debe estar en el directorio donde quiere traer el repositorio
- Para traer el repositorio a el directorio que usted desee, debe abrir la consola del PC e ingresar este codigo:
```
$ git clone https://github.com/checho1998/Libreria-Numeros-Complejos.git
```
- luego debe ingresar el siguiente codigo para limpiar y compilar el programa desde el directorio donde este el programa
```
$ mvn clean install 
```
- Podria tambien usar el siguiente codigo para provar las pruebas y ver su completa funcionalidad
```
$ mvn test
```

## Comenzando

En este repositorio se encontrara una libreria realizada en Java, cuyo objetivo es servir para realizar
todas las operaciones de una calculadora de numeros complejos.

## Utilidades

### Version 1

  - Suma de numeros complejos.
  - Producto de numeros complejos.
  - Resta de numeros complejos.
  - División de numeros complejos.
  - Módulo de un número complejo.
  - Conjugado de un número complejo.
  - Fase de un número complejo.
  - Cordenadas Polares.
  - Cordenadas Cartesianas.
### Version 2
  - Adición de vectores complejos.
  - Inversa de vectores complejos.
  - Multiplicación escalar de vectores complejos.
  - Adición de matrices complejos.
  - Inversa de matrices complejos.
  - Multiplicación escalar de matrices complejas.
  - Matriz transpuesta
  - Matriz conjugada
  - Matriz adjunta
  - Función para calcular la "acción" de una matriz sobre un vector.
  - Norma de matrices
  - Distancia entrematrices
  - Revisar si es unitaria
  - Revisar si es Hermitian
  - Producto tensor.
  
## Requisitos

Para hacer uso de esta libreria es necesario tener un IDE( Eclipse, Netbeans, etc... ),
adicionalmente de contar con los archivos de este repositorio y tener un conocimiento basico en Java.

## Como Provar

- Para probar se pueden realizar pruebas como la siguiente y correrlas con el codigo ya indicado anteriormente 

``` Java
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
```
## Construido en lenguaje
  
  - Java (V8)
  
## Ejecutar Pruebas

Las pruebas estan desarrolladas con la dependencia de JUnit 5, por lo tanto es necesario tenerla
en el pc donde se corran.

## Autor

- Sergio Alejandro Nuñez Mendivelso
