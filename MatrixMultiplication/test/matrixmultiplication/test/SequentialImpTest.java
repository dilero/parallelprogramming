package matrixmultiplication.test;

import static org.junit.Assert.*;
import matrixmultiplication.imp.SequentiaImp;
import matrixmultiplication.model.Matrix;
import matrixmultiplication.model.MatrixGenerationTypeEnum;

import org.junit.Test;

public class SequentialImpTest {
	private static final int n = 10000;
	private static final int m = 10000;
	private static final int p = 10000;

	@Test
	public void multiplyTest() {
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

}
