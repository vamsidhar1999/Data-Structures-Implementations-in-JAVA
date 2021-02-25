package Graphs;
import java.util.*;

public class Graph_DFS {
	
	LinkedList<Integer> adjLists[];
	boolean visited[];
	
	Graph_DFS(int vertices) {
		adjLists = new LinkedList[vertices]; // initializing the array with total number of vertices.
		visited = new boolean[vertices];
		
		for(int i=0;i<vertices;i++) {
			adjLists[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v1, int v2) {
		adjLists[v1].add(v2);
		adjLists[v2].add(v1);
	}
	
	void dfs(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		System.out.print(v+" -> ");
		Iterator<Integer> ite = adjLists[v].listIterator();
		while(ite.hasNext()) {
			dfs(ite.next());
		}
	}
	
	public static void main(String args[]) {
		Graph_DFS graph = new Graph_DFS(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		
		graph.dfs(0);
	}
}
