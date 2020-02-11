package lab1;

public class Task1_2 {
	
	public static void main(String[] args) {
		
		int w;
		double h;
		double bmi;
		double dum;
		
		do{
		SimpleIO.println("Please enter your weight in kgs:");
		w= SimpleIO.readInteger();
		
		SimpleIO.println("Please enter your height in m:");
		h= SimpleIO.readDouble();
		
		}while (h>2.72 || w<0);
		
		bmi=w/(h*h);
		
		dum=Math.round(bmi*100);
		bmi= dum/100;

		SimpleIO.println("Your BMI index is: "+ bmi);
	}
}