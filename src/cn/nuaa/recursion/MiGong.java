package cn.nuaa.recursion;
/**
 * 递归解决迷宫问题
 * @author Young
 *
 */
public class MiGong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] map = new int[8][7];
		//使用1表示墙
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
		System.out.println("走迷宫");
		for(int[] row:map) {
			for(int temp:row) {
				System.out.print(temp+" ");
			}
			System.out.println();
		}
	}
	 
	//使用递归回溯来给小球找路
	//1.map表示地图 2. ij从 （1,1）出发 3.小球到达map[6][5]路通 4.map[][]=0没有走过 =2可以走通 =3表示该位置已经走过 走不通
	//5.策略：下面---》右边---》上边----》左边
	public static boolean setWay(int[][] map,int i,int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j] = 2; //假定改点可以走通
				if(setWay(map,i+1,j)) { //沿着该点向下走
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
	
	//策略：上右下左
	public static boolean setWay2(int[][] map,int i,int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j] = 2; //假定改点可以走通
				if(setWay2(map,i-1,j)) { //沿着该点向上走
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
