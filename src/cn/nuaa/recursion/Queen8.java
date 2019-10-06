package cn.nuaa.recursion;

public class Queen8 {

	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.printf("�ܹ���%d���ⷨ",count);
	}
	
	private void check(int n) {
		if(n==max) {
			print();
			count++;
			return;
		}
		for(int i=0;i<max;i++) {
			//����n���ʺ���ڵ�һ��
			array[n] = i;
			if(judge(n)) { //����ͻ
				//��n+1���ʺ� ��ʼ�ݹ�
				check(n+1);
			}
		}
	}

	//�鿴�����Ƿ��õ�n���ʺ󣬼��ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	private boolean judge(int n) {
		for(int i =0;i<n;i++) {
			/*
			 * array[i]==array[n]  �Ƿ���ͬһ��
			 * Math.abs(n-i)==Math.abs(array[n]-array[i])  �Ƿ���ͬһб��
			 */
			if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	//����ʺ��������е�λ��
	private void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
}
