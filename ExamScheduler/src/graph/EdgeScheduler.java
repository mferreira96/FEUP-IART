package graph;

public class EdgeScheduler {
	
	private VertexScheduler to;
	private VertexScheduler from;
	private int diff_year;
	private int same_year;
	
	
	public EdgeScheduler(VertexScheduler to, VertexScheduler from, int diff_year, int same_year){
		this.to = to;
		this.from = from;
		this.diff_year = diff_year;
		this.same_year = same_year;
	}
	
	public int getDiff_year() {
		return diff_year;
	}
	
	public int getSame_year() {
		return same_year;
	}
	

	public VertexScheduler getSource() {
		
		return from;
	}

	public VertexScheduler getTarget() {
		
		return to;
	}


	public void setSource(VertexScheduler from) {
		this.from= from; 
		
	}

	public void setTarget(VertexScheduler to) {
		this.to = to;
		
	}
	
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("diff_year = " + diff_year).append("\n");
		sb.append("same_year = " + same_year).append("\n");
		sb.append("from = " + getSource().getExamId()).append("\n");
		sb.append("target = " + getTarget().getExamId()).append("\n");
		
		
		return sb.toString();
	}

}
