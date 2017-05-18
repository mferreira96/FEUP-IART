package graph;

import java.util.ArrayList;


public class GraphScheduler {

	
	private ArrayList<VertexScheduler> nodes;
	private ArrayList<EdgeScheduler> edges;
	private Integer edgeId;
	
	
	public GraphScheduler() {
		
		nodes = new ArrayList<VertexScheduler>();
		edges = new ArrayList<EdgeScheduler>();
		edgeId = -1;
	}
		

	public ArrayList<EdgeScheduler> getEdges() {
		return edges;
	}
	
	public ArrayList<VertexScheduler> getNodes() {
		return nodes;
	}
	
	public EdgeScheduler getEdge(int i){
		return this.edges.get(i);
	}
	
	public void addVertex(VertexScheduler vertex){
		nodes.add(vertex);
	}
	
	public int addEdge(EdgeScheduler edge){
		edges.add(edge);
		edgeId++;
		return edgeId;
	}
	
	public void updateAllNodes(ArrayList<Integer> days){
		
		for(int i = 0 ; i < nodes.size(); i++){
			nodes.get(i).setDay(days.get(i));
		}
	}
	
	public void updateUnColored(){
		
		for(int i = 0 ; i < nodes.size(); i++){
			nodes.get(i).setColored(false);
		}
	}
}
