package matrixincrement.model;

public class Matrix2 {
	private int rows;
	private int cols;
	private volatile int[][] array;

	public Matrix2(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		array = new int[rows][rows];
	}

	public void increment() {
		synchronized (array) {

			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
					array[i][j]++;
		}
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
