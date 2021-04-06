package Graphs;

public class Prims {

	void prims(int[][] graph, int vertices) {
		int count = graph.length;
		boolean visited[] = new boolean[count];
		visited[0] = true;
		int edges = 0;
		while(edges<count-1) {
			int x = 0, y = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<count;i++) {
				if(visited[i]) {
					for(int j=0;j<count;j++) {
						if(!visited[j] && graph[i][j]!=0) {
							if(min>graph[i][j]) {
								min = graph[i][j];
								x = i;
								y = j;
							}
						}
					}
				}
			}
			edges++;
			min = Integer.MAX_VALUE;
			System.out.println(x + " - " + y + " :  " + graph[x][y]);
			visited[y] = true;
		}
	}
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
	        { 0, 42, 66, 31, 0 } };
	    Prims P = new Prims();
	    P.prims(graph, 5);
	}
}