package algorithm;

import java.util.ArrayList;

import logic.Exame;
import logic.Problem;
import logic.Student;
import logic.Utils;

public class Solver {

	public void geneticAlgorithm(){
				
		int iterations = 1;
		int population_size = 10;
		double mutation_rate = 0.5;
		double crossover_rate = 0.3;
		double elitism_count = 0.2;
		int days = 32;
		
		
		/// DADOS
		
		Exame e1 = new Exame(0,"LBAW",3);
		Exame e2 = new Exame(1,"LTW",2);
		Exame e3 = new Exame(2,"SDIS",3);
		Exame e4 = new Exame(3,"PPIN",3);
				
		Student s1 = new Student("joao",0,3);
		Student s2 = new Student("maria",1,3);
		Student s3 = new Student("jose", 2,3);
		
		e1.addStudent(s1); e1.addStudent(s2); e1.addStudent(s3);
		e2.addStudent(s2);
		e3.addStudent(s1); e3.addStudent(s2); e3.addStudent(s3);
		e4.addStudent(s1); e4.addStudent(s2); e4.addStudent(s3);
		
		Problem problem = new Problem(days);
		
		problem.addExame(e1);
		problem.addExame(e2);
		problem.addExame(e3);
		problem.addExame(e4);
		
		
		// -----------------------

		
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
				
		Individual bestIndividual = ga.getPopulation().getFittest(0);
		System.out.println("Final");
		System.out.println("Fitness ....... "  + bestIndividual .getFitness());
		
		
		updateExameDate(problem, bestIndividual);
		

		
		System.out.println("------------------------ PROBLEM ----------------------------");
		
		for(int  j = 0 ; j < problem.getNumberOfExames(); j++){
			System.out.println(problem.getExame(j).toString());
		}

	}
	
	
	public void simulatedAnnealing(){
		
		// TODO deve ser desenvolvido ciclo do algoritmo para obter a soluçao aqui
		
	}
	
	public void updateExameDate(Problem problem, Individual bestIndividual){
		
		ArrayList<Integer[]> aux = Utils.splitChromossome(bestIndividual.getChromossome(), problem.getByteDays());
		
		
		for(int i = 0 ; i < problem.getNumberOfExames(); i++){
			int data = Utils.byteToInt(aux.get(i));
			problem.getExame(i).setData(data);
		}
	}
}
