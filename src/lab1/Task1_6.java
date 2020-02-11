package lab1;

public class Task1_6 {

	public static void main(String[] args) {

		final int MAX_MATRIXSIZE=3;

		int i;
		int j;
		int sum=0;
		double t;
		double fr=0;
		double[][] A={{1,2,3},{4,5,6},{7,8,9}};

		for (i=0;i<MAX_MATRIXSIZE;i++) {
			for (j=0;j<MAX_MATRIXSIZE;j++) {
				t=A[i][j];
				sum+=Math.pow(t, 2);
			}
		}

		fr=Math.sqrt(sum);

		System.out.printf("Frobenius norm of matrix provided is: %.2f",fr);


	}
}
