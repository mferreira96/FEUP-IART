package algorithm;

import java.util.ArrayList;

import logic.Problem;
import utils.Utils;

public class GeneticAlgorithm {
	
	// TODO - see the correct parameters...
	
	
	private final int MAX_ITERATIONS;	
	private final double MUTATION_RATE;
	private final double CROSSOVER_RATE;
	private final double ELITISM_COUNT;
	private final int POPULATION_SIZE;
	private Population population;
	private Problem problem;
	private int chromossomeSize;
	private int numberOfIteration;

	
	public GeneticAlgorithm(int iterations,int population_size, double mutation_rate, double crossover_rate, double elitism_count, Problem problem){
		this.MAX_ITERATIONS = iterations;
		this.MUTATION_RATE = mutation_rate;
		this.CROSSOVER_RATE = crossover_rate;
		this.ELITISM_COUNT = elitism_count;
		this.POPULATION_SIZE = population_size;
		
		this.problem = problem;		
		this.chromossomeSize = Utils.getNumberOfbitsNeeded(this.problem.getNumberOfDays()) * problem.getNumberOfExames();		
		this.population = new Population(this.POPULATION_SIZE,this.chromossomeSize);		
		this.numberOfIteration= 0;
	}
	
	public void setPopulation(Population population){
		this.population = population;
	}
	
	public Problem getProblem(){
		return problem;
	}
	
	public int getChromossomeSize() {
		return chromossomeSize;
	}
	
	public double getCROSSOVER_RATE() {
		return CROSSOVER_RATE;
	}
	
	public int getMAX_ITERATIONS() {
		return MAX_ITERATIONS;
	}
	
	public double getMUTATION_RATE() {
		return MUTATION_RATE;
	}
	
	public double getELITISM_COUNT() {
		return ELITISM_COUNT;
	}
	
	public int getPOPULATION_SIZE() {
		return POPULATION_SIZE;
	}
	
	public Population getPopulation(){
		return population;
	}
	
	public int getNumberOfIteration(){
		return numberOfIteration;
	}
	
	public void updateNumberOfIteration(){
		numberOfIteration++;
	}
	
	public void evalPopulation(){		
		double fitness = 0;
		
		for(int i = 0;  i< population.getIndividuals().size();i++){
			double fit = calcFitness(population.getIndividuals().get(i));
			fitness += fit;
		}
		
		population.setPopulationFitness(fitness);
	}
	
	public double calcFitness(Individual ind){		
		Evaluator evaluator = Evaluator.getInstance();
		
		double fit = evaluator.calculateFitness(ind, this.problem);
		ind.setFitness(fit);
		
		return fit;
	}
	
	public void mutatePopulation() {
		Population population = this.getPopulation();
		
		int totalBits = (int) ((population.getPopulationSize() - this.getELITISM_COUNT()) * this.chromossomeSize);
	
		for (int i = 0; i < totalBits; i++) {
			double f = Math.random();
			if (f < this.getMUTATION_RATE()) {
				population.getIndividuals().get(i / this.chromossomeSize).mutation(i % this.chromossomeSize);
			}
		}
	}
	
	
	// TODO - rever possivelmente dividir o  numero crossover para metade....
	
	public void crossoverPopulation(){
		Population population = this.getPopulation();
		
		Population nPopulation = new Population(this.POPULATION_SIZE);
		
		for(int i = 0 ; i < this.POPULATION_SIZE; i++){			
			Individual p1 = population.getFittest(i);				
			
			if(this.CROSSOVER_RATE > Math.random()){				
				Individual newInd = new Individual(this.chromossomeSize);				
				Individual p2 = this.selectParent(population);				
				int breakIndex = (int)Math.random() * this.chromossomeSize;	
				
				for(int j = 0; j < this.chromossomeSize; j++){					
					if(j < breakIndex){
						newInd.setGene(j, p1.getGene(j));
					}else{
						newInd.setGene(j, p2.getGene(j));
					}
				}
				
				nPopulation.addIndividual(newInd);
			}else{
				nPopulation.addIndividual(p1);
			}			
		}		
		
		this.setPopulation(nPopulation);	
	}
	
	public boolean isTerminated(){		
		if(this.getNumberOfIteration() > this.getMAX_ITERATIONS())
			return true;
		else
			return false;
	}
	
	public Individual selectParent(Population population){		
		
		// should be already ordered
		ArrayList<Individual> individuals = population.getIndividuals();
		
		individuals.sort(null);
		
		double rouletPosition = Math.random() * population.getPopulationFitness();
		//System.out.println("population fitness = " + population.getPopulationFitness());
		//System.out.println("random position = " + rouletPosition);
		
		double counter = 0 ;
		
		for(int i = 0 ; i < individuals.size(); i++){
			counter += individuals.get(i).getFitness();
			//System.out.println(counter + " .......  " + individuals.get(i).getFitness() );
			if(counter >= rouletPosition)
				return individuals.get(i);
			
		}
		
		return null;
	}
	
}
