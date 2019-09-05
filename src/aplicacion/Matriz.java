package aplicacion;

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
}
