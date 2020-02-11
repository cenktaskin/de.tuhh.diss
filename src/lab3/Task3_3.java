package lab3;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Task3_3 {

	//Define two areas in order to create rushing and approaching behavior
	static final double INNER_AREA=3.8;  //in centimeters
	static final double OUTER_AREA=10.0; //in centimeters

	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	EV3UltrasonicSensor distanceSensor = new EV3UltrasonicSensor(SensorPort.S4);

	//Set the sensor modes
	SensorMode color = colorSensor.getColorIDMode();
	SampleProvider distance = distanceSensor.getDistanceMode();

	float[] distanceData = new float[distance.sampleSize()];
	float[] colorData = new float[color.sampleSize()];


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

	public void move (int speed, String mode) {

		rightMotor.setSpeed(speed);
		leftMotor.setSpeed(speed);

		rightMotor.backward();
		if (mode=="rotate") {
			leftMotor.forward();
		}else if(mode=="translate") {
			leftMotor.backward();
		}

	}


	public static void main(String[] args) {

		Task3_3 obj= new Task3_3();

		int currentSpeed=0;
		float currentDistance;
		String currentColor;
		while (true) {

			obj.color.fetchSample(obj.colorData, 0);
			obj.distance.fetchSample(obj.distanceData, 0);
			currentDistance=obj.distanceData[0]*100; //100 corresponds to meter to centimeter conversion
			currentColor=obj.colorNamer(obj.colorData);

			//Set the speed based on the proximity to an obstacle
			if (currentDistance < OUTER_AREA) {
				currentSpeed= (int) Math.pow(currentDistance, 2);
			}else if(currentDistance < INNER_AREA){
				currentSpeed=0;
			}else {
				currentSpeed=1000;
			}

			obj.move(currentSpeed,"translate");

			//Display data on the LCD screen
			LCD.drawString("That is "+currentColor, 0, 1);
			LCD.drawString("That is "+currentDistance+" cm away from me", 0, 2);

			Delay.msDelay(250);
			LCD.clear();

		}

	}

}


