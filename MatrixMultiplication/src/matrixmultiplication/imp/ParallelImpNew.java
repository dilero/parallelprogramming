package matrixmultiplication.imp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import matrixmultiplication.model.Matrix;
import matrixmultiplication.model.MatrixGenerationTypeEnum;
import matrixmultiplication.model.MatrixMultRunnableImp;

public class ParallelImpNew {
	private static final int n = 1000;
	private static final int m = 1000;
	private static final int p = 1000;
	private static final int NTHREDS = 100;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Matrix m1 = new Matrix(n, m, MatrixGenerationTypeEnum.RANDOM);
		Matrix m2 = new Matrix(m, p, MatrixGenerationTypeEnum.RANDOM);
		Matrix result = new Matrix(m1.getN(), m2.getM(),
				MatrixGenerationTypeEnum.ZERO);
	//	System.out.println("First matrix : " + m1);
	//	System.out.println("Second matrix : " + m2);
		try {
			ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
			for (int i = 0; i < m1.getN(); i++) {
				for (int j = 0; j < m2.getM(); j++) {
					Runnable worker = new MatrixMultRunnableImp(m1, m2, result,
							i, j);
					executor.execute(worker);
				}
			}
			// This will make the executor accept no new threads
			// and finish all existing threads in the queue
			executor.shutdown();
			// Wait until all threads are finish
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	System.out.println("Result matrix : " + result);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("ParallelImpNew-Elapsed Time (ms)  : "+elapsedTime);

	}

}
