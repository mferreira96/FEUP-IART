package graph;

import java.util.ArrayList;
import java.util.LinkedList;

import logic.Exam;

public class VertexScheduler {

	private int day;
	private ArrayList<EdgeScheduler> adjs;
	private Exam exam;
	private Boolean colored;
	
	public VertexScheduler(Exam exam, int day){
		this.exam =	exam;
		this.day = day;
		this.adjs = new ArrayList<EdgeScheduler>();
		this.colored = false;
	}
	
	public ArrayList<EdgeScheduler> getAdjs() {
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

	public Boolean getColored() {
		return colored;
	}
	
	public void setColored(Boolean flag){
		this.colored = flag;
	}
	
	public int numberOfConnections(){
		return this.adjs.size();
	}
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		sb.append(getExam().toString()).append("\n");
		sb.append("day = " + day).append("\n");
		sb.append("connections = " + this.adjs.size()).append("\n");
		sb.append("colored = " + this.colored).append("\n");
		
		
		return sb.toString();
	}
}
