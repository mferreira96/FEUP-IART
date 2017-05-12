package graph;

import java.util.LinkedList;

import logic.Exam;

public class VertexScheduler {

	private int day;
	private LinkedList<EdgeScheduler> adjs;
	private Exam exam;
	
	public VertexScheduler(Exam exam, int day){
		this.exam =	exam;
		this.day = day;
		this.adjs = new LinkedList<EdgeScheduler>();
	}
	
	public LinkedList<EdgeScheduler> getAdjs() {
		return adjs;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getExamId() {
		return this.exam.getId();
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public Exam getExam() {
		return exam;
	}
	
	public void addAdjs(EdgeScheduler edge){
		this.adjs.add(edge);
	}

	
}
