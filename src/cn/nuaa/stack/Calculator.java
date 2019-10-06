package cn.nuaa.stack;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "30+20*6-2";
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack =new ArrayStack2(10);
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		while(true) {
			ch = expression.charAt(index);
			if(operStack.isOper(ch)) {
				if(!operStack.isEmpty()) {
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}else {
					operStack.push(ch);
				}
			}else {
				//处理多位数情况
				//numStack.push(ch-48);
				keepNum = keepNum+ch;
				if(index==expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(operStack.isOper(expression.charAt(index+1))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}
				
			}
			index++;
			if(index>=expression.length()) {
				break;
			}
		}
		
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		System.out.printf("表达式:%s=%d",expression,numStack.pop());
	}

}

class ArrayStack2{
	private int MaxSize;
	private int[] stack;
	private int top = -1;
	
	
	public ArrayStack2(int maxsize) {
		this.MaxSize = maxsize;
		stack = new int[maxsize];
	}
	
	public int peek() {
		return stack[top];
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
	
	//返回运算符的优先级,优先级使用数字表示
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	public boolean isOper(char val) {
		return val=='+'||val=='-'||val=='*'||val=='/';
	}
	
	public int cal(int num1,int num2,int oper) {
		int result = 0;
		switch (oper) {
		case '+':
			result = num1+num2;
			break;
		case '-':
			result = num2-num1;
			break;
		case '*':
			result = num1*num2;
			break;
		case '/':
			result = num2/num1;
			break;
		default:
			break;
		}
		return result;
	}
	
}
