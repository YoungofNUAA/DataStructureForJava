package cn.nuaa.Algorithm;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoiTower(3, 'A', 'B', 'C');
	}

	//分治算法
	public static void hanoiTower(int num,char a,char b,char c) {
		if(num==1) {
			System.out.println("第1个盘从"+a+"->"+c);
		}else {
			//看成上面所有的盘和最下面的盘 两个盘     所有上面的从a-b 利用c
			hanoiTower(num-1, a, c, b);
			//最下面的盘a-c
			System.out.println("第"+num+"个盘从"+a+"--->"+c);
			//所有上面的盘从b-c 过程用到a
			hanoiTower(num-1, b, a, c);
		}
	}
}
