package matrixincrement.imp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import matrixincrement.model.Matrix3;
import matrixincrement.model.MatrixIncRunnableImp;

public class ThreadPoolImp {
	private static final int NTHREDS = 10;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// Matrix m1 = new Matrix(100, 100);
		// Matrix2 m1 = new Matrix2(100, 100);
		Matrix3 m1 = new Matrix3(100, 100);
		// Matrix4 m1 = new Matrix4(100, 100);
		// Matrix5 m1 = new Matrix5(1000, 1000);
		System.out.println("Matrix before increment : " + m1);
		try {
			ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
			for (int i = 0; i < 100; i++) {
				Runnable worker = new MatrixIncRunnableImp(m1);
				executor.execute(worker);
			}

			// This will make the executor accept no new threads
			// and finish all existing threads in the queue
			executor.shutdown();
			// Wait until all threads are finish
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Matrix after increment : " + m1);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("ThreadPoolImp-Elapsed Time (ms)  : " + elapsedTime);

	}

}
