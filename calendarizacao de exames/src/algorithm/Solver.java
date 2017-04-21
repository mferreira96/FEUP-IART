package algorithm;

import java.util.ArrayList;

import logic.Exame;
import logic.Problem;

public class Solver {

	public void geneticAlgorithm(){
				
		int iterations = 1;
		int population_size = 10;
		double mutation_rate = 0.5;
		double crossover_rate = 0.3;
		double elitism_count = 0.2;
		int days = 32;
		
		ArrayList<Exame> exams = new ArrayList<Exame>();
		exams.add(new Exame(0,"LBAW",3));
		exams.add(new Exame(1,"LTW",2));
		exams.add(new Exame(2,"SDIS",3));
		exams.add(new Exame(3,"PPIN",3));
		
		Problem problem = new Problem(exams,days);
		
		GeneticAlgorithm ga = new GeneticAlgorithm(iterations, population_size, mutation_rate, crossover_rate, elitism_count, problem);
		
		ga.evalPopulation();
		
		while(!ga.isTerminated()){
			
			Individual ind = ga.getPopulation().getFittest(0);
			
			System.out.println("Fitness ....... "  + ind.getFitness());
			
			ga.crossoverPopulation();
			
			System.out.println(ga.getPopulation().toString());
			
			ga.mutatePopulation();
			
			System.out.println(ga.getPopulation().toString());
			
			ga.evalPopulation();
			
			ga.updateNumberOfIteration();
			
		}
				
		Individual ind = ga.getPopulation().getFittest(0);
		System.out.println("Final");
		System.out.println("Fitness ....... "  + ind.getFitness());
		
	}
	
	
	public void simulatedAnnealing(){
		
		// TODO deve ser desenvolvido ciclo do algoritmo para obter a soluçao aqui
		
	}
}
