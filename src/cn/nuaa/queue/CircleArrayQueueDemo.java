package cn.nuaa.queue;

import java.util.Scanner;

/**
 * 数组模拟环形链表
 * @author Young
 *
 */
public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArray q = new CircleArray(10);
		boolean loop = true;
		while(loop) {
			System.out.println("add:加入数据");
			System.out.println("pop:弹出数据");
			System.out.println("show:显示数据");
			System.out.println("head:头部数据");
			System.out.println("exit:退出程序");
			String key = "";
			Scanner scanner = new Scanner(System.in);
			key = scanner.nextLine();
			switch (key) {
			case "add":
				System.out.println("输入一个数字");
				int temp = scanner.nextInt();
				q.addQueue(temp);
				break;
			case "pop":
				try {
					System.out.println("弹出:"+q.popQueue());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			case "show":
				q.showQueue();
				break;
			case "head":
				System.out.println("头部数据"+q.headQueue());
				break;
			case "exit":
				loop = false;
				System.out.println("退出程序");
				break;
			default:
				break;
			}
		}
		
//		System.out.println(q.isEmpty());
//		System.out.println(q.isFull());
//		q.addQueue(1);
//		q.addQueue(2);
//		q.showQueue();
//		System.out.println(q.isEmpty());
//		q.popQueue();
//		System.out.println(q.headQueue());
//		q.showQueue();
//		q.addQueue(3);
//		q.addQueue(4);
//		q.showQueue();
	}

}

class CircleArray{
	private int maxsize;
	private int rear = 0;
	private int front = 0;
	private int[] array;
	
	public CircleArray(int arrMaxsize) {
		maxsize = arrMaxsize;
		array = new int[maxsize];
	}
	
	public boolean isFull() {
		return (rear+1)%maxsize == front;
	}
	
	public boolean isEmpty() {
		return rear==front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("The queue is full");
			return;
		}
		array[rear] = n;
		//rear后移  考虑取模
		rear = (rear+1)%maxsize;
	}
	
	public int popQueue() {
		if(isEmpty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		int temp = array[front];
		front = (front+1)%maxsize;
		return temp;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		for(int i = front;i<front+(totalNums());i++) {
			System.out.printf("arr[%d]=%d\n",i%maxsize,array[i%maxsize]);
		}
	}
	
	public int totalNums() {
		return (rear+maxsize-front)%maxsize;
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException( "The queue is Empty");
		}
		return array[front];
	}
}