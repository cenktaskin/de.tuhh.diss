package lab5;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;

public class Sensors {

	private EV3UltrasonicSensor distSensor;
	private EV3ColorSensor colorSensor;
	private SensorMode color;
	private SampleProvider distance;
	
	private float[] distanceData;
	private float[] colorData;
	

	public Sensors(EV3UltrasonicSensor dS,EV3ColorSensor cS) {

		this.distSensor = dS;
		this.colorSensor = cS;

		this.color = colorSensor.getColorIDMode();
		this.distance = distSensor.getDistanceMode();

		this.distanceData = new float[distance.sampleSize()];
		this.colorData = new float[color.sampleSize()];

	}

	
	public String colorNamer (float[] array) {

		//Cast first element of float array into an integer
		//So that we can use it on switch statement

		int colorId= (int) array[0];

		String colorName="";

		// use more new lines; hard to read

		switch(colorId) {

		case Color.BLACK: colorName = "black"; break;
		case Color.BLUE: colorName = "blue"; break;
		case Color.BROWN: colorName = "brown"; break;
		case Color.CYAN: colorName = "cyan"; break;
		case Color.DARK_GRAY: colorName = "dark gray"; break;
		case Color.GRAY: colorName = "gray"; break;
		case Color.GREEN: colorName = "green"; break;
		case Color.LIGHT_GRAY: colorName = "light gray"; break;
		case Color.MAGENTA: colorName = "magenta"; break;
		case Color.NONE: colorName = "none"; break;
		case Color.ORANGE: colorName = "orange"; break;
		case Color.PINK: colorName = "pink"; break;
		case Color.RED: colorName = "red"; break;
		case Color.WHITE: colorName = "white"; break;
		case Color.YELLOW: colorName = "yellow"; break;

		}

		return colorName;

	}


	public String fetchColor() {
		this.color.fetchSample(colorData, 0);
		return colorNamer(colorData);
	}

	
	public float fetchDistance() {
		distance.fetchSample(distanceData, 0);
		return distanceData[0]*100;
	}

}
