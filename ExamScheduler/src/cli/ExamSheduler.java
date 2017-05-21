package cli;

import algorithm.Solver;

public class ExamSheduler {


	public static void main(String[] args) {


		Solver solver = new Solver();	
		
		solver.geneticAlgorithm(32, 10, 150, 0.02, 0.7, 1);

		//solver.simulatedAnnealing(20, 500, 10, 20, 0.001, 0.95, SimulatedAnnealing.TypeOfDecrease.MULTIPLICATIVE);	
	}
}
