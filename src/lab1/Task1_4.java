package lab1;

public class Task1_4 {

	public static void main(String[] args) {

		double w;
		double h;
		double[] bmi;
		double dum;
		int i=0;
		int j=0;

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
		while(true) {
			SimpleIO.println("Which entry you want to print?");
			j=SimpleIO.readInteger();
			SimpleIO.println("Entry is: "+bmi[j-1]);
		}

	}
}