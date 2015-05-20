package matrixincrement.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Matrix4 {
	private int rows;
	private int cols;
	private volatile AtomicInteger[][] array;

	public Matrix4(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		array = new AtomicInteger[rows][cols];
		constructArray();
	}

	private void constructArray() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[i][j] = new AtomicInteger(0);
			}
		}
	}

	public void increment() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[i][j].getAndIncrement();

			}
		}
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		int rowSum;
		for (int i = 0; i < rows; i++) {
			rowSum = 0;
			for (int j = 0; j < cols; j++)
				rowSum += array[i][j].get();
			s.append(rowSum);
			s.append(" ");
		}
		return s.toString();
	}
}
