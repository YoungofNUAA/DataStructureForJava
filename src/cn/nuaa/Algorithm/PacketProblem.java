package cn.nuaa.Algorithm;

public class PacketProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,4,3};
		int[] val = {1500,3000,2000};
		int m = 4; //背包容量
		int n = val.length;   //物品个数
		
		int[][] v = new int[n+1][m+1];
		int[][] path = new int[n+1][m+1];
		for(int i=0;i<v.length;i++) {
			v[i][0] = 0;
		}
		for(int j=0;j<v[0].length;j++) {
			v[0][j] = 0;
		}
		
		for(int i=1;i<v.length;i++) {
			for(int j=1;j<v[0].length;j++) {
				if(w[i-1]>j) {
					v[i][j] = v[i-1][j];
				}else {
//					v[i][j] = Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
						path[i][j] = 1;
					}else {
						v[i][j]=v[i-1][j];
					}
				}
			}
		}
		
		for(int i=0;i<v.length;i++) {
			for(int j=0;j<v[0].length;j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<path.length;i++) {
			for(int j=0;j<path[0].length;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		int i = path.length-1;
		int j = path[0].length-1;
		while(i>0 && j>0) {
			if(path[i][j]==1) {
				System.out.printf("第%d个商品放入到背包\n",i);
				j = j-w[i-1];
			}
			i--;
		}
	}

}
