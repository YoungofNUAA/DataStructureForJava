package cn.nuaa.recursion;

public class Queen8 {

	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.printf("总共有%d个解法",count);
	}
	
	private void check(int n) {
		if(n==max) {
			print();
			count++;
			return;
		}
		for(int i=0;i<max;i++) {
			//将第n个皇后放在第一列
			array[n] = i;
			if(judge(n)) { //不冲突
				//放n+1个皇后 开始递归
				check(n+1);
			}
		}
	}

	//查看当我们放置第n个皇后，检测该皇后是否和前面已经摆放的皇后冲突
	private boolean judge(int n) {
		for(int i =0;i<n;i++) {
			/*
			 * array[i]==array[n]  是否在同一列
			 * Math.abs(n-i)==Math.abs(array[n]-array[i])  是否在同一斜线
			 */
			if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	//输出皇后在棋盘中的位置
	private void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
}
