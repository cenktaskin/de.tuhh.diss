package lab4;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class GyroscopeTurning extends SimpleTurning {

	EV3GyroSensor gyroscope = new EV3GyroSensor(SensorPort.S3);
	SampleProvider gyroAngle = gyroscope.getAngleMode();

	public void gyroTurn(int degrees){

		float[] angleArray= new float[gyroAngle.sampleSize()]; 

		double eps=0.5;

		float currentAngle;
		float error;

		do{ 

			gyroAngle.fetchSample(angleArray, 0);

			currentAngle = angleArray[0];

			error=degrees - currentAngle;

			rightMotor.backward();

			leftMotor.forward();
			
			LCD.drawString(""+currentAngle+"degrees", 0, 1);
			LCD.drawString(""+error+"error", 0, 2);
			Delay.msDelay(250);
			LCD.clear();

		}while(error > eps);


	}
}
