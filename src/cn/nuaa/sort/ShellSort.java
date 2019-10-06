package cn.nuaa.sort;

import java.util.Arrays;
/**
 * ϣ�������е��� ���һ��gap
 * @author Young
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {8,9,1,7,2,3,5,4,6,0,-1};
		shellSort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int[] arr) {
		//ϣ�������һ��
		int temp = 0;
		int count = 0;
		for(int gap = arr.length/2;gap>0;gap/=2) {
			for(int i=gap;i<arr.length;i++) {
				//������������Ԫ�أ�5�飬ÿ��2����
				for(int j=i-gap;j>=0;j-=gap) {
					//�����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�����
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("ϣ�������"+(++count)+"��"+Arrays.toString(arr));	
		}
	}
	
	//��λ��
	public static void shellSort2(int[] arr) {
		for(int gap=arr.length/2;gap>0;gap/=2) {
			for(int i=gap;i<arr.length;i++) {
				int j=i;
				int temp = arr[j];
				if(arr[j]<arr[j-gap]) {
					while(j-gap>=0 && temp<arr[j-gap]) {
						arr[j] = arr[j-gap];
						j-=gap;
					}
					arr[j] = temp;
				}
			}
		}
	}
}
