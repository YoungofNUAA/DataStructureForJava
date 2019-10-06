package cn.nuaa.search;

import java.util.Arrays;

public class FibonacciSearch {

	public static int maxSize = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,10,89,1000,1234};
		System.out.println(fibSearch(arr,8));
	}

	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i=2;i<maxSize;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		return f;
	}
	
	//查找算法  非递归
	public static int fibSearch(int[] a,int key) {
		int low = 0;
		int high = a.length-1;
		int k = 0;   //分割数值对应的下标
		int mid = 0;
		int[] f = fib();
		
		while(high>f[k]-1) {
			k++;
		}
		int[] temp = Arrays.copyOf(a, f[k]);
		//temp={1,8,10,89,1000,1234,0,0,0}---{1,8,10,89,1000,1234,1234,1234,1234}
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=a[high];
		}
		
		//使用while循环处理  找到key
		while(low<=high) {
			mid = low+f[k-1]-1;
			if(key<temp[mid]) {
				high = mid-1;
				//1.全部元素=前面的元素+后边的元素
				//2.f[k] = f[k-1]+f[k-2];
				k--;
			}else if(key>temp[mid]){
				low = mid+1;
				// 1.全部元素=前面的元素+后边的元素
				// 2.f[k] = f[k-1]+f[k-2];
				// 3.因为后面有f[k-2] f[k-1]=f[k-3]+f[k-4]
				// 4.即在f[k-2]的前面进行查找k-=2
				// 5.即下次循环 mid=f[k-1-2]-1
				k-=2;
			}else {
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
