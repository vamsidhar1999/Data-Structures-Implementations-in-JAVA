package Graphs;
import java.util.*;

public class Graph_BFS {
	
	LinkedList<Integer> adjLists[];
	boolean visited[];
	
	Graph_BFS(int vertices){
		adjLists = new LinkedList[vertices];
		visited = new boolean[vertices];
		
		for(int i=0;i<vertices;i++) {
			adjLists[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdje(int v1, int v2) {
		adjLists[v1].add(v2);
		adjLists[v2].add(v1);
	}
	
	Queue<Integer> queue = new LinkedList<>();
	void bfs(int v) {
		
		LinkedList<Integer> queue = new LinkedList();

	    visited[v] = true;
	    queue.add(v);

	    while (queue.size() != 0) {
	      v = queue.poll();
	      System.out.print(v + "->");

	      Iterator<Integer> i = adjLists[v].listIterator();
	      while (i.hasNext()) {
	        int n = i.next();
	        if (!visited[n]) {
	          visited[n] = true;
	          queue.add(n);
	        }
	      }
	    }
		
//		if(visited[v]){
//			return;
//		}
//		Iterator<Integer> ite = adjLists[v].iterator();
//		while(ite.hasNext()) {
//			int adj = ite.next();
//			queue.add(adj);
//		}
//		visited[v] = true;
//		System.out.print(v+" -> ");
//		int temp = queue.poll();
//		bfs(temp);
//		for(int i=0;i<queue.size();i++) {
//			bfs(queue.poll());
//		}
	}
	
	public static void main(String[] args) {
		Graph_BFS graph = new Graph_BFS(7);
		graph.addEdje(0, 1);
		graph.addEdje(0, 3);
		graph.addEdje(1, 2);
		graph.addEdje(1, 3);
		graph.addEdje(1, 5);
		graph.addEdje(1, 6);
		graph.addEdje(2, 4);
		graph.addEdje(2, 5);
		graph.addEdje(4, 6);
		
		graph.bfs(0);
	}
}
