package cn.nuaa.Algorithm;

import java.util.Arrays;

public class PrimeAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = new char[] {'A','B','C','D','E','F','G'};
		int verx = data.length;
		int[][] weight = new int[][] {{10000,5,7,10000,10000,10000,2},{5,10000,10000,9,10000,10000,3}
		,{7,10000,10000,10000,8,10000,10000},{10000,9,10000,10000,10000,4,10000},{10000,10000,8,10000,10000,5,4}
		,{10000,10000,10000,4,5,10000,6},{2,3,10000,10000,4,6,10000}};
		MGraph graph  = new MGraph(verx);
		MinTree minTree = new MinTree();
		minTree.createGraph(graph, verx, data, weight);
		minTree.showGraph(graph);
		minTree.prim(graph, 0);
	}

}

class MinTree{
	
	public void createGraph(MGraph graph,int verx,char data[],int[][] weight) {
		int i = 0;
		int j = 0;
		for(i=0;i<verx;i++) {
			graph.data[i] = data[i];
			for(j = 0;j<verx;j++) {
				graph.weight[i][j] = weight[i][j];
			}
		}	
	}
	
	public void showGraph(MGraph graph) {
		for(int[] link:graph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//Prime算法
	public void prim(MGraph graph,int v) {
		int visited[] = new int[graph.verx];
		
		//当前节点标记已访问
		visited[v] = 1;
		int h1 = -1;
		int h2 = -1;
		int minWeight = 10000;
		for(int k=1;k<graph.verx;k++) {
			
			//确定每一次生成的子图
			for(int i=0;i<graph.verx;i++) {  //i节点表表示被访问节点
				for(int j=0;j<graph.verx;j++) { //j表示未访问节点
					if(visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minWeight) {
						minWeight = graph.weight[i][j];
						h1 = i;
						h2 = j;
					}
				}
			}
			
			System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值:"+minWeight);
			visited[h2] = 1;
			minWeight = 10000;
		}
	}
}

class MGraph{
	int verx;
	char[] data;
	int[][] weight;
	
	public MGraph(int n) {
		verx = n;
		data = new char[verx];
		weight = new int[verx][verx];
	}
	
}
