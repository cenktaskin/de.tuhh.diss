package lab5;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class UserInterface {

	public String navigation() {
		
		String color = "none";
		
		int i = 2;
		
		while (true) {
			
			LCD.drawString(" Select Wall Color:", 0 , 1 );
			LCD.drawString(" Blue  ", 0, 2 );
			LCD.drawString(" Red   " , 0, 3 );
			LCD.drawString(" Green    ", 0, 4 );
			LCD.drawString(" Yellow    ", 0, 5 );
			
			LCD.drawString(">", 0, i);
			
			int ID = Button.waitForAnyPress();
			
			if (ID == Button.ID_DOWN) {
				
				if(i < 5 && i >= 2) {
					LCD.drawString(" ", 0, i);
					i++;
				}
			}
			
			if (ID == Button.ID_UP) {
				
				if(i <= 5 && i > 2) {
					LCD.drawString(" ", 0, i);
					i--;
				}
			}
			
			// Checks position of cursor and enable changing parameters
			
			if (i == 2 && Button.ENTER.isDown()) {
				
				color = "blue";
				
			} else if (i == 3 && Button.ENTER.isDown() ) {
				
				color = "red";
			}
			
			if (i == 4 && Button.ENTER.isDown()) {
				
				color = "green";
				
			}
			if (i == 5 && Button.ENTER.isDown()) {
				
				color = "yellow";
				
			}
			
			if(color != "none") {
				
				return color;
			}
				

			LCD.asyncRefresh();
			LCD.asyncRefreshWait();
			Delay.msDelay(100);
		}
		
	}
	
	public void maestro() {
		int C = 261;
		int D = 294;
		int DS = 312;
		int E = 330;
		int F = 349;
		int G = 392;
		int GS = 415;
		int A = 440;
		int AS = 466;
		int dur = 1000;
		int A3 = 220;
		int C5 = 2*C;


		Sound.playTone(F, dur, 50);
		Sound.playTone(E, dur/4, 50);
		Sound.playTone(F, dur/4, 50);
		Sound.playTone(E, dur/2, 50);
		Sound.playTone(C, dur, 50);
		Sound.playTone(A3, dur/2, 50);
		Sound.playTone(D, dur, 50);

		Sound.playTone(D, dur, 0);

		Sound.playTone(C, dur, 50);
		Sound.playTone(F, dur, 50);
		Sound.playTone(G, dur/4, 50);
		Sound.playTone(A, dur/4, 50);
		Sound.playTone(C5, dur/2, 50);
		Sound.playTone(A, dur/2, 50);
		Sound.playTone(D, dur/4, 50);
		Sound.playTone(E, dur/4, 50);
		Sound.playTone(D, dur, 50);

		Sound.playTone(D, dur, 0);

		Sound.playTone(D, dur, 50);
		Sound.playTone(C, dur/4, 50);
		Sound.playTone(D, dur/4, 50);
		Sound.playTone(C, dur/2, 50);
		Sound.playTone(AS/2, dur/2, 50);

		Sound.playTone(D, dur/2, 0);

		Sound.playTone(AS, dur, 50);
		Sound.playTone(A, dur/2, 50);
		Sound.playTone(AS, dur/4, 50);
		Sound.playTone(A, dur/2, 50);
		Sound.playTone(G, dur, 50);

		Sound.playTone(A, dur/2, 50);
		Sound.playTone(C, dur/2, 50);
		Sound.playTone(AS, dur/4, 50);
		Sound.playTone(A, dur/2, 50);
		Sound.playTone(F, dur/2, 50);

		Sound.playTone(D, dur/2, 0);

		Sound.playTone(AS, dur/4, 50);
		Sound.playTone(GS, dur/2, 50);
		Sound.playTone(F, dur/2, 50);
		Sound.playTone(AS, dur/4, 50);
		Sound.playTone(GS, dur/2, 50);
		Sound.playTone(F, dur, 50);

		Sound.playTone(D, dur/2, 0);

		Sound.playTone(DS, dur/4, 50);
		Sound.playTone(C, dur/2, 50);
		Sound.playTone(F, 2*dur, 50);
	}

	public void show(String message,int int1,int int2) {
		LCD.clear();
		LCD.drawString(message, int1, int2);
	}
}
	