
public class KI_HA_3 {
	
	/* 1
	 * Als Vorbereitung für das Linear Softmax Modell: implementieren Sie die Matrix-Multiplikation die in diesem Modell vorkommt. 
	 * Dafür soll eine Funktion 'matMul' implementiert werdem, die ein 2D-Array 'W' und 
	 * ein 1D-Array 'x' als Parameter erwartet und das Ergebnis der Matrix-Multiplikation als 1D-Array zurückgibt. 
	 * 
	 * Sie sollten prüfen ob die Dimensionen von W und x übereinstimmen, d.h., es kann eine MM durchgeführt werden. 
	 * Falls nicht soll null zurückgegeben werden. Die Länge des Rückgabevektors soll aus den Dimensionen von W und x bestimmt werden. 
	 * Hintergrund: eine Matrixmultiplikation transformiert einen Vektor x  in einen
	 * 
	 * - Matrix-Multiplikation
	 * - parameter 2d W, 1d x
	 * - return 1d array 
	 * 
	 * - check lengths, to see if mult. is possible (not = null)
	 * - length of return based on parameters
	 * */
	/*
	public static double[] matMul(double[][] W, double[] x){
		double [] temp = new double[W.length];
		
		if(W[0].length == x.length) {
			for (int i = 0; i < W.length; i++) {
				for (int j = 0; j < x.length; j++) {
					temp[i] += W[i][j] * x[j];
				}
			}
		} else return null;
			
		
		return temp;
	}*/
	
	/* 2
	 * Eine Matrixmultiplikation kann auch auf eine Sammlung von Datenvektoren angewendet werden: 
	 * implementieren Sie die Matrix-Multiplikation im Linear Softmax-Modell, diesmal nicht für auf einen einzelnen Datenvektor x, 
	 * sondern für eine Matrix X (mit den einzelnen Datenvektoren als Zeilen). 
	 * 
	 * Dafür soll eine Funktion 'matMul' implementiert werdem, die ein 2D-Array 'W' und ein 2D-Array 'X' als Parameter erwartet 
	 * und das Ergebnis der Matrix-Multiplikation als 2D-Array zurückgibt. Sie sollten prüfen ob die Dimensionen von W und X übereinstimmen,
	 *  d.h., es kann eine MM durchgeführt werden. Falls nicht soll null zurückgegeben werden. 
	 *  Die Länge der Rückgabematrix soll aus den Dimensionen von W und X bestimmt werden. 
	 *  
	 *  Hinweis: mit Copy&Paste von der vorherigen Aufgabe kommt man recht weit...
	 *  
	 *  W = 2x3
	 *  W.length = 2 linha 
	 *  W[0].length = 3 coluna
	 *  0 0 0
	 *  0 0 0
	 *  
	 *  X = 3x2
	 *  X.length = 3 linha coluna
	 *  X[0].length = 2
	 *  0 0
	 *  0 0
	 *  0 0
	 *  
	 *  return matrix linha x, linha w 
	 * */
		
	public static double[][] matMul(double[][] W, double[][] X){
		double [][] temp = new double[X.length][W.length];
		
		if(W[0].length != X[0].length) return null;
		
		for (int row = 0; row < X.length; row++) {//row w
			for (int i = 0; i < temp[row].length; i++) {// col x
				for (int j = 0; j < W[i].length; j++) {// col w
					temp[row][i] += W[i][j] * X[row][j];
				}
				
			}
		}
		
		return temp;
	}
	
	/* 3
	 Erstellen Sie eine Funktion 'toOneHot', welche einen int-Parameter 'x' und einen weiteren int-Parameter 'length' erwartet 
	 (sie können annehmen dass gilt: 0 <= x < length), und ein Array der Länge 'length' zurückliefert. 
	 Dieses Array soll die Klasse x im one-hot Format codieren.
	 * */
	
	public static double[] toOneHot(int x, int length){
		double[] temp = new double[length];
		
		for(int i = 0; i < length; i++) {
			if(i == x) temp[i] = 1.0;
			else temp[i] = 0.0;
		}
		
		return temp;
	}
	
	/* 4
	 Implementieren Sie die Softmax-Funktion sm(x): sie nimmt ein double-Array 'x' (1D) und liefert ein double-Array der selben Länge zurück.
	 Hierbei soll die Formel aus der Vorlesung gelten: yi=exp(xi)/SIGMAjexp(xj).
	 Für die Berechnung der Exponentialfunktion benutzen Sie Math.exp. Sobald die Funktion tut wass sie soll: 
	 überzeugen Sie sich, dass die Ausgabe tatsächlich die Bedingungen für eine Wahrscheinlichkeitsverteilung erfüllt.
	 * */
	
	public static double[] sm(double[] x){
		double[] result = new double[x.length];
		double temp = 0.0;
		
		for (int j = 0; j < x.length; j++) {
				temp += Math.exp(x[j]);
		}
		for (int i = 0; i < x.length; i++) {
			result[i] = Math.exp(x[i]) / temp;
		}
		
		
		
	    return result;
	}
	
	public void oldTest() {
		/*
		// 1
		double[][] W1 = new double[][] { { 1., 1. }, { 1., 1. } };
		System.out.println(java.util.Arrays.toString(matMul(W1, new double[] { 2., 2. })));
		//[4.0, 4.0]
		
		double[][] W2 = new double[][] { { 1., 1. }, { 1., 1. } };
		System.out.println(java.util.Arrays.toString(matMul(W2, new double[] { 2., 2., 2. })));
		//null
		
		double[][] W3 = new double[][] { { -1., 0. }, { -1., 0. } };
		System.out.println(java.util.Arrays.toString(matMul(W3, new double[] { 2., 2. })));
		//[-2.0, -2.0]
		
		double[][] W4 = new double[][] { { -1., 0. }, { -1., 1. } };
		System.out.println(java.util.Arrays.toString(matMul(W4, new double[] { 2., 2. })));
		//[-2.0, 0.0]
		
		double[][] W5 = new double[][] { { -1., 0. }, { -1., 1. }, { 1., 0. } };
		System.out.println(java.util.Arrays.toString(matMul(W5, new double[] { 2., 2. })));
		//[-2.0, 0.0, 2.0]
		
		double[][] W6 = new double[][] { { -1., 0. }, { -1., 1. }, { 1., 0. }, { 1., -1. } };
		System.out.println(java.util.Arrays.toString(matMul(W6, new double[] { 2., 2. })));
		//[-2.0, 0.0, 2.0, 0.0]
		
		
		
		
		
		
		
		
		
		// 3
		System.out.println(java.util.Arrays.toString(toOneHot(1, 2)));
		//[0.0, 1.0]
		
		System.out.println(java.util.Arrays.toString(toOneHot(0, 2)));
		//[1.0, 0.0]

		System.out.println(java.util.Arrays.toString(toOneHot(3, 4)));
		//[0.0, 0.0, 0.0, 1.0]
		
		System.out.println(java.util.Arrays.toString(toOneHot(3, 5)));
		//[0.0, 0.0, 0.0, 1.0, 0.0]
		
		System.out.println(java.util.Arrays.toString(toOneHot(0, 1)));
		//[1.0]
		
		System.out.println(java.util.Arrays.toString(toOneHot(0, 3)));
		//[1.0, 0.0, 0.0]
		 
		 // 4
		double[] T1 = new double[] { 10., 10. };
		System.out.println(java.util.Arrays.toString(sm(T1)));
		//[0.5, 0.5]
		
		double[] T2 = new double[] { -10., -10. };
		System.out.println(java.util.Arrays.toString(sm(T2)));
		//[0.5, 0.5]
		
		double[] T3 = new double[] { -10., 10. };
		System.out.println(java.util.Arrays.toString(sm(T3)));
		//[2.0611536181902033E-9, 0.9999999979388463]
		
		double[] T4 = new double[] { 1., 2. };
		System.out.println(java.util.Arrays.toString(sm(T4)));
		//[0.2689414213699951, 0.7310585786300049]
		
		double[] T5 = new double[] { 1., 1., 1., 1. };
		System.out.println(java.util.Arrays.toString(sm(T5)));
		//[0.25, 0.25, 0.25, 0.25]
		
		*/
	} 

	
	public static void main(String[] args) {
		
		// 2
		double[][] W1 = new double[][] { { 1., 1. }, { 1., 1. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W1, new double[][] { { 2., 2. } })));
		//[[4.0, 4.0]]
		
		double[][] W2 = new double[][] { { 1., 1. }, { 1., 1. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W2, new double[][] { { 2., 2., 2. } })));
		//null
		
		double[][] W3 = new double[][] { { -1., 0. }, { -1., 0. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W3, new double[][] { { 2., 2. } })));
		//[[-2.0, -2.0]]
		
		double[][] W3b = new double[][] { { -1., 0. }, { -1., 0. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W3b, new double[][] { { 2., 2. }, { 1., 1. } })));
		//[[-2.0, -2.0], [-1.0, -1.0]]
		
		double[][] W4 = new double[][] { { -1., 0. }, { -1., 1. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W4, new double[][] { { 2., 2. }, { 1., 0. } })));
		//[[-2.0, 0.0], [-1.0, -1.0]]
		
		double[][] W5 = new double[][] { { -1., 0. }, { -1., 1. }, { 1., 0. } };
		System.out.println(java.util.Arrays.deepToString(matMul(W5, new double[][] { { 2., 2. } })));
		//[[-2.0, 0.0, 2.0]]
		
		
		
		
		
		 
	}

}
