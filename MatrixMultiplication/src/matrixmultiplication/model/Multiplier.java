package matrixmultiplication.model;

public class Multiplier {
	private Matrix mul1;
	private Matrix mul2;
	private int i;
	private int j;
	private volatile Matrix result;

	public Multiplier(Matrix mul1, Matrix mul2, Matrix result, int i, int j) {
		super();
		this.mul1 = mul1;
		this.mul2 = mul2;
		this.i = i;
		this.j = j;
		this.result = result;

	}

	public void multiply() {
			int resultNumber = 0;
			for (int k = 0; k < mul2.getN(); k++) {
				resultNumber = resultNumber
						+ (mul1.getItem(i, k) * mul2.getItem(k, j));
			}
		//	System.out.println("result Number " + resultNumber +" i " + i + " j" + j );
			result.setItem(i, j, resultNumber);
		//	System.out.println("Ara sonuc :" + result + " i " + i + " j" + j);
	}

	public Matrix getMul1() {
		return mul1;
	}

	public void setMul1(Matrix mul1) {
		this.mul1 = mul1;
	}

	public Matrix getMul2() {
		return mul2;
	}

	public void setMul2(Matrix mul2) {
		this.mul2 = mul2;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
