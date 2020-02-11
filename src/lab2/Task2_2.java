package lab2;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Task2_2 {

	public static void main(String[] args) {
		
		int volume = 50;
		int frequency = 400;
		int duration = 500;

		int i = 1;
		
		while (true) {
			
			LCD.drawString(" Volume     " + volume, 0 , 1 );
			LCD.drawString(" Frequency  " + frequency, 0, 2 );
			LCD.drawString(" Duration   " + duration, 0, 3 );
			LCD.drawString(" Play    ", 0, 4 );
			
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
			
			if (i == 1 && Button.RIGHT.isDown() && volume <= 90) {
				
				volume += 10;
				
			} else if (i == 1 && Button.LEFT.isDown() && volume > 10 ) {
				
				volume -= 10;
			}
			
			if (i == 2 && Button.RIGHT.isDown() && frequency <= 990) {
				
				frequency += 10;
				
			} else if (i == 2 && Button.LEFT.isDown() && frequency > 10 ) {
				
				frequency -= 10;
			}
			
			if (i == 3 && Button.RIGHT.isDown()) {
				
				duration += 10;
				
			} else if (i == 3 && Button.LEFT.isDown() && duration > 10 ) {
				
				duration -= 10;
			}
			
			if (i == 4 && Button.ENTER.isDown()) {
				
				Sound.setVolume(volume);
				Sound.playTone(frequency, duration);
		
			}
			LCD.asyncRefresh();
			LCD.asyncRefreshWait();
			Delay.msDelay(100);
		}
	}

}
