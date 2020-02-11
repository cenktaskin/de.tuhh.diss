package lab4;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;


public class ProportionalController implements Turner {

	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3GyroSensor gyroscope = new EV3GyroSensor(SensorPort.S3);
	SampleProvider gyroAngle = gyroscope.getAngleMode();
	Stopwatch timer = new Stopwatch();

	double kp;
	double ki;

	public void setSpeed(int degreesPerSecond) {

		rightMotor.setSpeed(degreesPerSecond);
		leftMotor.setSpeed(degreesPerSecond);

	}

	public void setKp(double newKp) {

		kp = newKp;

	}

	public void setKi(double newKi) {

		ki = newKi;

	}

	public void turn(int degrees){

		float[] angleArray = new float[gyroAngle.sampleSize()]; 
		int error=0;
		int speed=0;
		int errorKI = 0;

		gyroAngle.fetchSample(angleArray, 0); // angle is stored in angleArray[0]
		
		timer.reset();

		while (timer.elapsed() < 5000) { // turn for 5 seconds

			error = (int) (degrees - angleArray[0]); // calculate new error

			errorKI += error;

			if (errorKI > 150) { // zeros the integral controller error to prevent excessive cumulative error

				errorKI = 0;
			}

			speed = (int) (kp*error + ki*errorKI);

			this.setSpeed(speed);

			if (speed > 0) {

				rightMotor.backward();

				leftMotor.forward();
			} else {

				rightMotor.forward();

				leftMotor.backward();

			}

			
			  //# We should use setSpeed from the interface //Here we have to move the
			 // motors too?
			  
			  gyroAngle.fetchSample(angleArray, 0); // fetch new gyro angle
			  
			  LCD.drawString("currentangle "+angleArray[0], 0, 1);
			  LCD.drawString("error: "+error, 0, 2); Delay.msDelay(250); LCD.clear();
			 
		}
		
		//angleArray[0] = 0;
		
		gyroscope.reset();
		
		rightMotor.stop();

		leftMotor.stop();

	}
}
