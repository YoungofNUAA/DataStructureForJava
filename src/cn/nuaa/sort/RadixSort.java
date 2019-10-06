package cn.nuaa.sort;

import java.util.Arrays;

/**
 *  ��������  �ȶ�����  ��֧�ָ���  ��Ϊ������ȡģ��ʱ��Ϊ- ��ʾ����Խ��
 * @author Young
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {53,3,542,748,14,214};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void radixSort(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>=max) {
				max = arr[i];
			}
		}
		
		//����һ����ά���� ��ʾ10��ͨ  ÿ��Ͱ����һ��һά����
		//�ڶ�ά arr.length  �ÿռ任ʱ��
		
		int[][] bucket = new int[10][arr.length];
		//��¼ÿ��Ͱ��ʵ�ʴ�ŵ�����
		int[] bucketElementCounts = new int[10];
		int maxLength = (max+"").length();
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//��һ�֣�����Ԫ�ظ�λ��������
			for(int j=0;j<arr.length;j++) {
				//ȡ��ÿ��Ԫ�صĸ�λ
				int digitOfElement = arr[j]/n%10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//����Ͱ��˳�� ȡ������ ����ԭ����
			int index = 0;
			for(int k=0;k<bucketElementCounts.length;k++) {
				//���Ͱ��������
				if(bucketElementCounts[k]!=0) {
					//ѭ����k��Ͱ 
					for(int l=0;l<bucketElementCounts[k];l++) {
						arr[index] = bucket[k][l];
						index++;
					}
				}
				
				bucketElementCounts[k] = 0;
			}
		}
		
	}
}
