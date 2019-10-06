package cn.nuaa.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ֲ���  ������Ҫ��֤����
 * ȱ�㣺��������ظ�Ԫ�� ֻ�ܷ���һ���±�
 * @author Young
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,10,89,1000,1000,1000,1000,1234};
		//System.out.println(binarySearch(arr,0,arr.length-1,88));
		System.out.println(binarySearchImprove(arr,0,arr.length-1,1000));
	}
	public static int binarySearch(int[] arr,int left,int right,int findValue) {
		//�ݹ��������
		System.out.println("hello~");
		if(left>right) {
			return -1;
		}
		
		int mid = (left+right)/2;
		int midValue = arr[mid];
		if(findValue>midValue) {
			return binarySearch(arr,mid+1,right,findValue);
		}else if(findValue<midValue){
			return binarySearch(arr,left,mid-1,findValue);
		}else {
			return mid;
		}
	}
	
	//���Է�����������Ҫ�����ظ�Ԫ�ص������±�
	public static ArrayList<Integer> binarySearchImprove(int[] arr,int left,int right,int findValue) {
		System.out.println("hello~");
		if(left>right) {
			return new ArrayList<Integer>();
		}
		
		//int mid = (left+right)/2;
		//��ֵ����mid��⹫ʽ
		int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
		int midValue = arr[mid];
		if(findValue>midValue) {
			return binarySearchImprove(arr,mid+1,right,findValue);
		}else if(findValue<midValue){
			return binarySearchImprove(arr,left,mid-1,findValue);
		}else {
			ArrayList<Integer> resIndex = new ArrayList<Integer>();
			int temp = mid-1;
			//����ɨ��  �ҵ����е���findValue�����ݵ��±�
			while(true) {
				if(temp<0 || arr[temp]!=findValue) {
					break;
				}
				resIndex.add(temp);
				temp-=1;
			}
			resIndex.add(mid);
			
			temp = mid+1;
			while(true) {
				if(temp>arr.length-1 || arr[temp]!=findValue) {
					break;
				}
				resIndex.add(temp);
				temp+=1;
			}
			return resIndex;
		}
	}
}
