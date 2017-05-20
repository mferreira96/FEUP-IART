package cli;

import algorithm.SimulatedAnnealing;
import algorithm.Solver;

public class ExamSheduler {


	public static void main(String[] args) {


		Solver solver = new Solver();	
		
		solver.geneticAlgorithm(20, 1, 10, 0.6, 0.7, 0.2);

		//solver.simulatedAnnealing(20, 500, 10, 20, 0.001, 0.95, SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE);	
	}
}
