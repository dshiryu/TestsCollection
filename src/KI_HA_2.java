
public class KI_HA_2 {

	/* 1
	 * Implementieren Sie eine Modellfunktion f(x) als Vektor-Vektor-Funktion. Sie soll einen Java-Vektor vom Typ double übergeben bekommen 
	 * (Länge 2) und die Klasse als Java-Vektor der Länge 3 im One-Hot-Format zurückgeben. Die zurückgelieferte Klasse soll sets 1 sein.



	 * */
	/*
	public static double[] f(double[] x) 
	{
		double[] y = new double[3];
		y[0] = 1.0;
		y[1] = 0.0;
		y[2] = 0.0;
		
		
		return y;  
	    
	} 

	static void printArray(double[] x) 
	{
	    if (x.length == 0) {
	        System.out.println("[]");
	        return;
	    }
	    System.out.print("[");
	    for (int i = 0; i < x.length - 1; i++) {
	        System.out.print(x[i] + ",");
	    }
	    System.out.println(x[x.length - 1] + "]");
	} 
	*/

	/* 2
	 * Implementieren Sie eine Modellfunktion f(x) als Vektor-Vektor-Funktion. Sie soll einen Java-Vektor vom Typ double übergeben bekommen 
	 * (Länge 2) und die Klasse als Java-Vektor der Länge 3 im One-Hot-Format zurückgeben. Die zurückgelieferte Klasse soll 1 sein falls die
	 *  erste Komponente von x < 0 ist, sonst 2.

		
	 * */
	
	/*
	public static double[] f(double[] x) 
	{
		double[] y = new double[] {0.0, 0.0, 0.0};
				
		if(x[0] < 0) y[0] = 1.0;
		else y[1] = 1.0;
		
		
		return y; 
	}

	static void printArray(double[] x) 
	{
	    if (x.length == 0) {
	        System.out.println("[]");
	        return;
	    }
	    System.out.print("[");
	    for (int i = 0; i < x.length - 1; i++) {
	        System.out.print(x[i] + ",");
	    }
	    System.out.println(x[x.length - 1] + "]");
	} 
	*/
	
	/* 3
	 * Implementieren Sie eine Matrix-Matrix-Modellfunktion. Dafür soll die gegebene Vektor-Vektor-Modellfunktion fVecVec(x) 
	 * auf die Zeilen der übergebenen Matrix X angewendet werden und das Ergebnis zurückgelifert werden. Die Funktion fVecVec(x) 
	 * liefert stets den Vektor {1,0} zurück. Sie können annehmen dass die Matrix X mindestens eine Zeile hat.

	* */
	
	/*
	public static double[] fVecVec(double[] x) 
	{
	    double[] ret = new double[] { 1., 0. };
	    return ret;
	} 

	static double[][] f(double[][] X) 
	{
		double[][] y = new double[X.length][X[0].length + 1];
		
		for (int i = 0; i < y.length; i++) { // column
			
			for (int j = 0; j < y[0].length; j++) { // row
				
				if (j == 0) y[i][j] = 1.0;
				
			}
		}
		
		return y; 

	}

	static void print2DArray(double[][] X) 
	{
	    System.out.print("[");
	    for (int i = 0; i < X.length; i++) {
	        double[] x = X[i];
	        if (x.length == 0) {
	            System.out.print("[]");
	        } else {
	            System.out.print("[");
	            for (int j = 0; j < x.length - 1; j++) {
	                System.out.print(x[j] + ",");
	            }
	            System.out.print(x[x.length - 1] + "]");
	        }
	    }
	    System.out.println("]");
	} 
	*/

	/* 4
	 * Implementieren Sie die Klassifikationsgenauigkeit-Zielfunktion in einer Methode 'classAccuracy', welche als Parameter ein 
	  2D-Array Y und ein 2D-Array T erhält, welche die Modellfunktionsoutputs sowie die Zielwerte eines Problems repräsentieren.
	   
	 * Hier wird ein Klassifikationsproblem behandelt, d.h. die Zeilenvektoren des Zielwert-Arrays T repräsentieren diskrete Klassen: 
	  falls Klasse k gemeint ist, steht an der Stelle k im Zeilenvektor eine 1 und 0 überall sonst.
	  
	 * Klar ist: ein Zielwert-Vektor der Länge K kann auf diese Weise genau K verschiedene Klassen repräsentieren. 
	  
	 * Die Zahl der Zeilen darf als > 0 angenommen werden, die Zahl der Spalten in Y und T 
	  ist identisch und kann aus der ersten Zeile bestimmt werden.
	  
	 * Die Modelloutputs Y sind garantiert im [0,1]-Intervall und repräsentieren die Wahrscheinlichkeiten, 
	  die das Modell für eine bestimmte Klasse berechnet hat.
	   
	 * Eine Modelloutput wird als korrekt angesehen, wenn die höchste Wahrscheinlichkeit an der Stelle steht, wo der zugehörige Zielwert 
	  eine 1 hat. classAccuracy soll die Anzahl der korrekten Modelloutputs liefern, dividiert durch die Gesamtzahl der Modelloutputs.
	   
	 * Also die Wahrscheinlichkeit dass ein einzelner Modelloutput die richtige Klasse liefert. Zum Nachdenken: Was sind obere und untere 
	  Schranken für diese Zielfunktion?

	 * */
	
	// Y = output, T = target value (defines the class)
	// compare if the  1.0 from T is in the same position as the biggest value from Y
	// if yes, add 1 to correctClasses 
	// divide correctClasses with lengthLine to get result
	/*
	public static double classAccuracy(double[][] Y, double[][] T) {
		double lengthRow = Y[0].length;
		double lengthCol = Y.length;
		double correctClasses = 0.0;
		double result = 0.0;
		int positionY = 0;
		int positionT = 0;
		
		
			
		for (int i = 0; i < Y.length; i++) { // column
			double tempY = 0.0;
			double tempT = 0.0;
			
			for (int j = 0; j < Y[0].length; j++) { // row
				
				if (Y[i][j] > tempY) {
					tempY = Y[i][j];
					positionY = j; 
				}
				if (T[i][j] > tempT) {
					tempT = T[i][j];
					positionT = j; 
				}
			}
			if (positionY == positionT) correctClasses++;
		}
		
		result = correctClasses / lengthCol;
		
		return result;
	}
*/
	
	/* 5
	 * Implementieren Sie die Klassifikationsfehler-Zielfunktion in einer Methode 'classError', welche als Parameter ein 2D-Array Y 
	 * und ein 2D-Array T erhält, welche die Modellfunktionsoutputs sowie die Zielwerte eines Problems repräsentieren. 
	  
	 * Diese tut genau das was die Methode classError aus der vorherigen Aufgabe auch tut, mit dem folgenden Unterschied: 
	 * sie berechnet die Zahl der inkorrekten Modelloutputs (anstelle der korrekten), natürlich auch dividiert durch die Gesamtzahl der Beispiele.
	 
	 *  Wieder: was ist der Wertebereich dieser Zielfunktion?
				
		T1
		{ 1.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0 }
		{ 0.5, 0.4, 0.1 }, { 0.4, 0.0, 0.6 }, { 0.0, 0.9, 0.1 }
		> 0.0
		
		T3
		{ 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0 } 
		{ 0.4, 0.5, 0.1, 0.0 }, { 0.6, 0.0, 0.4, 0.0 }, { 0.0, 0.1, 0.9, 0.0 }
		> 1.0
		
		T4
		{ 1.0, 0.0 }, { 0.0, 1.0 }, { 0.0, 1.0 }, { 1.0, 0.0 }
		{ 0.6, 0.4 }, { 0.4, 0.6 }, { 0.8, 0.2 }, { 0.3, 0.7 }
		> 0.5


		number of wrong divided by total
	 * */
	public static double classError(double[][] Y, double[][] T) 
	{
		double lengthRow = Y[0].length;
		double lengthCol = Y.length;
		double correctClasses = 0.0;
		double result = 0.0;
		int positionY = 0;
		int positionT = 0;
		
		
			
		for (int i = 0; i < Y.length; i++) { // column
			double tempY = 0.0;
			double tempT = 0.0;
			
			for (int j = 0; j < Y[0].length; j++) { // row
				
				if (Y[i][j] > tempY) {
					tempY = Y[i][j];
					positionY = j; 
				}
				if (T[i][j] > tempT) {
					tempT = T[i][j];
					positionT = j; 
				}
			}
			if (positionY == positionT) correctClasses++;
		}
		
		result = (lengthCol - correctClasses) / lengthCol;
		
		return result;

	}

	/* 6
	 *  Implementieren Sie die Kreuzentropie-Zielfunktion ('cross entropy loss') in einer Methode 'crossEntropy', welche als Parameter ein
	 *  2D-Array Y und ein 2D-Array T erhält, welche die Modellfunktionsoutputs sowie die Zielwerte eines Problems repräsentieren.
	   
	 *  Hier wird ein Klassifikationsproblem behandelt, d.h. die Zeilenvektoren des Zielwert-Arrays T repräsentieren diskrete Klassen: 
	 *  falls Klasse k gemeint ist, steht an der Stelle k im Zeilenvektor eine 1 und 0 überall sonst.
	 
	 *  Klar ist: ein Zielwert-Vektor der Länge K kann auf diese Weise genau K verschiedene Klassen repräsentieren.
	   
	 *  Die Zahl der Zeilen darf als > 0 angenommen werden, 
	 *  die Zahl der Spalten in Y und T ist identisch und kann aus der ersten Zeile bestimmt werden.
	   
	 *  Die Modelloutputs Y sind garantiert im [0,1]-Intervall und repräsentieren die Wahrscheinlichkeiten, 
	 *  die das Modell für eine bestimmte Klasse berechnet hat.
	  
	 *  Die Kreuzentropie berechnet sich 
	 *  anhand der Formel (LATEX) ( \\mathcal{L}_{CE} = -\frac{1}{N}\sum_i\sum_j \log (y_{ij})t_{ij} ) .
	   
	 *  Die Logarithmusfunktion kann durch Math.log bestimmt werden, keine Imports nötig.
	   
	 *  Zum Nachdenken: Was sind obere und untere Schranken für diese Zielfunktion? 
	 *  Wann werden sie erreicht?

		Zum Beispiel:
				
		{ 1.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0 } 
		{ 0.5, 0.4, 0.1 }, { 0.4, 0.1, 0.5 }, { 0.1, 0.8, 0.1 } 
		> 0.5364793041447001
		
		{ 1.0, 0.00, 0.00, 0.00 }, { 0.00, 0.00, 1.0, 0.00 }, { 0.00, 1.0, 0.00, 0.00 }
		{ 1.0, 0.01, 0.01, 0.01 }, { 0.01, 0.01, 1.0, 0.01 }, { 0.01, 1.0, 0.01, 0.01 }
		> -0.0

	 * */
	public static double crossEntropy(double[][] Y, double[][] T) 
	{
		double lengthCol = Y.length;
		double result = 0.0;
		
		double tempT = 0.0;
		for (int i = 0; i < Y.length; i++) { // column
			double tempY = 0.0;
			
			for (int j = 0; j < Y[0].length; j++) { // row
				tempY += Math.log(Y[i][j]) * T[i][j];
			}
			tempT += tempY;
		}
		
		result = (-tempT / lengthCol)  ;
		
		return result;

	}

	/* 7
	 * Implementieren Sie die MSE-Zielfunktion in einer Methode 'mse', welche als Parameter ein 2D-Array Y und ein 2D-Array T erhält,
	 *  welche die Modellfunktionsoutputs sowie die Zielwerte eines Problems repräsentieren. Die Zahl der Zeilen darf als > 0 angenommen
	 *   werden, die Zahl der Spalten in Y und T ist identisch und kann aus der ersten Zeile bestimmt werden.


	 */
	public static double mse(double[][] Y, double[][] T) 
	{
		double lengthCol = Y.length;
		double result = 0.0;
		
		double tempT = 0.0;
		for (int i = 0; i < Y.length; i++) { // column
			double tempY = 0.0;
			
			for (int j = 0; j < Y[0].length; j++) { // row
				tempY += Math.pow((Y[i][j] - T[i][j]), 2);
			}
			tempT += tempY;
		}
		
		result = (1 / lengthCol) * tempT ;
		
		return result;
	}

	/* 8
	 * Implementieren Sie die Root Mean Squared Error (RMSE)-Zielfunktion in einer Methode 'rmse', welche als Parameter ein 2D-Array Y 
	 * und ein 2D-Array T erhält, welche die Modellfunktionsoutputs sowie die Zielwerte eines Problems repräsentieren. Die Zahl der Zeilen
	 *  darf als > 0 angenommen werden, die Zahl der Spalten in Y und T ist identisch und kann aus der ersten Zeile bestimmt werden. 
	 *  Der Unterschied zu MSE ist, dass der Betrag der Differenz zwischen Modellausgabe und Zielwert nicht quadriert wird uns somit die 
	 *  Quadratwurzel stehenbleibt. Die Quadratwurzel berechnen Sie mit der Funktion Math.sqrt (kein Import nötig)

		Zum Beispiel:
		
		Test	Resultat

	 * */
	public static double rmse(double[][] Y, double[][] T) 
	{
		double lengthCol = Y.length;
		double result = 0.0;
		
		double tempT = 0.0;
		for (int i = 0; i < Y.length; i++) { // column
			double tempY = 0.0;
			
			for (int j = 0; j < Y[0].length; j++) { // row
				tempY += Math.pow((Y[i][j] - T[i][j]), 2);
			}
			tempT += Math.sqrt(tempY);
		}
		
		result = (tempT / lengthCol)  ;
		
		return result;

	}

	/*
	public static void oldTests () {
		--> 1
		printArray(f(new double[] { 0.0, 1.0 })); //[1.0,0.0,0.0]
		printArray(f(new double[] { 0.0, 0.0 })); //[1.0,0.0,0.0]
		printArray(f(new double[] { 2.0, 0.0 })); //[1.0,0.0,0.0]
		printArray(f(new double[] { 2.0, 2.0 })); //[1.0,0.0,0.0]
		

		--> 2     
		printArray(f(new double[] { -1.0, 1.0 })); //	[1.0,0.0,0.0]
		printArray(f(new double[] { -10.0, 0.0 })); //	[1.0,0.0,0.0]
		printArray(f(new double[] { 2.0, 0.0 })); // 	[0.0,1.0,0.0]
		printArray(f(new double[] { 10.0, 20.0 })); // 	[0.0,1.0,0.0]
		
		
		--> 3   
		print2DArray(f(new double[][] { { -1.0 } })); // [[1.0,0.0]]
		print2DArray(f(new double[][] { { -10.0 }, { 0.0 } })); //	[[1.0,0.0][1.0,0.0]]
		print2DArray(f(new double[][] { { -1.0 }, { 1.0 }, { 1.0 } })); //	[[1.0,0.0][1.0,0.0][1.0,0.0]]
		
		
		--> 4   
		double[][] T1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
		System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0., 0.6 }, { 0., 0.9, 0.1 } }, T1)); //	1.0
		
		double[][] T2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1, 0. }, { 0.4, 0., 0.6, 0. }, { 0., 0.9, 0.1, 0. } }, T2)); // 1.0
		
		double[][] T3 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(classAccuracy(new double[][] { { 0.4, 0.5, 0.1, 0. }, { 0.6, 0., 0.4, 0. }, { 0., 0.1, 0.9, 0. } }, T3)); // 0.0
		
		double[][] T4 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(classAccuracy(new double[][] { { 0.6, 0.4 }, { 0.4, 0.6 }, { 0.8, 0.2 }, { 0.3, 0.7 } }, T4)); // 0.5
		
		double[][] T5 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(classAccuracy(new double[][] { { 0.4, 0.6 }, { 0.6, 0.4 }, { 0.1, 0.9 }, { 0.7, 0.3 } }, T5)); // 0.5
		
		--> 5  
		double[][] T1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
		System.out.println(classError(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0., 0.6 }, { 0., 0.9, 0.1 } }, T1));	// 0.0
		
		double[][] T2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(classError(new double[][] { { 0.5, 0.4, 0.1, 0. }, { 0.4, 0., 0.6, 0. }, { 0., 0.9, 0.1, 0. } }, T2));	// 0.0
		
		double[][] T3 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(classError(new double[][] { { 0.4, 0.5, 0.1, 0. }, { 0.6, 0., 0.4, 0. }, { 0., 0.1, 0.9, 0. } }, T3));	// 1.0
		
		double[][] T4 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(classError(new double[][] { { 0.6, 0.4 }, { 0.4, 0.6 }, { 0.8, 0.2 }, { 0.3, 0.7 } }, T4));	// 0.5
		
		double[][] T5 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(classError(new double[][] { { 0.4, 0.6 }, { 0.6, 0.4 }, { 0.1, 0.9 }, { 0.7, 0.3 } }, T5));	// 0.5		
		
		
		
		
		--> 7
		double[][] T1 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
		System.out.println(mse(new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T1));
		// 0.0
		double[][] T2 = new double[][] { { 1., 1., 0.5, 0. }, { 1., 1., 1., 1. }, { 1., 0., 0., 0.5 } };
		System.out.println(mse(new double[][] { { 1., 1., 0.5, 0. }, { 1., 1., 1., 1. }, { 1., 0., 0., 0.5 } }, T2));
		// 0.0
		double[][] T5 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
		System.out.println(mse(new double[][] { { 7., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T5)); // 12.0	
		 
			
		*/
	
	
	public static void main(String[] args) {
		/*
		//--> 6
		double[][] T1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
		System.out.println(crossEntropy(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0.1, 0.5 }, { 0.1, 0.8, 0.1 } }, T1));
		// 0.5364793041447001 expected
		// 0.5364793041447    received
		
		double[][] T2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(crossEntropy(new double[][] { { 1., 0.01, 0.01, 0.01 }, { 0.01, 0.01, 1., 0.01 }, { 0.01, 1., 0.01, 0.01 } }, T2));
		// -0.0
		
		double[][] T3 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
		System.out.println(crossEntropy(new double[][] { { 0.4, 0.5, 0.05, 0.05 }, { 0.1, 0.3, 0.4, 0.2 }, { 0.05, 0.45, 0.4, 0.1 } }, T3));
		// 0.8770297199886938
		
		double[][] T4 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(crossEntropy(new double[][] { { 0.1, 0.9 }, { 0.9, 0.1 }, { 0.1, 0.9 }, { 0.1, 0.9 } }, T4));
		// 1.7532789486599905
		
		double[][] T5 = new double[][] { { 1., 0. }, { 0., 1. }, { 0., 1. }, { 1., 0. } };
		System.out.println(crossEntropy(new double[][] { { 0.01, 1.0 }, { 1., 0.01 }, { 1., 0.01 }, { 1.0, 0.01 } }, T5));
		// 3.4538776394910684
		}
	*/
		// -- > 8
		double[][] T1 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
		System.out.println(rmse(new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T1));
		//0.0
		double[][] T2 = new double[][] { { 1., 0.5, 0. }, { 2., 0., 0. }, { 0., 0., 0.5 } };
		System.out.println(rmse(new double[][] { { 1., 0.5, 0. }, { 0., 0., 0. }, { 0., 0., 0.5 } }, T2));
		//0.6666666666666666
		double[][] T3 = new double[][] { { 1., 0.5, 0., 0. }, { 1., 1., 1., 1. }, { 0., 0., 0.5, 2. } };
		System.out.println(rmse(new double[][] { { 1., 0.5, 0., 0. }, { 1., 1., 1., 1. }, { 0., 0., 0.5, 2. } }, T3));
		//0.0
		double[][] T4 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
		System.out.println(rmse(new double[][] { { 2., 1.5, 1. }, { 2., 2., 2. }, { 1., 1., 1.5 } }, T4));
		//1.7320508075688774 expected
		//1.7320508075688772 received
		
		double[][] T5 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
		System.out.println(rmse(new double[][] { { 7., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T5));
		//2.0
		
		
	}

}
