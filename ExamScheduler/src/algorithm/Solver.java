package algorithm;

import java.util.ArrayList;

import logic.Exam;
import logic.Problem;
import logic.Student;
import utils.Utils;

public class Solver {
	Problem problem;
	
	public Solver(){
		initProblem();
	}
	
	public void initProblem(){
		Exam e1 = new Exam(0,"LBAW",3);
		Exam e2 = new Exam(1,"LTW",2);
		Exam e3 = new Exam(2,"SDIS",3);
		Exam e4 = new Exam(3,"PPIN",3);
		Exam e5 = new Exam(4,"MAT",3);
		Exam e6 = new Exam(5,"FIS",1);
		Exam e7 = new Exam(6,"QUIM",2);
		Exam e8 = new Exam(7,"PSIC",3);
				
		Student s1 = new Student(0, "joao1", 3);
		Student s2 = new Student(1, "maria2", 2);
		Student s3 = new Student(2, "jose3", 1);
		Student s4 = new Student(3, "joao4", 4);
		Student s5 = new Student(4, "maria5", 5);
		Student s6 = new Student(5, "jose6", 3);
		Student s7 = new Student(6, "joao7", 2);
		Student s8 = new Student(7, "maria8", 4);
		Student s9 = new Student(8, "jose9", 2);
		Student s10 = new Student(9, "joao10", 4);
		Student s11 = new Student(10, "maria11", 3);
		Student s12 = new Student(11, "jose12", 2);
		Student s13 = new Student(12, "joao13", 2);
		Student s14 = new Student(13, "maria14", 2);
		Student s15 = new Student(14, "jose15", 3);
		Student s16 = new Student(15, "joao16", 3);
		Student s17 = new Student(16, "maria17", 3);
		Student s18 = new Student(17, "jose18", 3);
		Student s19 = new Student(18, "joao19", 5);
		Student s20 = new Student(19, "maria20", 3);
		Student s21 = new Student(20, "jose21", 4);
		Student s22 = new Student(21, "joao22", 2);
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
		
		problem = new Problem();
		
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
		
		problem.addExam(e1);
		problem.addExam(e2);
		problem.addExam(e3);
		problem.addExam(e4);
		problem.addExam(e5);
		problem.addExam(e6);
		problem.addExam(e7);
		problem.addExam(e8);
	}

	public void geneticAlgorithm(int days, int iterations, int populationSize, double mutationRate,
			double crossoverRate, int elitismCount){		
		
		problem.setNumberOfDays(days);
				
		Evaluator evaluator = Evaluator.getInstance();
		
		long initialTime = System.currentTimeMillis();
		
		evaluator.createGraph(problem.getExams());		
				
		GeneticAlgorithm ga = new GeneticAlgorithm(iterations, populationSize, mutationRate, crossoverRate, elitismCount, problem);
		
		ga.evalPopulation();
		
		while(!ga.isTerminated()){
			
			ga.crossoverPopulation();
						
			ga.mutatePopulation();
						
			ga.evalPopulation();
			
			ga.updateNumberOfIteration();
			
		}
				
		Individual bestIndividual = ga.getPopulation().getFittest(0);
				
		updateExameDate(problem, bestIndividual);	
		
		long endTime = System.currentTimeMillis();
	
		long duration = (endTime - initialTime); // miliseconds
		
		problem.setDuration(duration);

		
		System.out.println(problem.toString());
		
	}	
			
	public void simulatedAnnealing(int days, int maxIterations, int numRepetitions, double temperature, double minTemperature, 
			double coolingRate, SimulatedAnnealing.TypeOfDecrease typeOfDecrease){
		problem.setNumberOfDays(days);				
		
		Evaluator evaluator = Evaluator.getInstance();		
		
		long initialTime = System.currentTimeMillis();
		
		evaluator.createGraph(problem.getExams());		
	
		SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(problem, maxIterations, numRepetitions, temperature, minTemperature, 
				coolingRate, typeOfDecrease);
		
		simulatedAnnealing.solve();	
		
		for(int i = 0 ; i < problem.getNumberOfExames(); i++){
			int date = simulatedAnnealing.getSolution().get(i);
			problem.getExam(i).setDate(date);
		}

		long endTime = System.currentTimeMillis();
		
		long duration = (endTime - initialTime); // miliseconds
		
		problem.setDuration(duration);
		
		System.out.println(problem);
	}
	
	public void updateExameDate(Problem problem, Individual bestIndividual){		
		ArrayList<Integer[]> aux = Utils.splitChromossome(bestIndividual.getChromossome(), problem.getNumberOfExames());		
		
		for(int i = 0 ; i < problem.getNumberOfExames(); i++){
			int date = Utils.byteToInt(aux.get(i));
			problem.getExam(i).setDate(date);
		}
	}
	
	public Problem getProblem(){
		return problem;
	}
}
