package cn.nuaa.queue;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class ArrayQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(10);
		System.out.println(q.isEmty());
		System.out.println(q.isFull());
		q.addQueue(1);
		q.addQueue(2);
		q.showQueue();
		//System.out.println(q.isEmty());
		System.out.println(q.popQueue());
		q.showQueue();
		//System.out.println(q.headQueue());
//		q.showQueue();
//		q.addQueue(3);
//		q.addQueue(4);
//		q.showQueue();
	}

}
class Queue{
	private int maxsize;
	private int rear;
	private int front;
	private int[] array;
	
	public Queue(int arrMaxSize) {
		maxsize = arrMaxSize;
		array = new int[maxsize];
		front = -1;
		rear = -1;
	}
	
	public boolean isFull() {
		return rear == maxsize-1;
	}
	
	public boolean isEmty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("The queue is full");
			return;
		}
		rear++;
		array[rear] = n;
	}
	
	public int popQueue() {
		
		if(isEmty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		
		front++;
//		maxsize--;
//		int[] newArray = new int[maxsize];
//	    System.arraycopy(array, front+1, newArray, 0, maxsize);
//	    array = newArray;
	    return array[front];
	    
	}
	
	public void showQueue() {
		if(isEmty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		System.out.println(Arrays.toString(array));
	}
	
	public int headQueue() {
		if(isEmty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		return array[front+1];
	}
}
