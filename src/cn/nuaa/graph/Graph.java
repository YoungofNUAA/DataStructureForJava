package cn.nuaa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

	public ArrayList<String> vertextList;
	public int[][] edges;
	public int numOfEdges;
	//是否被访问过
	private boolean[] isVisited ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String VertextValue[] = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		for(String ver:VertextValue) {
			graph.insertVertext(ver);
		}
		graph.inserEdge(0, 1, 1);
		graph.inserEdge(0, 2, 1);
		graph.inserEdge(1, 2, 1);
		graph.inserEdge(1, 3, 1);
		graph.inserEdge(1, 4, 1);
		graph.showGraph();
		
		//DFS
//		System.out.println("DFS");
//		graph.dfs();
//		System.out.println();
		
		System.out.println("BFS");
		graph.bfs();
	}
	
	public Graph(int n) {
		edges  = new int[n][n];
		vertextList = new ArrayList<String>(n);
		isVisited = new boolean[n];
		numOfEdges = 0;
		
	}
	//得到第一个邻接节点的下标
	public int getFirstNeighbor(int index) {
		for(int j=0;j<vertextList.size();j++) {
			if(edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	//根据前一节点的下标获取下一个邻接节点
	public int getNextNeighbor(int v1,int v2) {
		for(int j=v2+1;j<vertextList.size();j++) {
			if(edges[v1][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//深度优先遍历
	public void dfs(boolean[] isVisited,int i) {
		System.out.print(getValByIndex(i)+"-->");
		isVisited[i] = true;
		
		int w = getFirstNeighbor(i);
		while(w!=-1) {
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			//w存在且被访问过 查找节点v的w邻接节点的下一个邻接节点
			w = getNextNeighbor(i, w);
		}
	}
	//重载dfs
	public void dfs() {
		for(int i=0;i<vertextList.size();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}
	//对一个节点的广度优先方法
	public void bfs(boolean[] isVisited,int i) {
		int u;//队列的头结点的对应的下标
		int w;//邻接节点w
		//队列
		LinkedList queue = new LinkedList();
		System.out.print(getValByIndex(i)+"-->");
		isVisited[i] = true;
		queue.addLast(i);
		
		while(!queue.isEmpty()) {
			u = (Integer)queue.removeFirst();
			w = getFirstNeighbor(u);
			while(w!=-1) {
				if(!isVisited[w]) {
					System.out.print(getValByIndex(w)+"-->");
					isVisited[w] = true;
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);//体现广度优先
			}
		}
	}
	//我觉得这个函数有点多余 可以实现从不同的顶点进行广度遍历--young
	public void bfs() {
		for(int i=0;i<vertextList.size();i++) {
			if(!isVisited[i]) {
				bfs(isVisited,i);
				System.out.println("test");
			}
		}
	}
	
	public int getNumOfVertex() {
		return vertextList.size();
	}
	public int getNumOfEdges() {
		return numOfEdges;
	}
	public String getValByIndex(int n) {
		return vertextList.get(n);
	}
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//显示图对应的矩阵
	public void showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	public void insertVertext(String value) {
		vertextList.add(value);
	}
	/**
	 * 
	 * @param v1 顶点下标值 从0开始
	 * @param v2
	 * @param weight
	 */
	public void inserEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}
