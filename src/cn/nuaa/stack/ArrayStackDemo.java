package cn.nuaa.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show: 表示显示栈");
			System.out.println("exit:表示退出");
			System.out.println("push:数据入栈");
			System.out.println("pop:数据出战");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.listStack();
				break;
			case "push":
				System.out.println("give me a num to push");
				int num = scanner.nextInt();
				stack.push(num);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.println("num to pop is"+res+"\n");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		
		System.out.println("program exits");
	}

}

class ArrayStack{
	private int MaxSize;
	private int[] stack;
	private int top = -1;
	
	
	public ArrayStack(int maxsize) {
		this.MaxSize = maxsize;
		stack = new int[maxsize];
	}
	
	public boolean isFull() {
		return top == MaxSize-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if(top==MaxSize-1) {
			System.out.println("stack is full");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(top==-1) {
			throw new RuntimeException("stack is empty");
		}
		int topValue = stack[top];
		top--;
		return topValue;
	}
	
	//遍历栈
	public void listStack() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}