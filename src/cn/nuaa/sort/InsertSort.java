package cn.nuaa.sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {101,34,119,1};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int insertValue = arr[i];
			int insertIndex = i-1;
			while(insertIndex>=0 && insertValue<arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex --; 
			}
			if((insertIndex+1)!=i) {
				arr[insertIndex+1] = insertValue;
			}
		}
	}
}
