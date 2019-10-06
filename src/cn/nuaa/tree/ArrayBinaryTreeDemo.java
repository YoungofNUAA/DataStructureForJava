package cn.nuaa.tree;
/**
 * ˳��洢������
 * @author Young
 *
 */
public class ArrayBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		ArrayBinaryTree arraytree = new ArrayBinaryTree(arr);
		System.out.println("ǰ�����");
		arraytree.preOrder(0);
		System.out.println("�������");
		arraytree.infixOrder(0);
		System.out.println("�������");
		arraytree.postOrder(0);
	}
}

class ArrayBinaryTree{
	private int[] arr;
	
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	public void preOrder(int index) {
		if(arr==null || arr.length==0) {
			System.out.println("����Ϊ��");
		}
		System.out.println(arr[index]);
		if((index*2+1)<arr.length) {
			preOrder(2*index+1);
		}
		if((index*2+2)<arr.length) {
			preOrder(2*index+2);
		}
	}
	
	public void infixOrder(int index) {
		if(arr==null || arr.length==0) {
			System.out.println("����Ϊ��");
		}
		if((index*2+1)<arr.length) {
			infixOrder(2*index+1);
		}
		System.out.println(arr[index]);
		
		if((index*2+2)<arr.length) {
			infixOrder(index*2+2);
		}
	}
	
	public void postOrder(int index) {
		if(arr==null || arr.length==0) {
			System.out.println("����Ϊ��");
		}
		if((index*2+1)<arr.length) {
			postOrder(index*2+1);
		}
		if((index*2+2)<arr.length) {
			postOrder(index*2+2);
		}
		System.out.println(arr[index]);
	}
}