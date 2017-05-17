package cli;

import algorithm.Evaluator;
import algorithm.Solver;

public class ExamSheduler {

	
	public static void main(String[] args) {

				
	Solver solver = new Solver();	
	
	solver.geneticAlgorithm();
	
	// TODO - CORRIGIR CHAMDA
	//solver.simulatedAnnealing(1, 20, 8);
	
	
	}
}
