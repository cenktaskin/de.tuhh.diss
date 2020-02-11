package lab4;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lab2.Task2_3;

public class SimpleTurning implements Turner {

	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);

	public void setSpeed(int degreesPerSecond) {

		rightMotor.setSpeed(degreesPerSecond);
		leftMotor.setSpeed(degreesPerSecond); 
		

	}

	public void turn(int degrees){
		
		double distance, circumference = (123+95)/2*Math.PI;

		distance=circumference*degrees/360;
		
		rightMotor.rotate(Task2_3.angle_calc(distance),true);
		leftMotor.rotate(-Task2_3.angle_calc(distance),false);

	}
}