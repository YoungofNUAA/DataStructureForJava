package cn.nuaa.Algorithm;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoiTower(3, 'A', 'B', 'C');
	}

	//�����㷨
	public static void hanoiTower(int num,char a,char b,char c) {
		if(num==1) {
			System.out.println("��1���̴�"+a+"->"+c);
		}else {
			//�����������е��̺���������� ������     ��������Ĵ�a-b ����c
			hanoiTower(num-1, a, c, b);
			//���������a-c
			System.out.println("��"+num+"���̴�"+a+"--->"+c);
			//����������̴�b-c �����õ�a
			hanoiTower(num-1, b, a, c);
		}
	}
}
