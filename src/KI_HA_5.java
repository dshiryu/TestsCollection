
public class KI_HA_5 {
	
	/* 1
	Implementieren Sie die Funktion double[] gradf(double[] x), 
	welche den Gradienten der Funktion f(x) = x1^2 + x2^2 zurückgibt!
	 */
	/*
	public static double[] gradf(double[] x) {
		double[] result = {0, 0};
		
		result[0] = x[0] + x[1];
		result[1] = x[0] + x[1];
		
		return result;
	}
	*/

	/* 2
	 Implementieren Sie die Funktion double[] gradf(double[] x), 
	 welche den Gradienten der Funktion f(x) = 5x1 + 2x2 zurückgibt
	 */
	/*
	public static double[] gradf(double[] x) {
		double[] result = {0, 0};
		
		result[0] = 5;
		result[1] = 2;
		
		return result;
	}
	*/
	
	/*
	 Implementieren Sie die Funktion double[] gradf(double[] x), 
	 welche den Gradienten der Funktion f(x) = loop 3 times, x^4
	 */
	public static double[] gradf(double[] x) {
		double[] result = {0, 0, 0};
		double sum;
		
		for(int i = 0; i < 3; i++) {
			sum = 0;
			for(int j = 0; j < 3; j++) {
				sum += Math.pow(x[i], 3);
			}
			
			result[i] = sum;
		}
		
		return result;
	}
	
	void oldTests() {
		/*
		// 1
		double[] ret = gradf(new double[] { 0., 0. });
		System.out.printf("%.02f %.02f\n", ret[0], ret[1]);
		//0.00 0.00
		
		double[] ret2 = gradf(new double[] { 5., 5. });
		System.out.printf("%.02f %.02f\n", ret2[0], ret2[1]);
		//10.00 10.00
		
		double[] ret3 = gradf(new double[] { -1., -1. });
		System.out.printf("%.02f %.02f\n", ret3[0], ret3[1]);
		//-2.00 -2.00
		
		double[] ret4 = gradf(new double[] { 1.5, 1.5 });
		System.out.printf("%.02f %.02f\n", ret4[0], ret4[1]);
		//3.00 3.00
		
		
		// 2 
		double[] ret2 = gradf(new double[] { 5., 2. });
		System.out.printf("%.02f %.02f\n", ret2[0], ret2[1]);
		//5.00 2.00
		
		double[] ret3 = gradf(new double[] { -1., -1. });
		System.out.printf("%.02f %.02f\n", ret3[0], ret3[1]);
		//5.00 2.00
		
		double[] ret4 = gradf(new double[] { 1.5, 1.5 });
		System.out.printf("%.02f %.02f\n", ret4[0], ret4[1]);
		//5.00 2.00
		*/
		
		// 3 
		
		
		
	}
	public static void main(String[] args) {
		double[] ret2 = gradf(new double[] { 0., 0., 0. });
		System.out.printf("%.02f %.02f %.02f\n", ret2[0], ret2[1], ret2[2]);
		//0.00 0.00 0.00
		
		double[] ret3 = gradf(new double[] { -1., -1., -1. });
		System.out.printf("%.02f %.02f %.02f\n", ret3[0], ret3[1], ret3[2]);
		//-3.00 -3.00 -3.00
		
		double[] ret4 = gradf(new double[] { 1., 0., 0. });
		System.out.printf("%.02f %.02f %.02f\n", ret4[0], ret4[1], ret4[2]);
		//3.00 0.00 0.00
		
		double[] ret5 = gradf(new double[] { 2., 2., 2. });
		System.out.printf("%.02f %.02f %.02f\n", ret5[0], ret5[1], ret5[2]);
		//24.00 24.00 24.00

	}

}

