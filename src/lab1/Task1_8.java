package lab1;

public class Task1_8 {

	public static int hrRestDecider(int age) {
		int hrRest=0;

		if (age>18 && age<35) {
			hrRest=71;
		}else if(age>35 && age<55) {
			hrRest=73;
		}else if(age>55) {
			hrRest=76;
		}
		return hrRest;
	}
	
	public static double hrMaxCalculator(int age) {
		double hrMax=0;
		
		hrMax=206.9-(0.69*age);
	
		return hrMax;
	}

	public static double vo2MaxCalculator(double hrMax, int hrRest) {
		double vo2Max=0;
		
		vo2Max=15*hrMax/hrRest;
	
		return vo2Max;
	}

	public static void main(String[] args) {
		int age=0;
		double hrm=0;
		int hrr=0;
		double vo2=0;
		
		System.out.println("Enter your age:");
		age=SimpleIO.readInteger();
		hrm=hrMaxCalculator(age);
		hrr=hrRestDecider(age);
		vo2=vo2MaxCalculator(hrm,hrr);
		System.out.printf("Your VO2max value is: %.2f",vo2);
	}


}
