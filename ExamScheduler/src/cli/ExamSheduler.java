package cli;

import algorithm.Solver;

public class ExamSheduler {


	public static void main(String[] args) {


		Solver solver = new Solver();	

		//solver.geneticAlgorithm(20);


		solver.simulatedAnnealing(20, 0.5, 20000, 0.95);	
	}
}
