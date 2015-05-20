package matrixmultiplication.imp;

import java.util.ArrayList;
import java.util.List;

import matrixmultiplication.model.Matrix;
import matrixmultiplication.model.MatrixGenerationTypeEnum;
import matrixmultiplication.model.MatrixMultRunnableImp;
import matrixmultiplication.model.Multiplier;

public class ParallelImpOld {
	private static final int n = 100;
	private static final int m = 10000;
	private static final int p = 100;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Matrix m1 = new Matrix(n, m, MatrixGenerationTypeEnum.RANDOM);
		Matrix m2 = new Matrix(m, p, MatrixGenerationTypeEnum.RANDOM);
		Matrix result = new Matrix(m1.getN(), m2.getM(),
				MatrixGenerationTypeEnum.ZERO);
		List<MatrixMultRunnableImp> runnables = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
//		System.out.println("First matrix : " + m1);
//		System.out.println("Second matrix : " + m2);
		try {
			for (int i = 0; i < m1.getN(); i++) {
				for (int j = 0; j < m2.getM(); j++) {
					runnables.add(new MatrixMultRunnableImp(m1, m2, result, i,
							j));
				}
			}
			for (MatrixMultRunnableImp aRunnable : runnables) {
				threads.add(new Thread(aRunnable));
			}
			for (Thread aThread : threads) {
				aThread.start();
			}
			for (Thread aThread : threads) {
				aThread.join();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("Result matrix : " + result);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("ParellelImpOld-Elapsed Time (ms)  : "+elapsedTime);
	}

}
