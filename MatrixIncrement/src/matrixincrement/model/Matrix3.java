package matrixincrement.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix3 {

	private Lock lock = new ReentrantLock();

	private int rows;
	private int cols;
	private volatile int[][] array;

	public Matrix3(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		array = new int[rows][rows];
	}

	public void increment() {
		lock.lock();
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				array[i][j]++;
		lock.unlock();
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		int rowSum;
		for (int i = 0; i < rows; i++) {
			rowSum = 0;
			for (int j = 0; j < cols; j++)
				rowSum += array[i][j];
			s.append(rowSum);
			s.append(" ");
		}
		return s.toString();
	}

}
