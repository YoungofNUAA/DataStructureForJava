package cn.nuaa.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,6,8,5,9};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		int temp = 0;
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		for(int j=arr.length-1;j>0;j--) {
			temp = arr[j];
			arr[j] =arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
	}
	
	/**
	 * 
	 * @param arr
	 * @param i 非叶子节点在数组中的索引
	 * @param length 剩余待调整元素
	 */
	//将数组排成大顶堆
	public static void adjustHeap(int[] arr,int i,int length) {
		int temp = arr[i];
		//开始调整  k*2+1为k的左子节点对应的数组索引
		for(int k=i*2+1;k<length;k=k*2+1) {
			if(k+1<length && arr[k]<arr[k+1]) { //左子节点小于右子节点值
				k++;   //k指向右子节点
			}
			if(arr[k]>temp) {
				arr[i]=arr[k]; //把较大的值赋值给当前节点 
				i=k; //i-->k继续循环
			}else {
				break;
			}
		}
		//for循环结束后  以i为父节点的树的最大值 放在了最顶端
		arr[i] = temp;
	}
}
