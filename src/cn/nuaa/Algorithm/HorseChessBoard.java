package cn.nuaa.Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {

	private static int X;
	private static int Y;
	private static boolean visited[];
	private static boolean finished;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		X = 8;
		Y = 8;
		int row = 1;
		int colum = 1;
		int[][] chessboard = new int[X][Y];
		visited = new boolean[X*Y];
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard,row-1,colum-1,1);
		long end = System.currentTimeMillis();
		System.out.println("����ʱ"+(end-start)+"ms");
		
		for(int[] rows:chessboard) {
			for(int step:rows) {
				System.out.print(step+"\t");
			}
			System.out.println();
		}
	}
	

	/**
	 * 
	 * @param chessboard
	 * @param row
	 * @param colum
	 * @param step ��ʼΪ1
	 */
	public static void traversalChessboard(int[][] chessboard,int row,int colum,int step) {
		chessboard[row][colum] = step;
		visited[row*X+colum] = true;
		ArrayList<Point> ps = next(new Point(colum,row));
		//��ps��������
		//sort(ps);
		
		while(!ps.isEmpty()) {
			Point p = ps.remove(0);//ȡ����һ�������ߵĵ�
			if(!visited[p.y*X+p.x]) {//û�б�����
				traversalChessboard(chessboard,p.y,p.x,step+1);
			}
		}
		if(step<X*Y && !finished) {//��û����
			chessboard[row][colum] = 0;
			visited[row*X+colum] = false;
		}else {
			finished = true;
		}
	}
	
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps = new ArrayList<Point>();
		Point p1 = new Point();
		//�������5
		if((p1.x = curPoint.x-2)>=0 && (p1.y = curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		//�������6
		if((p1.x = curPoint.x-1)>=0 && (p1.y = curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		//�������7
		if((p1.x = curPoint.x+1)<X && (p1.y = curPoint.y-2)>=0) {
			ps.add(new Point(p1));
		}
		//�������0
		if((p1.x = curPoint.x+2)<X && (p1.y = curPoint.y-1)>=0) {
			ps.add(new Point(p1));
		}
		//�������1
		if((p1.x = curPoint.x+2)<X && (p1.y = curPoint.y+1)<Y) {
			ps.add(new Point(p1));
		}
		//�������2
		if((p1.x = curPoint.x+1)<X && (p1.y = curPoint.y+2)<Y) {
			ps.add(new Point(p1));
		}
		//�������3
		if((p1.x = curPoint.x-1)>=0 && (p1.y = curPoint.y+2)<Y) {
			ps.add(new Point(p1));
		}
		//�������4
		if((p1.x = curPoint.x-2)>=0 && (p1.y = curPoint.y+1)<Y) {
			ps.add(new Point(p1));
		}
		return ps;
	}
	
	//���ݵ�ǰ�ⲽ��������һ����ѡ��λ�� ���зǵݼ�����
	public static void sort(ArrayList<Point>ps) {
		ps.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				int count1 = next(o1).size();
				int count2 = next(o2).size();
				if(count1<count2) {
					return -1;
				}else if(count1==count2) {
					return 0;
				}else{
					return 1;
				}
			}
		});
	}
}
