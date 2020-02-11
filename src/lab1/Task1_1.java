package lab1;

public class Task1_1 {
	
	public static void main(String[] args) {
		
		int w;
		double h;
		double bmi;
		double dum;
		
		SimpleIO.println("Please enter your weight in kgs:");
		w= SimpleIO.readInteger();
		
		SimpleIO.println("Please enter your height in m:");
		h= SimpleIO.readDouble();
		
		bmi=w/(h*h);
		
		dum=Math.round(bmi*100);
		bmi= dum/100;

		SimpleIO.println("Your BMI index is: "+ bmi);
	}
}
