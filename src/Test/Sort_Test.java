package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * �����㷨��ϰ
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
	//ð������
	public static int[] sort(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length-1;i++) {//ѭ�����鳤��-1��
			boolean flag = true;         //�ٶ�����ѭ���Ѿ�����
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
	
	//ѡ������
	public static int[] selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			int min = arr[minIndex]; //�ٶ���Сֵ
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
	
	//��������
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
