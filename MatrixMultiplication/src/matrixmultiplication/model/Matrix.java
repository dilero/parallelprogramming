package matrixmultiplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {

	private List<List<Integer>> matrix = new ArrayList<List<Integer>>();
	private int n;
	private int m;

	public Matrix(List<List<Integer>> matrix) {
		super();
		this.matrix = matrix;
		this.n = matrix.get(0).size();
		this.m = matrix.size();
	}

	public Matrix() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matrix(int n, int m, MatrixGenerationTypeEnum type) {
		this.n = n;
		this.m = m;
		matrix = MatrixUtil.generateMatrix(getMatrix(), n, m, type);

	}

	public int getItem(int i, int j) {
		return this.getMatrix().get(i).get(j);
	}

	public void setItem(int i, int j, int newValue) {
		this.getMatrix().get(i).set(j, newValue);
		// System.out.println("new Value = " + newValue);
	}

	public List<List<Integer>> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<List<Integer>> matrix) {
		this.matrix = matrix;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	@Override
	public String toString() {
		String newline = System.lineSeparator();
		String matrixString = new String();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String item = matrix.get(i).get(j).toString();
				matrixString = matrixString.concat(item);
				matrixString = matrixString.concat(" , ");
			}
			matrixString = matrixString.concat(newline);
		}

		return "Matrix" + newline + matrixString + "n=" + n + ", m=" + m;
	}

}
