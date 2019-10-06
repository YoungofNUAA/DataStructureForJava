package cn.nuaa.sort;

import java.util.Arrays;
/**
 * 希尔排序有点难 理解一下gap
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
		//希尔排序第一轮
		int temp = 0;
		int count = 0;
		for(int gap = arr.length/2;gap>0;gap/=2) {
			for(int i=gap;i<arr.length;i++) {
				//遍历数组所有元素（5组，每组2个）
				for(int j=i-gap;j>=0;j-=gap) {
					//如果当前元素大于加上步长后的那个元素，交换
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("希尔排序第"+(++count)+"轮"+Arrays.toString(arr));	
		}
	}
	
	//移位法
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
