package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序算法练习
 * @author Young
 *
 */
public class Sort_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {-1,-3,10,7,5};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	//冒泡排序
	public static int[] sort(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {//循环数组长度-1次
			boolean flag = true;         //假定本次循环已经有序
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		return arr;
	}
	
	//选择排序
	public static int[] selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			int min = arr[minIndex]; //假定最小值
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<min) {
					minIndex = j;
					min = arr[j];
				}
			}
			if(minIndex!=i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
		return arr;
	}
	
	//插入排序
	public static void insertSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int insertValue = arr[i];
			int insertIndex = i-1;
			while(insertIndex>=0 && insertValue<arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex+1] = insertValue;
		}
	}
}
