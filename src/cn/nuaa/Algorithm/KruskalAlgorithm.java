package cn.nuaa.Algorithm;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class KruskalAlgorithm {
	private int edgeNum;
	private char[] vertxs;
	private int[][] matrix;
	private static final int INF = Integer.MAX_VALUE;

	public KruskalAlgorithm(char[] vertxs,int[][]matrix) {
		int len = vertxs.length;
		this.vertxs = new char[len];
		for(int i=0;i<len;i++) {
			this.vertxs[i] = vertxs[i];
		}
		
		this.matrix = new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(this.matrix[i][j]!=INF) {
					edgeNum++;
				}
			}
		}
		
		for(int[] m:matrix) {
			System.out.println(Arrays.toString(m));
		}
	}
	//对边进行排序
	private void sortEdges(EData[] edges) {
		
		for(int i=0;i<edges.length-1;i++) {
			boolean isSort = true;
			for(int j=0;j<edges.length-1-i;j++) {
				if(edges[j].weight>edges[j+1].weight) {
					EData temp;
					temp = edges[j];
					edges[j] = edges[j+1];
					edges[j+1] = temp;
					isSort = false;
				}
			}
			if(isSort) {
				return;
			}
		}
	}
	
	/**
	 * 
	 * @param ch 顶点
	 * @return
	 */
	private int getPosition(char ch) {
		for(int i=0;i<vertxs.length;i++) {
			if(vertxs[i]==ch) {
				return i;
			}
		}
		return -1;
	}
	
	private EData[] getEdges() {
		int index = 0;
		EData[] edata = new EData[edgeNum];
		for(int i=0;i<vertxs.length;i++) {
			for(int j=i+1;j<vertxs.length;j++) {
				if(matrix[i][j]!=INF) {
					edata[index++] = new EData(vertxs[i],vertxs[j],matrix[i][j]);
				}
			}
		}
		return edata;
	}
	//获取下标为i的终点
	/**
	 * 
	 * @param ends 记录各个顶点对应的终点
	 * @param i 传入的顶点对应的下标
	 * @return  
	 */
	private int getEnd(int[] ends,int i) {
		while(ends[i]!=0) {
			i = ends[i];
		}
		return i;
	}
	
	private void kruskal() {
		int index = 0;
		int[] ends = new int[edgeNum]; //保存已有最小生成树顶点 在最小生成树的终点
		EData[] results = new EData[edgeNum];
		EData[] edges = getEdges();
		
		sortEdges(edges);
		for(int i=0;i<edgeNum;i++) {
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			
			int m = getEnd(ends,p1);
			int n = getEnd(ends,p2);
			if(m!=n) {
				ends[m] = n;  //设置m在已有最小生成树中的终点<E,F>[0,0,0,0,5,0,0,0,0,0,0,0,0] 下标为4 的顶点对应的终点为5 即E对应的终点为F
				results[index++] = edges[i];
			}
		}
		System.out.println(Arrays.toString(results));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertxs = new char[] {'A','B','C','D','E','F','G'};
		int[][] matrix = new int[][] {{0,5,7,INF,INF,INF,2},{5,0,INF,9,INF,INF,3}
			,{7,INF,0,INF,8,INF,INF},{INF,9,INF,0,INF,4,INF},{INF,INF,8,INF,0,5,4}
			,{INF,INF,INF,4,5,0,6},{2,3,INF,INF,4,6,0}};
		KruskalAlgorithm demo = new KruskalAlgorithm(vertxs,matrix);
		
		EData[] edges = demo.getEdges();
		System.out.println(Arrays.toString(edges));
		demo.sortEdges(edges);
		System.out.println(Arrays.toString(edges));
		demo.kruskal();
	}
}

//创建边的实例
class EData{
	char start;
	char end;
	int weight;
	
	public EData(char start,char end,int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}
}
