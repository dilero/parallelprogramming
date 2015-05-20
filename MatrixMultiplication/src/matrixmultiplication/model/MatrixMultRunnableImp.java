package matrixmultiplication.model;


public class MatrixMultRunnableImp implements Runnable {
	private Multiplier multiplier;
	
	

	public MatrixMultRunnableImp(Matrix m1, Matrix m2,Matrix result,int i, int j) {
		super();
		multiplier= new Multiplier(m1,m2,result, i, j);
	}



	@Override
	public void run() {
		multiplier.multiply();
		
	}



	public Multiplier getMultiplier() {
		return multiplier;
	}



	public void setMultiplier(Multiplier multiplier) {
		this.multiplier = multiplier;
	}

}
