package cn.nuaa.search;
/**
 * ���Բ���
 * @author Young
 *
 */
public class SeqSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,11,-1,34,89};
		int index = seqSearch(arr,-1);
		if(index==-1) {
			System.out.println("û�и�ֵ");
		}else {
			System.out.println("�±�:"+index);
		}
	}
	public static int seqSearch(int[] arr,int value) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==value) {
				return i;
			}
			
		}
		return -1;
	}
}
