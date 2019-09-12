package application;

public class Matriz {
	
	private int i,j;
	NumComplejo[][] matrix;

	public Matriz(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		this.matrix = new NumComplejo[i][j];
	}
	
	public void addNum(int i , int j,NumComplejo numCom) {
		matrix[i][j]= numCom;
	}
	
	public NumComplejo getNum(int i , int j) {
		return matrix[i][j];
	}
	
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	public Matriz transpuesta() {
		Matriz trans = new Matriz(j,i);
		for(int u = 0;u < i ;u++) {
			for(int p = 0;p < j;p++) {
				trans.addNum(p,u,this.getNum(u, p));
			}
		}
		return trans;
	}
	
	public Matriz inversa() {
		Matriz trans = new Matriz(i,j);
		for(int u = 0;u < i ;u++) {
			for(int p = 0;p < j;p++) {
				trans.addNum(u,p,Library.multiplicacion(this.getNum(u, p), new NumComplejo(-1, -1)));
			}
		}
		return trans;
	}
	
	public Matriz conjugada() {
		Matriz trans = new Matriz(i,j);
		for(int u = 0;u < i ;u++) {
			for(int p = 0;p < j;p++) {
				trans.addNum(u,p,this.getNum(u,p).getConjugado());
			}
		}
		return trans;
	}
	
	public Matriz adjunta() {
		Matriz conju = this.conjugada();
		Matriz adjun = conju.transpuesta();
		return adjun;
	}
	
	/**
	 * metodo para saber si es una matriz unitaria
	 * @param num1 numero complejo
	 * @return un arreglo de doubles con las cordenadas
	 */
	public boolean isUniaria() {
		Matriz adjunta = this.adjunta();
		Matriz resultante =Library.multiplicacionMatrices(adjunta,this);
		Matriz unita = new Matriz(this.getI(),this.getJ());
		
		for (int x = 0 ; x<i;x++ ) {
			for (int y = 0 ; y<j;y++ ) {
				if (x == y) {
					unita.addNum(x, y, new NumComplejo(1.0,0));
				}
				else {
					unita.addNum(x, y, new NumComplejo(0,0));
				}
			}
		}
		boolean flag = true ;
		for (int x = 0 ; x<i;x++ ) {
			for (int y = 0 ; y<j;y++ ) {
				if(resultante.getNum(x, y).getReal()!=unita.getNum(x, y).getReal()) {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public boolean isHermintania(){
		boolean flag = false;
		for (int x = 0 ; x<i;x++ ) {
			for (int y = 0 ; y<j;y++ ) {
				if (this.getNum(x, y).getImag() == this.getNum(y, x).getConjugado().getImag() ) {
					if (this.getNum(x, y).getReal() == this.getNum(y, x).getConjugado().getReal() ) {
						flag = true ;
					}
				}
			}
		}
		return flag ;
	}
}
