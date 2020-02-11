package lab3;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3UltrasonicSensor;


public class Task3_2 {
	public static double sdCalculator(float numArray[])
	{
		double sum = 0.0, standardDeviation = 0.0;
		int length = numArray.length;
		for(double num : numArray) {
			sum += num;
		}
		double mean = sum/length;
		for(double num: numArray) {
			standardDeviation += Math.pow(num - mean, 2);
		}
		return Math.sqrt(standardDeviation/length);
	}

	public static void main(String[] args) {

		float[] array;
		int i=0;
		float[] history;
		double stDev=0;
		float currentDistance;

		EV3UltrasonicSensor distanceSensor = new EV3UltrasonicSensor(SensorPort.S4);

		SampleProvider distance = distanceSensor.getDistanceMode();

		array = new float[distance.sampleSize()];
		history = new float[10];

		try {
			while (true) {

				distance.fetchSample(array, 0);
				currentDistance=array[0]*100;
				history[i]=currentDistance;
				i=(i+1)%10;

				stDev=sdCalculator(history);

				LCD.drawString("That is "+ array[0]*100+" cm away from me", 0, 1);
				LCD.drawString("Stdev: "+stDev, 0, 2);

				Delay.msDelay(100);
				LCD.clear();
			}
		}finally {
			distanceSensor.close();
		}
	}

}
