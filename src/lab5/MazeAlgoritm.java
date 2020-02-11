package lab5;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class MazeAlgoritm {

	public static void main(String[] args) {

		EV3LargeRegulatedMotor rightM = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor leftM = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3GyroSensor gyroS = new EV3GyroSensor(SensorPort.S3);
		EV3UltrasonicSensor distS = new EV3UltrasonicSensor(SensorPort.S4);
		EV3ColorSensor colorS = new EV3ColorSensor(SensorPort.S1);
		UserInterface ui = new UserInterface();

		Robot mazeRobot = new Robot (rightM,leftM,gyroS,distS,colorS,ui);

		String targetColour = mazeRobot.robotUi.navigation();

		while (true) {
			
			mazeRobot.robotDriver.move1Unit();
			
			if (mazeRobot.checkRight() == false) {
				
				mazeRobot.robotDriver.turnLeft();

				if (mazeRobot.checkAhead() == true) {
					
					continue;
					
				} else {
					
					if(mazeRobot.checkLeft() == true) {
						
						continue; //Right elbow corner scenario
						
					} else {
						//Dead end scenario
						if (mazeRobot.checkWallColours(targetColour) == true) {

							//Color is found
							while (true) {

								mazeRobot.robotUi.maestro();
								mazeRobot.robotUi.show("I found the " +targetColour+ " wall!",0,1);
							}

						} else {

							continue;
						}
					}
				}

			} else {

				continue;
			}
		}


	}

}

