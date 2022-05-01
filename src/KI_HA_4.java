
public class KI_HA_4 {

	/* 1
	 Implementieren Sie eine Funktion cosinusSteigung, 
	 welche die double-Parameter x und eps akzeptiert und 
	 als Ergebnis die Steigung a (x, ϵ) an der Funktion f (x) = x^2  
	 an der Stelle x, mit Schrittweite eps, zurückliefert!

	steigung = ((x + eps)^2 - x^2) / eps
	 * */
	public static double cosinusSteigung(double x, double eps) {
		return (Math.pow((x + eps),2) - Math.pow(x, 2)) / eps;
	}
	
	

	
	public static void main(String[] args) {
		System.out.printf("%.04f\n", cosinusSteigung(0, 1));
		//1.0000
		
		System.out.printf("%.04f\n", cosinusSteigung(0, 0.5));
		//0.5000
		
		System.out.printf("%.04f\n", cosinusSteigung(0, 0.1));
		//0.1000
		
		System.out.printf("%.04f\n", cosinusSteigung(0, 0.05));
		//0.0500
		
		System.out.printf("%.04f\n", cosinusSteigung(0, 0.01));
		//0.0100

	}

}
