package cn.nuaa.search;

import java.util.Arrays;

public class FibonacciSearch {

	public static int maxSize = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,10,89,1000,1234};
		System.out.println(fibSearch(arr,8));
	}

	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i=2;i<maxSize;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		return f;
	}
	
	//�����㷨  �ǵݹ�
	public static int fibSearch(int[] a,int key) {
		int low = 0;
		int high = a.length-1;
		int k = 0;   //�ָ���ֵ��Ӧ���±�
		int mid = 0;
		int[] f = fib();
		
		while(high>f[k]-1) {
			k++;
		}
		int[] temp = Arrays.copyOf(a, f[k]);
		//temp={1,8,10,89,1000,1234,0,0,0}---{1,8,10,89,1000,1234,1234,1234,1234}
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=a[high];
		}
		
		//ʹ��whileѭ������  �ҵ�key
		while(low<=high) {
			mid = low+f[k-1]-1;
			if(key<temp[mid]) {
				high = mid-1;
				//1.ȫ��Ԫ��=ǰ���Ԫ��+��ߵ�Ԫ��
				//2.f[k] = f[k-1]+f[k-2];
				k--;
			}else if(key>temp[mid]){
				low = mid+1;
				// 1.ȫ��Ԫ��=ǰ���Ԫ��+��ߵ�Ԫ��
				// 2.f[k] = f[k-1]+f[k-2];
				// 3.��Ϊ������f[k-2] f[k-1]=f[k-3]+f[k-4]
				// 4.����f[k-2]��ǰ����в���k-=2
				// 5.���´�ѭ�� mid=f[k-1-2]-1
				k-=2;
			}else {
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
