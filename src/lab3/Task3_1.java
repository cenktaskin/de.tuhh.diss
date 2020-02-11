package lab3;

/*import lejos.hardware.Button;
import lejos.hardware.Sound;*/
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class Task3_1 {
	public static String colorDetect (float[] array) {

		String detectedcolor="";

		if (array[0] == Color.BLACK) {
			detectedcolor= "black";
		}else if(array[0] == Color.BLUE) {
			detectedcolor=" blue";
		}else if(array[0] == Color.BROWN) {
			detectedcolor=" brown";
		}else if(array[0] == Color.CYAN) {
			detectedcolor=" cyan";
		}else if(array[0] == Color.DARK_GRAY) {
			detectedcolor=" dark gray";
		}else if(array[0] == Color.GRAY) {
			detectedcolor=" gray";
		}else if(array[0] == Color.GREEN) {
			detectedcolor=" green";
		}else if(array[0] == Color.LIGHT_GRAY) {
			detectedcolor=" light gray";
		}else if(array[0] == Color.MAGENTA) {
			detectedcolor=" magenta";
		}else if(array[0] == Color.NONE) {
			detectedcolor=" none";
		}else if(array[0] == Color.ORANGE) {
			detectedcolor=" orange";
		}else if(array[0] == Color.PINK) {
			detectedcolor=" pink";
		}else if(array[0] == Color.RED) {
			detectedcolor=" red";
		}else if(array[0] == Color.WHITE) {
			detectedcolor=" white";
		}else if(array[0] == Color.YELLOW) {
			detectedcolor=" yellow";
		}

		return detectedcolor;
	}
	public static void main(String[] args) {

		float[] array;

		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);

		SensorMode color = colorSensor.getColorIDMode();

		array = new float[color.sampleSize()];

		try {
			while (true) {

				color.fetchSample(array, 0);

				LCD.drawString("That is "+colorDetect(array), 0, 1);

				Delay.msDelay(100);
				LCD.clear();}

		}finally {
			colorSensor.close();
		}

	}

}