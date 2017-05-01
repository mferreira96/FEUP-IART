package algorithm;

import java.util.HashMap;

public class SimulatedAnnealing {

	// TODO - IMPLEMENTAR - gera novo estado da configuraçao
	public void generateState(){

	}

	// TODO - IMPLEMENATAR - atualiza temperatur consoante metoo escolhido
	// multiplicativo ou subtrativo
	public void coolingSchedule(){

	}

	// TODO - CORRIGR/REMOVER
	public static int getDiff(HashMap map, int numExams){

		int sum = 0;

		for(int i = 0; i < numExams; i++){
			int w = (int) map.get(i);
			for(int j = i; j < numExams; j++){
				int z = (int) map.get(j);
				sum = sum + Math.abs(z-w);
			}
		}
				
		return sum;
	}

}
