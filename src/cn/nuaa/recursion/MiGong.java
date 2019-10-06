package cn.nuaa.recursion;
/**
 * �ݹ����Թ�����
 * @author Young
 *
 */
public class MiGong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] map = new int[8][7];
		//ʹ��1��ʾǽ
		for(int i=0;i<7;i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int j=0;j<8;j++) {
			map[j][0] = 1;
			map[j][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		for(int[] row:map) {
			for(int temp:row) {
				System.out.print(temp+" ");
			}
			System.out.println();
		}
		setWay2(map,1,1);
		System.out.println("���Թ�");
		for(int[] row:map) {
			for(int temp:row) {
				System.out.print(temp+" ");
			}
			System.out.println();
		}
	}
	 
	//ʹ�õݹ��������С����·
	//1.map��ʾ��ͼ 2. ij�� ��1,1������ 3.С�򵽴�map[6][5]·ͨ 4.map[][]=0û���߹� =2������ͨ =3��ʾ��λ���Ѿ��߹� �߲�ͨ
	//5.���ԣ�����---���ұ�---���ϱ�----�����
	public static boolean setWay(int[][] map,int i,int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j] = 2; //�ٶ��ĵ������ͨ
				if(setWay(map,i+1,j)) { //���Ÿõ�������
					return true;
				}else if(setWay(map,i,j+1)){
					return true;
				}else if(setWay(map,i-1,j)) {
					return true;
				}else if(setWay(map,i,j-1)){
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
	}
	
	//���ԣ���������
	public static boolean setWay2(int[][] map,int i,int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j] = 2; //�ٶ��ĵ������ͨ
				if(setWay2(map,i-1,j)) { //���Ÿõ�������
					return true;
				}else if(setWay2(map,i,j+1)){
					return true;
				}else if(setWay2(map,i+1,j)) {
					return true;
				}else if(setWay2(map,i,j-1)){
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
	}
	
	
}
