package cn.nuaa.search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for(int i=1;i<=100;i++) {
			arr[i-1] = i;
		}
		//System.out.println(Arrays.toString(arr));
		int index = insertValueSearch(arr,0,arr.length-1,100);
		System.out.println(index);
	}

	public static int insertValueSearch(int[] arr,int left,int right,int findValue) {
		//新的mid算法 findValue参与计算  保证不会出现数组越界
		if(left>right || findValue<arr[0] || findValue>arr[arr.length-1]) {
			return -1;
		}
		int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
		int midValue = arr[mid];
		if(findValue<midValue) {
			return insertValueSearch(arr,0,mid,findValue);
		}else if(findValue>midValue) {
			return insertValueSearch(arr,mid+1,right,findValue);
		}else {
			return mid;
		}
	}
}
