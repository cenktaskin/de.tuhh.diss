package lab5;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class Robot {

	private Sensors robotSensor;
	Driver robotDriver;
	UserInterface robotUi;

	public Robot (EV3LargeRegulatedMotor motorRight,EV3LargeRegulatedMotor motorLeft,EV3GyroSensor sensorGyro,EV3UltrasonicSensor sensorDist,EV3ColorSensor sensorCol,UserInterface ui) {

		this.robotSensor = new Sensors(sensorDist,sensorCol);
		this.robotDriver = new Driver(motorRight, motorLeft,sensorGyro);
		this.robotUi = ui;
	}

	public boolean checkAhead() {

		float currentDistance = this.robotSensor.fetchDistance();

		if (currentDistance < 25) {

			return false;

		}else {

			return true;

		}
	}

	public boolean checkRight() {

		robotDriver.turnRight();

		float currentDistance = robotSensor.fetchDistance();	

		if (currentDistance < 25) {

			return false;

		}else {

			return true;

		}
	}

	public boolean checkLeft() {

		this.robotDriver.turnLeft();

		float currentDistance = this.robotSensor.fetchDistance();

		if (currentDistance < 20) {

			return false;

		}else {

			return true;

		}
	}

	public boolean checkWallColours(String chosenColor) {

		String currentColor;
		int i = 1;

		while(i<=3) {

			robotDriver.approachWall();

			currentColor = this.robotSensor.fetchColor();

			robotDriver.departWall();

			if (currentColor == chosenColor) {

				return true;

			}

			robotDriver.turnRight();
			i++;
		}

		return false;
	}


}
