package cn.nuaa.sort;

import java.util.Arrays;

/**
 * �鲢����     ���β���
 * @author Young
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {8,4,5,7,1,3,6,2};
		int[] temp = new int[arr.length];
		
		merge(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(arr));
	}
	
	//�ֽ�
	public static void merge(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;
			//����ݹ�
			merge(arr,left,mid,temp);
			//���ҵݹ�
			merge(arr,mid+1,right,temp);
			mergeSort(arr,left,mid,right,temp);
		}

	}
	
	
	/**
	 * 
	 * @param arr  
	 * @param left ����������еĳ�ʼ����
	 * @param mid  �м�����
	 * @param right
	 * @param temp ��ת����
	 */
	public static void mergeSort(int[] arr,int left,int mid,int right,int[] temp) {
		int i =left;  //���
		int j = mid+1; //�ұ�
		int t = 0;  //ָ��temp�ĵ�ǰ����
		
		//�Ȱ������������ݰ��չ�����䵽temp ֪���������ߵ��������� ��һ�ߴ���Ϊֹ
		while(i<=mid && j<=right) {
			if(arr[i]<=arr[j]) {
				temp[t] = arr[i];
				t+=1;
				i+=1;
			}else {
				temp[t] = arr[j];
				t+=1;
				j+=1;
			}
		}
		
		//��ʣ������һ�ߵ�����������䵽temp���
		while(i<=mid) {
			temp[t] = arr[i];
			t+=1;
			i+=1;
		}
		
		while(j<=right) {
			temp[t] = arr[j];
			t+=1;
			j+=1;
		}
		//��temp�����鿽����arr
		//����ÿ�ζ���������
		t = 0;
		int tempLeft = left;
		//���һ�κϲ� tempLeft=0  right=7
		while(tempLeft<=right) {
			arr[tempLeft] = temp[t];
			t+=1;
			tempLeft+=1;
		}
	}
}
