package matrixincrement.model;

public class MatrixIncRunnableImp implements Runnable {
	// private Matrix matrix;
	// public MatrixIncRunnableImp(Matrix aMatrix) {
	// matrix = aMatrix;
	// }
//	private Matrix2 matrix;
//
//	public MatrixIncRunnableImp(Matrix2 aMatrix) {
//		matrix = aMatrix;
//	}
	private Matrix3 matrix;

	public MatrixIncRunnableImp(Matrix3 aMatrix) {
		matrix = aMatrix;
	}
//	private Matrix4 matrix;
//
//	public MatrixIncRunnableImp(Matrix4 aMatrix) {
//		matrix = aMatrix;
//	}

//	 private Matrix5 matrix;
//	 public MatrixIncRunnableImp(Matrix5 aMatrix) {
//	 matrix = aMatrix;
//	 }

	@Override
	public void run() {
		matrix.increment();

	}

}
