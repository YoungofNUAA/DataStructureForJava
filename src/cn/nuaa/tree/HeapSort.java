package cn.nuaa.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,6,8,5,9};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		int temp = 0;
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		for(int j=arr.length-1;j>0;j--) {
			temp = arr[j];
			arr[j] =arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
	}
	
	/**
	 * 
	 * @param arr
	 * @param i ��Ҷ�ӽڵ��������е�����
	 * @param length ʣ�������Ԫ��
	 */
	//�������ųɴ󶥶�
	public static void adjustHeap(int[] arr,int i,int length) {
		int temp = arr[i];
		//��ʼ����  k*2+1Ϊk�����ӽڵ��Ӧ����������
		for(int k=i*2+1;k<length;k=k*2+1) {
			if(k+1<length && arr[k]<arr[k+1]) { //���ӽڵ�С�����ӽڵ�ֵ
				k++;   //kָ�����ӽڵ�
			}
			if(arr[k]>temp) {
				arr[i]=arr[k]; //�ѽϴ��ֵ��ֵ����ǰ�ڵ� 
				i=k; //i-->k����ѭ��
			}else {
				break;
			}
		}
		//forѭ��������  ��iΪ���ڵ���������ֵ ���������
		arr[i] = temp;
	}
}
