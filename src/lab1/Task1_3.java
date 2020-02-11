package lab1;

public class Task1_3 {
	
	public static void main(String[] args) {
		
		int w;
		double h;
		double bmi;
		double dum;
		
		final double BMI_UPPER=25.0;
		final double BMI_LOWER=18.5;
		
		do{
		SimpleIO.println("Please enter your weight in kgs:");
		w= SimpleIO.readInteger();
		
		SimpleIO.println("Please enter your height in m:");
		h= SimpleIO.readDouble();
		
		}while (h>2.72 || w<0);
		
		bmi=w/(h*h);
		
		dum=Math.round(bmi*100);
		bmi= dum/100;

		//SimpleIO.println("Your BMI index is: "+ bmi);
		if (bmi>BMI_UPPER) {
			SimpleIO.println("You are overweight.");
		} else if(bmi<BMI_LOWER) {
			SimpleIO.println("You are underweight.");
		} else{
			SimpleIO.println("You are normal weight.");
		}
		
	}
}