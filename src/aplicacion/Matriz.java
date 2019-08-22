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
	
}
