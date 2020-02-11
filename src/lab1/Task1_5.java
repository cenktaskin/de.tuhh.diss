package lab1;

public class Task1_5 {

	public static void main(String[] args) {

		double w;
		double h;
		double[] bmi;
		double dum;
		int i=0;
		int j=0;
		int k=0;
		final int len;

		SimpleIO.println("Please enter array boundary:");
		len= SimpleIO.readInteger();
		bmi= new double[len];

		while(i<len) {
			do{
				SimpleIO.println("Please enter your weight in kgs:");
				w= SimpleIO.readDouble();

				SimpleIO.println("Please enter your height in m:");
				h= SimpleIO.readDouble();

			}while (h>2.72 || w<0);

			bmi[i]=w/(h*h);

			dum=Math.round(bmi[i]*100);
			bmi[i]= dum/100;
			i++;

		}
		
		int sum=0;
		for (k=0;k<len;k++){
			sum+=bmi[k];
		}
		int avg= sum/k;
		
		while(true) {
			SimpleIO.println("Which entry you want to print?");
			j=SimpleIO.readInteger();
			SimpleIO.println("BMI value is "+bmi[j-1]+" while the average is "+avg);
		}

	}
}