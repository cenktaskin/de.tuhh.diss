package lab2;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import java.lang.Math;

public class Task2_3 {

	public static int angle_calc(double distance) {

		double a = -distance*180/(3*9);

		int angle = (int) Math.round(a);

		return angle;
	}

	public static void main(String[] args) {

		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);

		int desired_distance = 100; // mm

		rightMotor.rotate(Task2_3.angle_calc(desired_distance), true);
		leftMotor.rotate(Task2_3.angle_calc(desired_distance), false);


	}
}