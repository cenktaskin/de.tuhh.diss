package lab1;

public class Task1_10 {

	public static double f(double x) {
		return Math.pow(x, 3)-2*x+2;
	}
	public static double df(double x) {
		return 3*Math.pow(x, 2)-2;
	}
	public static void main(String[] args) {

		double x0=10;
		double x1;
		int j=0;
		double dif=0;

		while (f(x0)!=0) {
			x1=x0-f(x0)/df(x0);
			dif=Math.abs(x1-x0);
			if (dif<0.000001) {
				break;
			}
			x0=x1;
			j++;
			System.out.println("Iteration: "+j+" current value: "+x0);
			
			if (j>10000){
				x0*=0.5;
				j=0;
			}
		}
		System.out.printf("The root is: %.5f",x0);

	}

}
