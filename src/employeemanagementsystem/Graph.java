package employeemanagementsystem;

public class Graph {

	private int arr[][];
	private int vertexNum;

	public Graph(int v) {
		arr = new int[v][v];// Initializes the graph,rows and columns.
		vertexNum = v;
	}

	public void addEdge(int source, int dest, int weight) {
		arr[source][dest] = weight;
		// assign the edges wieght

	}

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}

	public int getVertexNum() {
		return vertexNum;
	}

	public void setVertexNum(int vertexNum) {
		this.vertexNum = vertexNum;
	}


	}




