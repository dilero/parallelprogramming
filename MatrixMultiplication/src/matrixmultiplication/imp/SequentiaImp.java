package matrixmultiplication.imp;

import matrixmultiplication.model.Matrix;
import matrixmultiplication.model.MatrixGenerationTypeEnum;

public class SequentiaImp {

	private static final int n = 100;
	private static final int m = 10000;
	private static final int p = 100;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Matrix m1 = new Matrix(n, m, MatrixGenerationTypeEnum.RANDOM);
		Matrix m2 = new Matrix(m, p, MatrixGenerationTypeEnum.RANDOM);
//		System.out.println("First matrix :" +m1);
//		System.out.println("Second matrix :" +m2);
		SequentiaImp m= new SequentiaImp();
		Matrix result = m.multiply(m1, m2);
//		System.out.println("Result matrix :" +result);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("SequentialImp-Elapsed Time (ms)  : "+elapsedTime);

	}

	public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {
		int n = firstMatrix.getN();
		int m = secondMatrix.getM();
		int result = 0;
		Matrix resulMatrix = new Matrix(n, m, MatrixGenerationTypeEnum.ZERO);
		for (int i = 0; i < firstMatrix.getN(); i++) {
			for (int j = 0; j < secondMatrix.getM(); j++) {
				for (int k = 0; k < secondMatrix.getN(); k++) {
					result = result + firstMatrix.getItem(i, k)
							* secondMatrix.getItem(k, j);
				}
				resulMatrix.setItem(i, j, result);
				result = 0;
			}

		}

		return resulMatrix;
	}

}
