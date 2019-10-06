package cn.nuaa.sort;

import java.util.Arrays;

/**
 * 归并排序     分治策略
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
	
	//分解
	public static void merge(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;
			//向左递归
			merge(arr,left,mid,temp);
			//向右递归
			merge(arr,mid+1,right,temp);
			mergeSort(arr,left,mid,right,temp);
		}

	}
	
	
	/**
	 * 
	 * @param arr  
	 * @param left 左边有序序列的初始索引
	 * @param mid  中间索引
	 * @param right
	 * @param temp 中转数组
	 */
	public static void mergeSort(int[] arr,int left,int mid,int right,int[] temp) {
		int i =left;  //左边
		int j = mid+1; //右边
		int t = 0;  //指向temp的当前索引
		
		//先把左右两边数据按照规则填充到temp 知道左右两边的有序序列 有一边处理为止
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
		
		//把剩余数据一边的数据依次填充到temp后边
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
		//将temp的数组拷贝到arr
		//不是每次都拷贝所有
		t = 0;
		int tempLeft = left;
		//最后一次合并 tempLeft=0  right=7
		while(tempLeft<=right) {
			arr[tempLeft] = temp[t];
			t+=1;
			tempLeft+=1;
		}
	}
}
