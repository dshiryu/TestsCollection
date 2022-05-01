import java.util.Arrays;

public class KI_HA_9 {

	public static double[][] ReLU(double[][] X) {
		
		for(int i = 0; i < X.length; i++) {
			for(int j = 0; j < X[0].length; j++) {
				if(X[i][j] < 0) X[i][j] = 0;
			}
		}
				
		return X;
		
		/*
		 for(int i = 0; i < X.length; i++) {
			if(X[i][0] < 0) X[i][0] = 0.0;
				
			for(int j = 0; j < X[0].length; j++) {
				if(X[i][j] < 0) X[i][j] = 0;
			}
		}
				
		return X; 
		 */
	}
	
	
	public static void main(String[] args) {
		double[][] ret = ReLU(new double[][] { { -1.0, -1.0 } });
		System.out.println(Arrays.deepToString(ret));
		//[[0.0, 0.0]]
		
		double[][] ret2 = ReLU(new double[][] { { -1.0, -1.0 }, { -1.0, -1.0 } });
		System.out.println(Arrays.deepToString(ret2));
		//[[0.0, 0.0], [0.0, 0.0]]
		
		double[][] ret3 = ReLU(new double[][] { { 1.0, 1.0 }, { 1.0, 2.0 } });
		System.out.println(Arrays.deepToString(ret3));
		//[[1.0, 1.0], [1.0, 2.0]]
		
		double[][] ret4 = ReLU(new double[][] { { -1.0, 1.0 }, { 1.0, -2.0 } });
		System.out.println(Arrays.deepToString(ret4));
		//[[0.0, 1.0], [1.0, 0.0]]

	}

}
