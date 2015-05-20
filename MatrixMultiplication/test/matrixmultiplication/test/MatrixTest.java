package matrixmultiplication.test;

import static org.junit.Assert.*;
import matrixmultiplication.model.Matrix;
import matrixmultiplication.model.MatrixGenerationTypeEnum;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testZeroMatrix() {
		Matrix m1 = new Matrix(5, 10,MatrixGenerationTypeEnum.ZERO);
		System.out.println(m1);
	}

	@Test
	public void testRandomMatrix() {
		Matrix m2 = new Matrix(5, 10,MatrixGenerationTypeEnum.RANDOM);
		System.out.println(m2);
	}

}
