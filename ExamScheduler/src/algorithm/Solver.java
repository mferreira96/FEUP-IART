package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import logic.Exam;
import logic.Problem;
import logic.Student;
import utils.Utils;

public class Solver {
	Problem problem;

	public void geneticAlgorithm(){
				
		int iterations = 1;
		int population_size = 10;
		double mutation_rate = 0.6;
		double crossover_rate = 0.7;
		double elitism_count = 0.2;
		int days = 32;
		
		
		/// DADOS
		
		/*Exam e1 = new Exam(0,"LBAW",3);
		Exam e2 = new Exam(1,"LTW",2);
		Exam e3 = new Exam(2,"SDIS",3);
		Exam e4 = new Exam(3,"PPIN",3);
				
		Student s1 = new Student(0, "joao", 3);
		Student s2 = new Student(1, "maria", 3);
		Student s3 = new Student(2, "jose", 3);
		
		e1.addStudent(s1); e1.addStudent(s3);
		e2.addStudent(s2);
		e3.addStudent(s1); e3.addStudent(s3); 
		e4.addStudent(s1); e4.addStudent(s3);
		
		problem = new Problem(days);
		
		problem.addExame(e1);
		problem.addExame(e2);
		problem.addExame(e3);
		problem.addExame(e4);*/
		
		Exam e1 = new Exam(0,"LBAW",3);
		Exam e2 = new Exam(1,"LTW",2);
		Exam e3 = new Exam(2,"SDIS",3);
		Exam e4 = new Exam(3,"PPIN",3);
		Exam e5 = new Exam(4,"MAT",3);
		Exam e6 = new Exam(5,"FIS",1);
		Exam e7 = new Exam(6,"QUIM",2);
		Exam e8 = new Exam(7,"PSIC",3);
				
		Student s1 = new Student(0, "joao1", 3);
		Student s2 = new Student(1, "maria2", 3);
		Student s3 = new Student(2, "jose3", 3);
		Student s4 = new Student(3, "joao4", 3);
		Student s5 = new Student(4, "maria5", 3);
		Student s6 = new Student(5, "jose6", 3);
		Student s7 = new Student(6, "joao7", 3);
		Student s8 = new Student(7, "maria8", 3);
		Student s9 = new Student(8, "jose9", 3);
		Student s10 = new Student(9, "joao10", 3);
		Student s11 = new Student(10, "maria11", 3);
		Student s12 = new Student(11, "jose12", 3);
		Student s13 = new Student(12, "joao13", 3);
		Student s14 = new Student(13, "maria14", 3);
		Student s15 = new Student(14, "jose15", 3);
		Student s16 = new Student(15, "joao16", 3);
		Student s17 = new Student(16, "maria17", 3);
		Student s18 = new Student(17, "jose18", 3);
		Student s19 = new Student(18, "joao19", 3);
		Student s20 = new Student(19, "maria20", 3);
		Student s21 = new Student(20, "jose21", 3);
		Student s22 = new Student(21, "joao22", 3);
		Student s23 = new Student(22, "maria23", 3);
		Student s24 = new Student(23, "jose24", 3);
		Student s25 = new Student(24, "joao25", 3);
		Student s26 = new Student(25, "maria26", 3);
		Student s27 = new Student(26, "jose27", 3);
		Student s28 = new Student(27, "joao28", 3);
		Student s29 = new Student(28, "maria29", 3);
		Student s30 = new Student(29, "jose30", 3);
		

		
		e1.addStudent(s1);
		s1.addExam(e1);
		e1.addStudent(s2);
		s2.addExam(e1);
		e1.addStudent(s3);
		s3.addExam(e1);
		e1.addStudent(s4);
		s4.addExam(e1);
		e1.addStudent(s5);
		s5.addExam(e1);
		e1.addStudent(s6);
		s6.addExam(e1);
		e1.addStudent(s7);
		s7.addExam(e1);
		e1.addStudent(s8);
		s8.addExam(e1);
		e1.addStudent(s9);
		s9.addExam(e1);
		e2.addStudent(s11);
		s11.addExam(e2);
		e2.addStudent(s2);
		s2.addExam(e2);
		e2.addStudent(s30);
		s30.addExam(e2);
		e2.addStudent(s4);
		s4.addExam(e2);
		e2.addStudent(s5);
		s5.addExam(e2);
		e2.addStudent(s16);
		s16.addExam(e2);
		e2.addStudent(s27);
		s27.addExam(e2);
		e2.addStudent(s28);
		s28.addExam(e2);
		e2.addStudent(s23);
		s23.addExam(e2);
		e3.addStudent(s1);
		s1.addExam(e3);
		e3.addStudent(s2);
		s2.addExam(e3);
		e3.addStudent(s3);
		s3.addExam(e3);
		e3.addStudent(s4);
		s4.addExam(e3);
		e3.addStudent(s6);
		s6.addExam(e3);
		e3.addStudent(s9);
		s9.addExam(e3);
		e3.addStudent(s10);
		s10.addExam(e3);
		e3.addStudent(s12);
		s12.addExam(e3);
		e3.addStudent(s13);
		s13.addExam(e3);
		e3.addStudent(s21);
		s21.addExam(e3);
		e3.addStudent(s22);
		s22.addExam(e3);
		e3.addStudent(s23);
		s23.addExam(e3);
		e3.addStudent(s24);
		s24.addExam(e3);
		e3.addStudent(s25);
		s25.addExam(e3);
		e3.addStudent(s26);
		s26.addExam(e3);
		e3.addStudent(s3);
		s3.addExam(e3);
		e4.addStudent(s1);
		s1.addExam(e4);
		e4.addStudent(s2);
		s2.addExam(e4);
		e4.addStudent(s3);
		s3.addExam(e4);
		e4.addStudent(s5);
		s5.addExam(e4);
		e4.addStudent(s6);
		s6.addExam(e4);
		e4.addStudent(s9);
		s9.addExam(e4);
		e4.addStudent(s10);
		s10.addExam(e4);
		e4.addStudent(s12);
		s12.addExam(e4);
		e4.addStudent(s13);
		s13.addExam(e4);
		e5.addStudent(s1);
		s1.addExam(e5);
		e5.addStudent(s4);
		s4.addExam(e5);
		e5.addStudent(s5);
		s5.addExam(e5);
		e5.addStudent(s6);
		s6.addExam(e5);
		e5.addStudent(s9);
		s9.addExam(e5);
		e5.addStudent(s20);
		s20.addExam(e5);
		e5.addStudent(s22);
		s22.addExam(e5);
		e5.addStudent(s13);
		s13.addExam(e5);
		e6.addStudent(s1);
		s1.addExam(e6);
		e6.addStudent(s8);
		s8.addExam(e6);
		e6.addStudent(s9);
		s9.addExam(e6);
		e6.addStudent(s24);
		s24.addExam(e6);
		e6.addStudent(s26);
		s26.addExam(e6);
		e6.addStudent(s17);
		s17.addExam(e6);
		e7.addStudent(s2);
		s2.addExam(e7);
		e7.addStudent(s4);
		s4.addExam(e7);
		e7.addStudent(s14);
		s14.addExam(e7);
		e7.addStudent(s25);
		s25.addExam(e7);
		e7.addStudent(s29);
		s29.addExam(e7);
		e7.addStudent(s18);
		s18.addExam(e7);
		e8.addStudent(s15);
		s15.addExam(e8);
		e8.addStudent(s19);
		s19.addExam(e8);
		e8.addStudent(s4);
		s4.addExam(e8);
		e8.addStudent(s6);
		s6.addExam(e8);
		e8.addStudent(s7);
		s7.addExam(e8);
		e8.addStudent(s8);
		s8.addExam(e8);
		
		
		problem = new Problem(days);
		
		problem.addStudent(s1);
		problem.addStudent(s2);
		problem.addStudent(s3);
		problem.addStudent(s4);
		problem.addStudent(s5);
		problem.addStudent(s6);
		problem.addStudent(s7);
		problem.addStudent(s8);
		problem.addStudent(s9);
		problem.addStudent(s10);
		problem.addStudent(s11);
		problem.addStudent(s12);
		problem.addStudent(s13);
		problem.addStudent(s14);
		problem.addStudent(s15);
		problem.addStudent(s16);
		problem.addStudent(s17);
		problem.addStudent(s18);
		problem.addStudent(s19);
		problem.addStudent(s20);
		problem.addStudent(s21);
		problem.addStudent(s22);
		problem.addStudent(s23);
		problem.addStudent(s24);
		problem.addStudent(s25);
		problem.addStudent(s26);
		problem.addStudent(s27);
		problem.addStudent(s28);
		problem.addStudent(s29);
		problem.addStudent(s30);
		problem.addStudent(s16);
		
		problem.addExame(e1);
		problem.addExame(e2);
		problem.addExame(e3);
		problem.addExame(e4);
		problem.addExame(e5);
		problem.addExame(e6);
		problem.addExame(e7);
		problem.addExame(e8);
		
		
		Evaluator ev = Evaluator.getInstance();
		
		ev.createGraph(problem.getExames());
		
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
		
		
		Exam e1 = new Exam(0,"LBAW",3);
		Exam e2 = new Exam(1,"LTW",2);
		Exam e3 = new Exam(2,"SDIS",3);
		Exam e4 = new Exam(3,"PPIN",3);
		Exam e5 = new Exam(4,"EXAM1",3);
		Exam e6 = new Exam(5,"EXAM2",1);
		Exam e7 = new Exam(6,"EXAM3",2);
		Exam e8 = new Exam(7,"EXAM4",3);
				
		Student s1 = new Student(0, "joao1", 3);
		Student s2 = new Student(1, "maria2", 3);
		Student s3 = new Student(2, "jose3", 3);
		Student s4 = new Student(3, "joao4", 3);
		Student s5 = new Student(4, "maria5", 3);
		Student s6 = new Student(5, "jose6", 3);
		Student s7 = new Student(6, "joao7", 3);
		Student s8 = new Student(7, "maria8", 3);
		Student s9 = new Student(8, "jose9", 3);
		Student s10 = new Student(9, "joao10", 3);
		Student s11 = new Student(10, "maria11", 3);
		Student s12 = new Student(11, "jose12", 3);
		Student s13 = new Student(12, "joao13", 3);
		Student s14 = new Student(13, "maria14", 3);
		Student s15 = new Student(14, "jose15", 3);
		Student s16 = new Student(15, "joao16", 3);
		Student s17 = new Student(16, "maria17", 3);
		Student s18 = new Student(17, "jose18", 3);
		Student s19 = new Student(18, "joao19", 3);
		Student s20 = new Student(19, "maria20", 3);
		Student s21 = new Student(20, "jose21", 3);
		Student s22 = new Student(21, "joao22", 3);
		Student s23 = new Student(22, "maria23", 3);
		Student s24 = new Student(23, "jose24", 3);
		Student s25 = new Student(24, "joao25", 3);
		Student s26 = new Student(25, "maria26", 3);
		Student s27 = new Student(26, "jose27", 3);
		Student s28 = new Student(27, "joao28", 3);
		Student s29 = new Student(28, "maria29", 3);
		Student s30 = new Student(29, "jose30", 3);
		

		
		e1.addStudent(s1);
		s1.addExam(e1);
		e1.addStudent(s2);
		s2.addExam(e1);
		e1.addStudent(s3);
		s3.addExam(e1);
		e1.addStudent(s4);
		s4.addExam(e1);
		e1.addStudent(s5);
		s5.addExam(e1);
		e1.addStudent(s6);
		s6.addExam(e1);
		e1.addStudent(s7);
		s7.addExam(e1);
		e1.addStudent(s8);
		s8.addExam(e1);
		e1.addStudent(s9);
		s9.addExam(e1);
		e2.addStudent(s11);
		s11.addExam(e2);
		e2.addStudent(s2);
		s2.addExam(e2);
		e2.addStudent(s30);
		s30.addExam(e2);
		e2.addStudent(s4);
		s4.addExam(e2);
		e2.addStudent(s5);
		s5.addExam(e2);
		e2.addStudent(s16);
		s16.addExam(e2);
		e2.addStudent(s27);
		s27.addExam(e2);
		e2.addStudent(s28);
		s28.addExam(e2);
		e2.addStudent(s23);
		s23.addExam(e2);
		e3.addStudent(s1);
		s1.addExam(e3);
		e3.addStudent(s2);
		s2.addExam(e3);
		e3.addStudent(s3);
		s3.addExam(e3);
		e3.addStudent(s4);
		s4.addExam(e3);
		e3.addStudent(s6);
		s6.addExam(e3);
		e3.addStudent(s9);
		s9.addExam(e3);
		e3.addStudent(s10);
		s10.addExam(e3);
		e3.addStudent(s12);
		s12.addExam(e3);
		e3.addStudent(s13);
		s13.addExam(e3);
		e3.addStudent(s21);
		s21.addExam(e3);
		e3.addStudent(s22);
		s22.addExam(e3);
		e3.addStudent(s23);
		s23.addExam(e3);
		e3.addStudent(s24);
		s24.addExam(e3);
		e3.addStudent(s25);
		s25.addExam(e3);
		e3.addStudent(s26);
		s26.addExam(e3);
		e3.addStudent(s3);
		s3.addExam(e3);
		e4.addStudent(s1);
		s1.addExam(e4);
		e4.addStudent(s2);
		s2.addExam(e4);
		e4.addStudent(s3);
		s3.addExam(e4);
		e4.addStudent(s5);
		s5.addExam(e4);
		e4.addStudent(s6);
		s6.addExam(e4);
		e4.addStudent(s9);
		s9.addExam(e4);
		e4.addStudent(s10);
		s10.addExam(e4);
		e4.addStudent(s12);
		s12.addExam(e4);
		e4.addStudent(s13);
		s13.addExam(e4);
		e5.addStudent(s1);
		s1.addExam(e5);
		e5.addStudent(s4);
		s4.addExam(e5);
		e5.addStudent(s5);
		s5.addExam(e5);
		e5.addStudent(s6);
		s6.addExam(e5);
		e5.addStudent(s9);
		s9.addExam(e5);
		e5.addStudent(s20);
		s20.addExam(e5);
		e5.addStudent(s22);
		s22.addExam(e5);
		e5.addStudent(s13);
		s13.addExam(e5);
		e6.addStudent(s1);
		s1.addExam(e6);
		e6.addStudent(s8);
		s8.addExam(e6);
		e6.addStudent(s9);
		s9.addExam(e6);
		e6.addStudent(s24);
		s24.addExam(e6);
		e6.addStudent(s26);
		s26.addExam(e6);
		e6.addStudent(s17);
		s17.addExam(e6);
		e7.addStudent(s2);
		s2.addExam(e7);
		e7.addStudent(s4);
		s4.addExam(e7);
		e7.addStudent(s14);
		s14.addExam(e7);
		e7.addStudent(s25);
		s25.addExam(e7);
		e7.addStudent(s29);
		s29.addExam(e7);
		e7.addStudent(s18);
		s18.addExam(e7);
		e8.addStudent(s15);
		s15.addExam(e8);
		e8.addStudent(s19);
		s19.addExam(e8);
		e8.addStudent(s4);
		s4.addExam(e8);
		e8.addStudent(s6);
		s6.addExam(e8);
		e8.addStudent(s7);
		s7.addExam(e8);
		e8.addStudent(s8);
		s8.addExam(e8);
		
		
		problem = new Problem(endDay);
		
		problem.addStudent(s1);
		problem.addStudent(s2);
		problem.addStudent(s3);
		problem.addStudent(s4);
		problem.addStudent(s5);
		problem.addStudent(s6);
		problem.addStudent(s7);
		problem.addStudent(s8);
		problem.addStudent(s9);
		problem.addStudent(s10);
		problem.addStudent(s11);
		problem.addStudent(s12);
		problem.addStudent(s13);
		problem.addStudent(s14);
		problem.addStudent(s15);
		problem.addStudent(s16);
		problem.addStudent(s17);
		problem.addStudent(s18);
		problem.addStudent(s19);
		problem.addStudent(s20);
		problem.addStudent(s21);
		problem.addStudent(s22);
		problem.addStudent(s23);
		problem.addStudent(s24);
		problem.addStudent(s25);
		problem.addStudent(s26);
		problem.addStudent(s27);
		problem.addStudent(s28);
		problem.addStudent(s29);
		problem.addStudent(s30);
		problem.addStudent(s16);
		
		problem.addExame(e1);
		problem.addExame(e2);
		problem.addExame(e3);
		problem.addExame(e4);
		problem.addExame(e5);
		problem.addExame(e6);
		problem.addExame(e7);
		problem.addExame(e8);
		
		
		
		// TODO - VARIAVEIS INICIAIS - PASSAR ESTAS VARIAVEIS ATRAVES DOS PARAMETROS DA FUNÇÃO???
		// TODO - CRIAR FUNÇAO OBJETIVO(CUSTO)
		// TODO - DEFINIR OUTRO VALOR DE COOLING RATE??
		double temperature = 2000000000;
		double coolingRate = 0.95;
	
					
		Random random = new Random();
		
		problem.getExames().get(0).setDate(3);
		problem.getExames().get(1).setDate(4);
		problem.getExames().get(2).setDate(5);
		problem.getExames().get(3).setDate(6);
		problem.getExames().get(4).setDate(7);
		problem.getExames().get(5).setDate(8);
		problem.getExames().get(6).setDate(9);
		problem.getExames().get(7).setDate(10);
		
		double currentValue = SimulatedAnnealing.objectiveFunction(problem);
		
		
		// calcular antes de começar o ciclo o custo da soluçao presente
		
		// TODO - CORRIGIR
		while(temperature > 0.5){
			int examToChange = random.nextInt(numExams);
			int oldExamDay = problem.getExames().get(examToChange).getDate();
			int newExamDay = random.nextInt(endDay-startingDay)+startingDay;
			problem.getExames().get(examToChange).setDate(newExamDay);
			
			double newValue = SimulatedAnnealing.objectiveFunction(problem);
			
			System.out.println(currentValue);
			
			double change = newValue - currentValue;
			if ((change > 0) || (random.nextDouble() < Math.pow(Math.E, change / temperature)))
				currentValue = newValue;
			else
				problem.getExames().get(examToChange).setDate(oldExamDay);			
			
			temperature *= coolingRate;			
		}
		
		System.out.println(problem);
			
	}
	
	public void updateExameDate(Problem problem, Individual bestIndividual){
		
		ArrayList<Integer[]> aux = Utils.splitChromossome(bestIndividual.getChromossome(), problem.getNumberOfExames());
		
		
		for(int i = 0 ; i < problem.getNumberOfExames(); i++){
			int date = Utils.byteToInt(aux.get(i));
			problem.getExame(i).setDate(date);
		}
	}
	
	public Problem getProblem(){
		return problem;
	}
}
