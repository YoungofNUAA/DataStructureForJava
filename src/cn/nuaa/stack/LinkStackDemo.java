package cn.nuaa.stack;

import java.util.Scanner;
import java.util.Stack;

public class LinkStackDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack stack1 = new LinkedStack(5);
		boolean loop = true;
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show: 显示数组");
			System.out.println("pop: 弹出数据");
			System.out.println("push: 压入数据");
			key = scanner.next();
			switch (key) {
			case "show":
				stack1.showStack();
				break;
			case "pop":
				System.out.print(stack1.pop());
				break;
			case "push":
				System.out.println("输入压如栈顶的数据");
				int num = scanner.nextInt();
				stack1.push(num);
				break;
			default:
				break;
			}
			
		}
	}

}

class LinkedStack{
	private int MaxSize;
	private intNode top = new intNode(-1);
	private intNode tail = top;
	private static int howLong = 0;
	public LinkedStack(int maxsize) {
		this.MaxSize = maxsize;
	}
	public void push(int num) {
		if(howLong==MaxSize) {
			System.out.println("stack is full");
			return;
		}
		intNode node = new intNode(num);
		tail.next = node;
		tail = tail.next;
		howLong++;
	}
	
	
	public intNode pop() {
		if(top==null||top==tail) {
			throw new RuntimeException("list is null");
		}
		intNode PreTail = top;
		//找到末尾节点的前一个节点
		for(int i=1;i<howLong;i++) {
			PreTail = PreTail.next;
		}
		intNode returnNode = tail;
		PreTail.next = null;
		tail = PreTail;
		howLong--;
		return returnNode;
	}
	
	public void showStack() {
		if(top.next==null) {
			System.out.println("stack is null");
			return;
		}
		Stack<intNode> stack = new Stack<>();
		intNode item = top.next;
		for(int i=0;i<howLong;i++) {
			stack.push(item);
			item = item.next;
		}
		for(int i=0;i<howLong;i++) {
			System.out.print(stack.pop());
		}
	}
}

class intNode{
	public int value;
	public intNode next;
	public intNode(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "node:"+value+"\n";
	}
}


