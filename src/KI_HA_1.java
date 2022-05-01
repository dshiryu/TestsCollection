import java.util.Arrays;

public class KI_HA_1 {
//1
	public double sumOfSquares(double[] x){
	    double total = 0;
	    for(int i = 0; i < x.length; i++){
	        double temp = x[i];
	        x[i] = temp * temp;
	        total += x[i];
	    }
		return total;
	}
	//2
	public double sumOfColOne(double[][] x){
	    double total = 0;
	    for(int i = 0; i < x.length; i++){
	        total += x[i][1];
	        
	        }
	    
	    return total;
	}
	//3
	public static double sumOfRow2(double[][] x){
	    double total = 0;
	    int asd = x.length;
	    if(x.length == 0) return total;
	    if(x.length > 1){
	        for(int i = 0; i < x[1].length; i++){
	            total += x[1][i];
	        }
	    }
	    return total;
	}
//4
	public double sumOfMatrix(double[][] x){
	    double total = 0;
	    for(int i = 0; i < x.length; i++){
	        for(int j = 0; j < x[i].length; j++){
	            total += x[i][j];
	        }
	    }
	    return total;
	}
	//5
	/*public static double[][] modelExample(double[][] x){
	    int sizeArray = x.length;
	    double[][] result = new double[sizeArray][1];
	    
	    for(int i = 0; i < x.length; i++){
	        result[i][0] = x[i][0];
	    	
	    }
	    return result;
	}*/
	
	//6
	/*public static double[][] modelExample(double[][] x){
	    int sizeArray = x.length;
	    double[][] result = new double[sizeArray][1];
		    
	    for(int i = 0; i < x.length; i++){
	    	double temp = 0;
	        for(int j = 0; j < x[i].length; j++) {
	        	temp += x[i][j];
	        }
	    	
	    	
	    	result[i][0] = temp;
		    	
	    }
	    return result;
	}*/

	//7
	public static double[][] modelExample(double[][] x){
	    int sizeArray = x[0].length;
	    double[][] result = new double[1][sizeArray];
		    
	    for(int i = 0; i < x[0].length; i++){
	    	double temp = 0;
	        for(int j = 0; j < x.length; j++) {
	        	temp += x[j][i];
	        }
	    	
	    	
	    	result[0][i] = temp;
		    	
	    }
	    return result;
    }
	
	//8
	public static double[][] linearClassifier(double[][] x, double[] w){
	    int sizeArray = x.length;
	    double[][] result = new double[sizeArray][1];
			    
	    for(int i = 0; i < x.length; i++){
	    	double temp = 0;
	        for(int j = 0; j < x[i].length; j++) {
	        	temp += x[i][j] * w[j];
	        }
	    	
	    	
	    	result[i][0] = temp;
		    	
	    }
	    return result;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 1. }, { 2., 2. }, { 3., 3. } }, new double[] { 1.0, 0.0 })));

	}

}
