package lab4;


public class Task4_1 {

	public static void main(String[] args) {
		
		
		int desireddegree=90;
		
		ProportionalController obj= new ProportionalController();
		
		obj.setKp(10);
		obj.setKi(0.05);
		obj.turn(desireddegree);
		

	}
}


