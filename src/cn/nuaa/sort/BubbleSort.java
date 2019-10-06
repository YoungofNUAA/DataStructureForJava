package cn.nuaa.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3,9,-1,10,-2};
		for(int i=0;i<arr.length-1;i++) {
			boolean flag = true;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				} 
			}
			if(flag) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
