package matrixmultiplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixUtil {

	public static List<List<Integer>> generateMatrix(
			List<List<Integer>> matrix, int n, int m,
			MatrixGenerationTypeEnum type) {
		List<Integer> row = generateRow(m, type);
		for (int i = 0; i < n; i++) {
			row = generateRow(m, type);
			matrix.add(row);

		}
		return matrix;
	}

	public static List<Integer> generateRow(int m, MatrixGenerationTypeEnum type) {
		Random random = new Random();
		List<Integer> row = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			if (type.equals(MatrixGenerationTypeEnum.ZERO))
				row.add(0);
			else if (type.equals(MatrixGenerationTypeEnum.RANDOM)) {
				int randomNumber;
				randomNumber = random.nextInt(100);
				row.add(randomNumber);
			}
		}
		return row;
	}
}
