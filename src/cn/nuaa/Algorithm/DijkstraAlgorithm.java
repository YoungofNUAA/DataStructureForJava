package cn.nuaa.Algorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {
	
	private static final int INF = 65535;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertxs = new char[] {'A','B','C','D','E','F','G'};
		int[][] matrix = new int[][] {{0,5,7,INF,INF,INF,2},{5,0,INF,9,INF,INF,3}
			,{7,INF,0,INF,8,INF,INF},{INF,9,INF,0,INF,4,INF},{INF,INF,8,INF,0,5,4}
			,{INF,INF,INF,4,5,0,6},{2,3,INF,INF,4,6,0}};
		Graph graph = new Graph(vertxs,matrix);
		graph.showGraph();
		graph.dsj(6);
		graph.showDjs();
	}

}


class Graph{
	char[] vertexs;
	int[][] matrix;
	VisitedVertex vv;
	public Graph(char[] vertx,int[][] matrix) {
		this.vertexs = vertx;
		this.matrix = matrix;
	}
	
	public void showGraph() {
		for(int[] link:matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void dsj(int index) {
		vv = new VisitedVertex(vertexs.length, index);
		update(index);//更新index顶点到周围顶点的距离
		
		for(int j=1;j<vertexs.length;j++) {
			index = vv.updateArr();
			update(index);
		}
	}
	
	public void update(int index) {
		int len = 0;
		for(int i=0;i<matrix[index].length;i++) {
			len = vv.getDis(index)+matrix[index][i];
			//如果j顶点没有被访问过，并且len小于出发顶点啊到j顶点的距离，需要更新
			if(!vv.in(i)&& len<vv.getDis(i)) {
				vv.updatePre(i, index);
				vv.updateDis(i, len);
			}
		}
	}
	
	public void showDjs() {
		vv.show();
	}
	
}

class VisitedVertex{
	public int[] already_arr;
	public int[] pre_visited;
	public int[] dis;
	
	public VisitedVertex(int length,int index) {
		this.already_arr = new int[length];
		this.pre_visited = new int[length];
		this.dis = new int[length];
		Arrays.fill(dis, 65535);
		this.already_arr[index]=1;
		this.dis[index]=0;
	}
	
	/**
	 * 判断index顶点是否访问过
	 * @param index
	 * @return
	 */
	public boolean in(int index) {
		return already_arr[index] == 1;
	}
	
	public void updateDis(int index,int len) {
		dis[index] = len;
	}
	
	public void updatePre(int pre,int index) {
		pre_visited[pre] = index;
	}
	
	/**
	 * 出发顶点到index的顶点的距离
	 * @param index
	 */
	public int getDis(int index) {
		return dis[index];
	}
	
	public int updateArr(){
		int min = 65535;
		int index = 0;
		for(int i=0;i<already_arr.length;i++) {
			if(already_arr[i]==0 && dis[i]<min) {
				min = dis[i];
				index = i;
			}
		}
		already_arr[index] = 1;
		return index;
	}
	
	public void show() {
		System.out.println("*************");
		System.out.println(Arrays.toString(already_arr));
		System.out.println(Arrays.toString(pre_visited));
		System.out.println(Arrays.toString(dis));
	}
}