package study;

public class Deneme {
	
	public static String dual(int number, int width) {
		String result="";
		int j=0;
		while (number>0) {
//			SimpleIO.println("Step: "+j);
			result=(number%2)+result;
//			SimpleIO.println("Result: "+result);
			number/=2;
//			SimpleIO.println("Number:"+number);
			j++;
			if (j>width) {
				return "Overflow";
			}
		}
		while (j<width) {
			result='0'+result;
			j++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<20;i++) {
			SimpleIO.println(dual(i,5)+" : "+i);
		}
	}

}
