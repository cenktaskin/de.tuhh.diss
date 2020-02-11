package lab1;

public class Task1_7 {
	
	public static double obtainFrobeniusNorm(double[][] matrixA) {
		final int MAX_MATRIXSIZE=3;
		
		int i;
		int j;
		int sum=0;
		double t;
		
		
		for (i=0;i<MAX_MATRIXSIZE;i++) {
			for (j=0;j<MAX_MATRIXSIZE;j++) {
				t=matrixA[i][j];
				sum+=Math.pow(t, 2);
			}
		}
		
		double fr=Math.sqrt(sum);
		
		return fr;
	}

	public static void main(String[] args) {
		
		
		double fr=0;

		double[][] A={{1,2,3},{4,5,6},{7,8,9}};
		
		fr=obtainFrobeniusNorm(A);
		
		System.out.printf("Frobenius norm of matrix provided is: %.2f",fr);
	
	}
}
