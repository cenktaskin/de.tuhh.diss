package lab5;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;

public class Controller {

	private RegulatedMotor rightMotor;
	private RegulatedMotor leftMotor;
	private EV3GyroSensor gyroscope;

	private SampleProvider angle;
	private float[] angleData;

	private double kp;
	private double ki;
	private int targetAngle;

	public Controller (EV3LargeRegulatedMotor motorRight,EV3LargeRegulatedMotor motorLeft,EV3GyroSensor gyro) {

		this.rightMotor = motorRight;
		this.leftMotor = motorLeft;
		this.gyroscope = gyro;
		this.angle = gyroscope.getAngleMode();
		this.angleData= new float[angle.sampleSize()];
	}

	public static int angleCalculator(double distance) {

		double a = -distance*180/(3*9);

		int angle = (int) Math.round(a);

		return angle;
	}

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

	public float fetchAngle() {

		angle.fetchSample(angleData,0);

		return angleData[0];
	}

	public void changeTarget(int degrees) {
		this.targetAngle=degrees+this.targetAngle;
	}

	public void rotate(){

		double error=0;
		int speed=0;
		double errorKI = 0;
		double eps=Math.abs(targetAngle*0.005);

		setSpeed(0);

		error = targetAngle - fetchAngle();

		while (Math.abs(error)>eps){ 

			error = targetAngle - fetchAngle(); // calculate new error

			errorKI += error;

			if (Math.abs(errorKI) > 150) { // zeros the integral controller error to prevent excessive cumulative error

				errorKI = 0;
			}

			speed = (int) (kp*error + ki*errorKI);

			setSpeed(Math.abs(speed));

			rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
			rightMotor.startSynchronization();

			if (speed > 0) {

				rightMotor.backward();
				leftMotor.forward();

			} else {

				rightMotor.forward();
				leftMotor.backward();
			}
			
			rightMotor.endSynchronization();

		}

		error = 0;

		setSpeed(0);

		rightMotor.stop();

		leftMotor.stop();

	}

	public void translate(int distance) {

		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});

		rightMotor.startSynchronization();
		rightMotor.rotate(angleCalculator(distance), true);
		leftMotor.rotate(angleCalculator(distance), false);
		rightMotor.endSynchronization();
		rightMotor.waitComplete();
		leftMotor.waitComplete();

	}


}
