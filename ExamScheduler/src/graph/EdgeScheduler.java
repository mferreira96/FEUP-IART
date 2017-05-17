package graph;

public class EdgeScheduler {
	
	private VertexScheduler v1;
	private VertexScheduler v2;
	private int diff_year;
	private int same_year;
	
	
	public EdgeScheduler(VertexScheduler v1, VertexScheduler v2, int diff_year, int same_year){
		this.v1 = v1;
		this.v2 = v2;
		this.diff_year = diff_year;
		this.same_year = same_year;
	}
	
	public int getDiff_year() {
		return diff_year;
	}
	
	public int getSame_year() {
		return same_year;
	}
	

	public VertexScheduler getOtherVertex(VertexScheduler v){
	
		if(v.equals(v1))
			return v2;
		else if(v.equals(v2))
			return v1;
		else return null;
	}

	
	public VertexScheduler getV1() {
		return v1;
	}
	
	public VertexScheduler getV2() {
		return v2;
	}
	
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("diff_year = " + diff_year).append("\n");
		sb.append("same_year = " + same_year).append("\n");
		sb.append("v1 = " + getV1().getExamId()).append("\n");
		sb.append("v2 = " + getV2().getExamId()).append("\n");
		
		
		return sb.toString();
	}

}
