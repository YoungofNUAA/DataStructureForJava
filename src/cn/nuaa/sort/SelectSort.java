package cn.nuaa.sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] {101,34,119,1};
		int[] arr = new int[80000];
		for(int i=0;i<8000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = df1.format(date1);
		System.out.println("ÅÅÐòÇ°£º"+date1Str);
		
		
		selectSort(arr);
		Date date2 = new Date();
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr2 = df2.format(date2);
		System.out.println("ÅÅÐòºó£º"+dateStr2);
		
		//System.out.println(Arrays.toString(arr));
	}
	
	public static void selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			int min = arr[minIndex];
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

}
