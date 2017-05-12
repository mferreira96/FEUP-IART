package graph;

import java.util.ArrayList;


public class GraphScheuler {

	
	private ArrayList<VertexScheduler> nodes;
	private ArrayList<EdgeScheduler> edges;
	
	public GraphScheuler() {
		
		nodes = new ArrayList<VertexScheduler>();
		edges = new ArrayList<EdgeScheduler>();
		
	}
		

	public ArrayList<EdgeScheduler> getEdges() {
		return edges;
	}
	
	public ArrayList<VertexScheduler> getNodes() {
		return nodes;
	}
	
	public void addVertex(VertexScheduler vertex){
		nodes.add(vertex);
	}
	
	public void addEdge(EdgeScheduler edge){
		edges.add(edge);
	}
	
	public void updateAllNodes(ArrayList<Integer> days){
		
		for(int i = 0 ; i < nodes.size(); i++){
			nodes.get(i).setDay(days.get(i));
		}
	}
}
