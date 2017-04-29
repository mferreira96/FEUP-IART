package algorithm;

import java.util.ArrayList;

public class Population {

	private ArrayList<Individual> individuals;
	private double fitness;
	private int populationSize;
	
	
	public Population(int populationSize, int cromossomeLength){
		this.individuals = new ArrayList<Individual>();
		this.fitness = -1;
		this.populationSize = populationSize;

		
		initiatePopulation(this.populationSize, cromossomeLength);
	
	}	
	
	public Population(int populationSize){		
		this.individuals = new ArrayList<Individual>();
		this.fitness = -1;
		this.populationSize = populationSize;		
	}
	
	public void initiatePopulation(int populationSize, int chromossomeLength){
	
		for (int i = 0; i < populationSize; i++) {
			
			addIndividual(new Individual(chromossomeLength));
		}	
	}
	
	public ArrayList<Individual> getIndividuals() {
		return individuals;
	}
	
	public void addIndividual(Individual ind){
		individuals.add(ind);
	}	
	
	public double getPopulationFitness(){
		return fitness;
	}	
	
	public int getPopulationSize() {
		return populationSize;
	}	
	
	public void setPopulationFitness(double fitness){
		this.fitness = fitness;
	}	
	
	public Individual getFittest(int index){		
		this.getIndividuals().sort(null);
		
		return individuals.get(index);
	}
	
	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		
		for(int  i = 0 ; i < this.getPopulationSize() ; i++){
			sb.append(this.getIndividuals().get(i).toString());
		}		
		
		sb.append("------------------------------------------------------------------------------------------ \n");
		
		return sb.toString();
	}
}
