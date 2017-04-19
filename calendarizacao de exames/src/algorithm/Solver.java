package algorithm;

import java.util.ArrayList;

import logic.Exame;
import logic.Problem;

public class Solver {

	public void geneticAlgorithm(){
		
		// TODO deve ser desenvolvido ciclo do algoritmo para obter a soluçao aqui
		
		
		ArrayList<Exame> exams = new ArrayList<Exame>();
		
		exams.add(new Exame(0,"LBAW",3));
		exams.add(new Exame(1,"LTW",2));
		exams.add(new Exame(2,"SDIS",3));
		exams.add(new Exame(3,"PPIN",3));
		
		Problem problem = new Problem(exams, 32);
		

		GeneticAlgorithm ga = new GeneticAlgorithm(5, 0.5 , 0.4 , problem);
		
		for (int i = 0; i < ga.getPopulation().getIndividuals().size(); i++) {
			ga.calcFitness(ga.getPopulation().getIndividuals().get(i));
		}
		
		ga.evalPopulation();
			
		Individual ind = ga.selectPartent(ga.getPopulation());
		
		System.out.println(ind.toString());
		
		
		
		// debug
		
		/*
		for (int i = 0; i < ga.getPopulation().getIndividuals().size(); i++) {
			System.out.println(ga.getPopulation().getIndividuals().get(i).getFitness());
		}
		
		System.out.println("Fittest " + ga.getPopulation().getFittest(0).getFitness());
	*/	
	}
	
	
	public void simulatedAnnealing(){
		
		// TODO deve ser desenvolvido ciclo do algoritmo para obter a soluçao aqui
		
	}
}
