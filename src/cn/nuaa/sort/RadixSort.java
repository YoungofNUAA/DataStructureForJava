package cn.nuaa.sort;

import java.util.Arrays;

/**
 *  基数排序  稳定排序  不支持负数  因为负数在取模的时候为- 提示数组越界
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
		
		//定义一个二维数组 表示10个通  每个桶就是一个一维数组
		//第二维 arr.length  用空间换时间
		
		int[][] bucket = new int[10][arr.length];
		//记录每个桶中实际存放的数据
		int[] bucketElementCounts = new int[10];
		int maxLength = (max+"").length();
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//第一轮：根据元素个位进行排序
			for(int j=0;j<arr.length;j++) {
				//取出每个元素的个位
				int digitOfElement = arr[j]/n%10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//按照桶的顺序 取出数据 放入原数组
			int index = 0;
			for(int k=0;k<bucketElementCounts.length;k++) {
				//如果桶中有数据
				if(bucketElementCounts[k]!=0) {
					//循环第k个桶 
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
