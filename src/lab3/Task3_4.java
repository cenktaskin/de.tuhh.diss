package lab3;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Task3_4 {

	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S3);

	SampleProvider angle = gyroSensor.getAngleMode();

	float[] angleData = new float[angle.sampleSize()];
	float currentAngle;

	public static void main(String[] args) {

		Task3_4 obj= new Task3_4();

		int speed=100;

		while (true) {

			obj.angle.fetchSample(obj.angleData, 0);
			obj.currentAngle=obj.angleData[0];

			obj.rightMotor.setSpeed(speed);
			obj.leftMotor.setSpeed(speed);

			obj.rightMotor.backward();
			obj.leftMotor.forward();


			//Display data on the LCD screen
			LCD.drawString(""+obj.currentAngle, 0, 1);

			Delay.msDelay(250);
			LCD.clear();
		}
	}
}
