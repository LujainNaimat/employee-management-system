package employeemanagementsystem;

public class Bellman {

	private Graph graph;

	public Bellman(Graph g) {
		this.graph = g;
	}

	public void BellmanFord(int s, int d) {
		int vertex = graph.getVertexNum();/* stores num of vertex */
		if (s < 0 || s >= vertex || d < 0 || d >= vertex) {// checks if the source and destination vertex are in the
															// graph
			throw new IllegalArgumentException("vertex is invalid");

		}
		int[] distance = new int[vertex];
		int[] parent = new int[vertex];
		int arr[][] = graph.getArr();
		for (int i = 0; i < vertex; i++) {
			distance[i] = Integer.MAX_VALUE;// the value of unreached distance
			parent[i] = -1;
		}
		distance[s] = 0;// source point distance=0
		// relaxation of edges
		for (int i = 0; i < vertex - 1; i++) {
			for (int j = 0; j < vertex; j++) {
				for (int k = 0; k < vertex; k++) {
					if (arr[j][k] != 0 && distance[j] != Integer.MAX_VALUE) {
						if (distance[j] + arr[j][k] < distance[k]) {
							distance[k] = distance[j] + arr[j][k];// distance till each vertex
							parent[k] = j;
						}
					}
				}
			}
		}
		// one more pass: if any distance still gets shorter, the graph has a
		// negative-weight cycle and no shortest path exists
		for (int j = 0; j < vertex; j++) {
			for (int k = 0; k < vertex; k++) {
				if (arr[j][k] != 0 && distance[j] != Integer.MAX_VALUE && distance[j] + arr[j][k] < distance[k]) {
					throw new IllegalArgumentException("graph contains a negative-weight cycle");
				}
			}
		}
		if (distance[d] == Integer.MAX_VALUE) {
			throw new IllegalArgumentException("no path exists");
		}
		System.out.println("shortest distance=" + distance[d] + "\nshortest path:");
		printPath(parent, d);
		System.out.println();
	}

	public void printPath(int[] parent, int vertex) {
		if (vertex == -1) {
			return;
		}
		printPath(parent, parent[vertex]);

		System.out.print(vertex+" ");

	}
}


