package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import logic.Exam;
import logic.Problem;
import logic.Student;
import utils.Utils;

public class Solver {

	public void geneticAlgorithm(){
				
		int iterations = 1;
		int population_size = 10;
		double mutation_rate = 0.5;
		double crossover_rate = 0.3;
		double elitism_count = 0.2;
		int days = 32;
		
		
		/// DADOS
		
		Exam e1 = new Exam(0,"LBAW",3);
		Exam e2 = new Exam(1,"LTW",2);
		Exam e3 = new Exam(2,"SDIS",3);
		Exam e4 = new Exam(3,"PPIN",3);
				
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
	
	// TODO - CORRIGIR PARAMETROS DA CLASSE (PASSAR AQUI AS VARIAVEIS DE INICIO E FIM DO PERIODO DE EXAMES)
	public void simulatedAnnealing(int startingDay, int endDay, int numExams){
		// TODO - VARIAVEIS INICIAIS - PASSAR ESTAS VARIAVEIS ATRAVES DOS PARAMETROS DA FUNÇÃO???
		// TODO - CRIAR FUNÇAO OBJETIVO(CUSTO)
		// TODO - DEFINIR OUTRO VALOR DE COOLING RATE??
		double temperature = 400;
		double coolingRate = 0.9;
		// TODO - key do exame - dia - usar linkedhashmap (preserva ordem com que elemento foram inseridos)
		HashMap<Integer, Integer> solution= new HashMap<Integer, Integer>();
		solution.put(0, 3);
		solution.put(1, 18);
		solution.put(2, 15);
		solution.put(3, 6);
		solution.put(4, 1);
		solution.put(5, 9);
		solution.put(6, 7);
		solution.put(7, 2);
		
		System.out.println("dkhsajdhaskjdha");
		
			
		Random random = new Random();
		int value = random.nextInt(5);
		
		// TODO - CORRIGIR
		while(temperature > 0.5){
			int examToChange = random.nextInt(numExams);
			int newExameDay = random.nextInt(endDay-startingDay)+startingDay;
			
			HashMap<Integer, Integer> newSolution = new HashMap<Integer, Integer>();
			solution.forEach(newSolution::putIfAbsent);			
			newSolution.put(examToChange, newExameDay);
			
			// TODO - FALTA APENAS CALCULAR CUSTO DE CADA CONFIGURAÇAO DE ESTADOS
			int value1 = SimulatedAnnealing.getDiff(solution, numExams);
			int value2 = SimulatedAnnealing.getDiff(newSolution, numExams);
			
			System.out.println(value1);
			
			double change = value2 - value1;
			if ((change < 0) || (random.nextDouble() < Math.pow(Math.E, -change / temperature)))
				solution = newSolution;
			
			
			temperature = coolingRate * temperature;			
		}
		
		System.out.println(solution);		
	}
	
	public void updateExameDate(Problem problem, Individual bestIndividual){
		
		ArrayList<Integer[]> aux = Utils.splitChromossome(bestIndividual.getChromossome(), problem.getByteDays());
		
		
		for(int i = 0 ; i < problem.getNumberOfExames(); i++){
			int date = Utils.byteToInt(aux.get(i));
			problem.getExame(i).setDate(date);
		}
	}
}
