package cn.nuaa.Algorithm;

import java.util.Arrays;

public class FloydAlgorithm {

	private static final int INF = 65535;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertxs = new char[] {'A','B','C','D','E','F','G'};
		int[][] matrix = new int[][] {{0,5,7,INF,INF,INF,2},{5,0,INF,9,INF,INF,3}
			,{7,INF,0,INF,8,INF,INF},{INF,9,INF,0,INF,4,INF},{INF,INF,8,INF,0,5,4}
			,{INF,INF,INF,4,5,0,6},{2,3,INF,INF,4,6,0}};
		Graph_F g = new Graph_F(7,matrix,vertxs);
		g.floyd();
		g.show();
	}

}

class Graph_F{
	private char[] vertex;
	private int[][] dis;
	private int[][] pre;
	
	public Graph_F(int len,int[][] matrix,char[] vertex) {
		this.vertex = vertex;
		this.dis = matrix;
		this.pre = new int[len][len];
		for(int i =0;i<len;i++) {
			Arrays.fill(pre[i], i);
		}
	}
	
	public void show() {
		for(int k = 0;k<dis.length;k++) {
			for(int i=0;i<dis.length;i++) {
				System.out.print(pre[k][i]+" ");
			}
			
			System.out.println();
			for(int i=0;i<dis.length;i++) {
				System.out.print(dis[k][i]+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	public void floyd() {
		int len = 0;
		//对中间顶点进行遍历
		for(int k = 0;k<dis.length;k++) {
			for(int i=0;i<dis.length;i++) {
				for(int j=0;j<dis.length;j++) {
					len = dis[i][k]+dis[k][j];
					if(len<dis[i][j]) {
						dis[i][j] = len;
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
	}
}
