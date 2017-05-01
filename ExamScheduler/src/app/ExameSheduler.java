package app;

import algorithm.Solver;

public class ExameSheduler {

	
	public static void main(String[] args) {

				
	Solver solver = new Solver();	

	
	//solver.geneticAlgorithm();
	
	solver.simulatedAnnealing(1, 20, 8);
	
	
	
	}
}
