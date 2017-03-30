package algorithm;

import java.util.ArrayList;


public class Population {

	private ArrayList<Individual> individuals;
	private double fitness;
	
	public Population(){
		individuals = new ArrayList<>();
		fitness = -1;
		
	}
	
	public ArrayList<Individual> getIndividuals() {
		return individuals;
	}
	
	
	public double getPopulationFitness(){
		return fitness;
	}
	
	public void setPopulationFitness(double fitness){
		this.fitness = fitness;
	}
	
	
	public Individual getFittest(){
		
		return null;
	}

}
