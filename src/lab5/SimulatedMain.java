package lab5;

import MazebotSim.MazebotSimulation;

public class SimulatedMain {

	public static void main(String[] args) {
		MazebotSimulation sim = new MazebotSimulation("Mazes/maze_1_3by4.png", 1.5,  1.13);
		sim.setRobotPosition(0.2, 0.175, 90);
		sim.startSimulation();
				
		//Call to the old main method here
		
		MazeAlgoritm.main(new String[0]);
				
		sim.stopSimulation();


	}

}
