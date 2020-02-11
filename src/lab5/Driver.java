package lab5;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3GyroSensor;


public class Driver {

	private Controller robotController;
	
	public Driver (EV3LargeRegulatedMotor motorRight,EV3LargeRegulatedMotor motorLeft,EV3GyroSensor gyro) {

		this.robotController = new Controller(motorRight,motorLeft,gyro);
	}

	public void move1Unit() {
		int desired_distance = 350; // mm

		robotController.setSpeed(600);

		robotController.translate(desired_distance);
		
		robotController.setSpeed(0);

	}

	public void approachWall() {
		int desired_distance = 90; // mm

		robotController.setSpeed(400);

		robotController.translate(desired_distance);

	}

	public void departWall() {
		int desired_distance = -90; // mm

		robotController.setSpeed(400);

		robotController.translate(desired_distance);

	}

	public void turnRight() {

		int desireddegree=(-90);

		robotController.setKp(10);

		robotController.setKi(0);
		
		robotController.changeTarget(desireddegree);
		robotController.rotate();
		
	}

	public void turnLeft() {
		
		int desireddegree=(90);

		robotController.setKp(10);

		robotController.setKi(0);
		
		robotController.changeTarget(desireddegree);
		robotController.rotate();

	}

}
