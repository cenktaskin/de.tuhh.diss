package lab4;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class UserInterface {

	public static int navigation() {
		// Start Here Test
		
		/*final int ID_ENTER = 2;
		final int ID_UP = 1;
		final int ID_DOWN = 4;
		final int ID_RIGHT = 8;
		final int ID_LEFT = 16;
		final int ID_ESCAPE = 32;*/
		
		int color = 0;
		
		int i = 1;
		
		while (true) {
			
			LCD.drawString(" Select Wall Color:    ", 0 , 1 );
			LCD.drawString(" Blue  ", 0, 2 );
			LCD.drawString(" Red   " , 0, 3 );
			LCD.drawString(" Green    ", 0, 4 );
			
			LCD.drawString(">", 0, i);
			
			if (Button.DOWN.isDown()) {
				
				if(i <= 3 && i >= 1) {
					LCD.drawString(" ", 0, i);
					i++;
				}
			}
			
			if (Button.UP.isDown()) {
				
				if(i <= 4 && i >= 2) {
					LCD.drawString(" ", 0, i);
					i--;
				}
			}
			
			// Checks position of cursor and enable changing parameters
			
			if (i == 2 && Button.ENTER.isDown()) {
				
				color = 1;
				
			} else if (i == 3 && Button.ENTER.isDown() ) {
				
				color = 2;
			}
			
			if (i == 4 && Button.RIGHT.isDown()) {
				
				color = 3;
				
			}
			
			if(color != 0) {
				
				return color;
			}
				

			LCD.asyncRefresh();
			LCD.asyncRefreshWait();
			Delay.msDelay(100);
		}
		
	}
	
}
	

