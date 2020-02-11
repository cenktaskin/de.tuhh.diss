package lab2;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Task2_1 {

	public static void main(String[] args) {

		int width= LCD.DISPLAY_CHAR_WIDTH;

		String str = "Hello World! Merhaba Dunya!";

		int j = width;
		int i = 0;

		while(true) {
			String output = "";
			i=j-width;
			while (i<=j) {
				char c = str.charAt(i);
				output+=c;
				i+=1;
			}
			j+=1;
			if (j==str.length()){
				j=width;
				i=0;
			}
			LCD.drawString(output, 0, 0);
			Delay.msDelay(1000);

		}

	}
}

