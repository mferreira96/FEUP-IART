package algorithm;

import java.util.ArrayList;

import logic.Problem;
import logic.Student;

public class SimulatedAnnealing {

	public void solve(){

	}

	// TODO - IMPLEMENTAR
	public void generateInitialState(){

	}

	// TODO - IMPLEMENTAR - gera novo estado da configuraçao
	public void generateState(){

	}

	// TODO - IMPLEMENATAR - atualiza temperatur consoante metoo escolhido
	// multiplicativo ou subtrativo
	public void coolingSchedule(){

	}

	// TODO - IMPLEMENTAR
	public static int objectiveFunction(Problem problem){		
		int value = 0;

		// TODO - CORRIGIR
		value = value + calculateDaysBetweenExams(problem.getStudents())
					  - calculateSameDayExams(problem.getStudents())
					  - calculateConsecutiveExams(problem.getStudents());



		return value;
	}

	// TODO - CORRIGR/REMOVER/MELHORAR
	public static int calculateDaysBetweenExams(ArrayList<Student> students){
		int sum = 0;

		for (Student student: students){
			for(int i = 0; i < student.getExams().size(); i++){
				int w = student.getExams().get(i).getDate();
				for(int j = i; j < student.getExams().size(); j++){
					int z = student.getExams().get(j).getDate();
					
					// TODO -ALTERAR FATORES EM USO??
					if(student.hasDisciplinesToDo())
						sum += Math.abs(z-w);
					else
						sum += 2 * Math.abs(z-w);
				}
			}				
		}

		return sum;
	}

	// TODO - CORRIGIR/MELHORAR
	public static int calculateSameDayExams(ArrayList<Student> students){
		int sum = 0;

		outerLoop:
		for (Student student: students){
			for(int i = 0; i < student.getExams().size(); i++){
				int w = student.getExams().get(i).getDate();
				for(int j = i; j < student.getExams().size(); j++){
					int z = student.getExams().get(j).getDate();
					if((z-w) == 0){
						/* Verifies if 2 exams are from same year */
						if(student.getExams().get(i).getYear() == student.getExams().get(j).getYear())
							sum += 4;
						else
							sum += 3;
						
						break outerLoop;
					}
				}						
			}				
		}

		return sum;
	}

	// TODO - CORRIGIR/MELHORAR
	public static int calculateConsecutiveExams(ArrayList<Student> students){
		int sum = 0;

		outerLoop:
		for (Student student: students){
			for(int i = 0; i < student.getExams().size(); i++){
				int w = student.getExams().get(i).getDate();
				for(int j = i; j < student.getExams().size(); j++){
					int z = student.getExams().get(j).getDate();
					if(Math.abs(z-w) == 1){
						/* Verifies if 2 exams are from same year */
						if(student.getExams().get(i).getYear() == student.getExams().get(j).getYear())
							sum += 4;
						else
							sum += 3;
						
						break outerLoop;
					}						
				}
			}				
		}

		return sum;
	}
}
