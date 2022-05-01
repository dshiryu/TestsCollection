import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class KI_HA_10 {

	/* 1
	 Um Daten zu normieren, müssen erst die spaltenweisen Minima und Maxima bestimmt werden. 
	 Implementieren Sie eine Methode *findMin*, 
	 welche ein 2D-Array X vom Typ double als Parameter nimmt und ein 1D-Array zurückliefert, 
	 welches die kleinsten Werte jeder Spalte enthält. 
	 Sie dürfen annehmen dass X mindestens eine Zeile hat, und alle Einträge kleiner als 100 sind.
	 */
	public static double[] findMin(double[][] X) {
	    double[] result = new double[X[0].length];
		// i = column, j = row
	    for(int i = 0; i < X[0].length; i++) {
	    	double temp = temp = X[0][i];
			for(int j = 1; j < X.length; j++) {
	    		if(X[j][i] < temp) temp = X[j][i];
			}
			result[i] = temp;
		}
		return result;
	}
	
	
	
	/* 2
	 Um Daten zu normieren, müssen erst die spaltenweisen Minima und Maxima bestimmt werden. 
	 Implementieren Sie eine Methode *findMax*, 
	 welche ein 2D-Array X vom Typ double als Parameter nimmt und ein 1D-Array zurückliefert, 
	 welches die größten Werte jeder Spalte enthält. 
	 Sie dürfen annehmen dass X mindestens eine Zeile hat, und alle Einträge größer als -100 sind.
	 */
	public static double[] findMax(double[][] X) {
		double[] result = new double[X[0].length];
		// i = column, j = row
	    for(int i = 0; i < X[0].length; i++) {
	    	double temp = temp = X[0][i];
			for(int j = 1; j < X.length; j++) {
	    		if(X[j][i] > temp) temp = X[j][i];
			}
			result[i] = temp;
		}
		return result;
	}
	
	/* 3
	 Implementieren Sie eine Funktion normMinMax, 
	 welche einen double-Parameter *x* und die double-PArameter *min* und *max* erwartet, 
	 und den auf [0,1] normierten Wert von x zurückgibt.
	 */
	
	static void print(double x) {
	    DecimalFormat df = new DecimalFormat("#.#");
	    DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
	    dfs.setDecimalSeparator('.');
	    df.setDecimalFormatSymbols(dfs);
	    df.setMinimumIntegerDigits(1);
	    df.setMinimumFractionDigits(1);
	    df.setDecimalSeparatorAlwaysShown(true);
	    System.out.println(df.format(x));
	} 

	public static double normMinMax(double x, double min, double max) {
		return (x - min) / (max - min);
	}
	
	
	public static void oldTests() 
	{
		/*
		1
		
		double[] ret = findMin(new double[][] { { 0.0, 0.0 }, { 1.0, 1.0 } });
		System.out.println(Arrays.toString(ret));
		//[0.0, 0.0]
		
		double[] ret2 = findMin(new double[][] { { 0.0, 0.0, 2.0 }, { 1.0, 1.0, 1.0 } });
		System.out.println(Arrays.toString(ret2));
		//[0.0, 0.0, 1.0]
		
		double[] ret3 = findMin(new double[][] { { -1.0, 0.0 }, { 1.0, -1.0 } });
		System.out.println(Arrays.toString(ret3));
		//[-1.0, -1.0]
		
		double[] ret4 = findMin(new double[][] { { 1.0 }, { 4.0 }, { 7.0 } });
		System.out.println(Arrays.toString(ret4));
		//[1.0]
		
		double[] ret5 = findMin(new double[][] { { 10.0, -1.0 }, { -1.0, 10.0 } });
		System.out.println(Arrays.toString(ret5));
		//[-1.0, -1.0]
		
		double[] ret6 = findMin(new double[][] { { 1.0, 1.0 }, { 1.0, 1.0 } });
		System.out.println(Arrays.toString(ret6));
		//[1.0, 1.0]
		
		
		2
		
		double[] ret = findMax(new double[][] { { 0.0, 0.0 }, { 1.0, 1.0 } });
		System.out.println(Arrays.toString(ret));
		//[1.0, 1.0]
		
		double[] ret2 = findMax(new double[][] { { 0.0, 0.0, 2.0 }, { 1.0, 1.0, 1.0 } });
		System.out.println(Arrays.toString(ret2));
		//[1.0, 1.0, 2.0]
		
		double[] ret3 = findMax(new double[][] { { -1.0, 0.0 }, { 1.0, -1.0 } });
		System.out.println(Arrays.toString(ret3));
		//[1.0, 0.0]
		
		double[] ret4 = findMax(new double[][] { { 1.0 }, { 4.0 }, { 7.0 } });
		System.out.println(Arrays.toString(ret4));
		//[7.0]
		
		double[] ret5 = findMax(new double[][] { { 10.0, -1.0 }, { -1.0, 10.0 } });
		System.out.println(Arrays.toString(ret5));
		//[10.0, 10.0]
		
		double[] ret6 = findMax(new double[][] { { 0.0, -2.0 }, { -1.0, -1.0 } });
		System.out.println(Arrays.toString(ret6));
		//[0.0, -1.0]
		

		
		3
		
		print(normMinMax(0.0, 0.0, 10.0));
		//0.0
		
		print(normMinMax(10.0, 0.0, 10.0));
		//1.0
		
		print(normMinMax(5.0, 0.0, 10.0));
		//0.5
		
		print(normMinMax(0.0, -1.0, 1.0));
		//0.5
		
		print(normMinMax(-9.0, -10.0, 0.0));
		//0.1
		
		print(normMinMax(101.0, 100.0, 102.0));
		//0.5

		*/
	}
	
	public static void main(String[] args) {
		
		

	}

}
