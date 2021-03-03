package Graphs;
import java.util.*;

public class Dijkstra {
	
	int minDistance(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for(int i=0;i<distance.length;i++) {
			if(!visited[i] && distance[i] < min) {
				min = distance[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	void dijkstra(int[][] graph, int source) {
		int count = graph.length;
		boolean visited[] = new boolean[count];
		int[] distance = new int[count];
		for(int i=0;i<count;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		for(int i=0;i<count;i++) {
			int u = minDistance(distance, visited);
			visited[u] = true;
			for(int v=0;v<count;v++) {
				if(!visited[v] && graph[u][v]!=0 && distance[v] > distance[u] + graph[u][v]) {
					distance[v] = distance[u] + graph[u][v]; // here graph[u][v] is the vertex edge weight from u to v.
				}											// u is the previous node and v is the present node.
			}												// distance[u] is the distance from source to u. and same for distance[v].
		}
		for (int i = 0; i < distance.length; i++) {
			System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
		}
	}
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
	        { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
	    Dijkstra T = new Dijkstra();
	    T.dijkstra(graph, 0);
	}
}
