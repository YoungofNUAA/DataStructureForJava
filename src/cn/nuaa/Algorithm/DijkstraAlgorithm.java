package cn.nuaa.Algorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {
	
	private static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertxs = new char[] {'A','B','C','D','E','F','G'};
		int[][] matrix = new int[][] {{0,5,7,INF,INF,INF,2},{5,0,INF,9,INF,INF,3}
			,{7,INF,0,INF,8,INF,INF},{INF,9,INF,0,INF,4,INF},{INF,INF,8,INF,0,5,4}
			,{INF,INF,INF,4,5,0,6},{2,3,INF,INF,4,6,0}};
		Graph graph = new Graph(vertxs,matrix);
		graph.showGraph();
	}

}


class Graph{
	char[] vertexs;
	int[][] matrix;
	
	public Graph(char[] vertx,int[][] matrix) {
		this.vertexs = vertx;
		this.matrix = matrix;
	}
	
	public void showGraph() {
		for(int[] link:matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
}