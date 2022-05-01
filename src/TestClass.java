
public class TestClass {
	static void malWasGanzAnders(int[] x1, int[] x2) {
		x1 = x2;
	}

	public static void main(String[] args) {
		int[] iArr1 = {1, 2, 3};
		int[] iArr2 = {4, 5, 6};
		malWasGanzAnders(iArr1, iArr2);
		System.out.println(iArr1[0]);
	}

}
