package cn.nuaa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��׺���ʽתΪ��׺���ʽ
		
		String expression = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println(infixExpressionList);
		List<String> suffixExpressionList = parseSuffixExpression(infixExpressionList);
		System.out.println(suffixExpressionList);
		//��׺���ʽ����
//		String suffixExpression = "30 4 + 5 * 6 -";
//		List<String> list = getListString(suffixExpression);
		int result = calculate(suffixExpressionList);
		System.out.println("������Ϊ��"+result);
	}
	
	public static List<String> toInfixExpressionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;
		String str = ""; //��λ����ƴ�ӹ���
		char c;
		do {
			if((c=s.charAt(i))<'0' ||(c=s.charAt(i))>'9') {
				ls.add(""+c);
				i++;
			}else {
				str = "";
				while(i<s.length()&&(c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) {
					str = str+c;
					i++;
				}
				ls.add(str);
			}
			
		}while(i<s.length());
		return ls;
	}
	
	public static List<String> parseSuffixExpression(List<String> ls){
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<String>();
		
		for(String item:ls) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")){
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();   //������
			}else {
				//��item�����ȼ�С�ڻ����ջ��Ԫ�ص����ȼ�   ��s1ջ���������������ѹ�뵽s2��
				while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
			
		}
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;
	}

	public static List<String> getListString(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String s:split) {
			list.add(s);
		}
		return list;
	}
	
	public static int calculate(List<String> list) {
		Stack<String> stack = new Stack<String>();
		for(String s:list) {
			if(s.matches("\\d+")) {
				stack.push(s);
			}else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(s.equals("+")) {
					res = num1+num2;
				}else if(s.equals("-")) {
					res = num1-num2;
				}else if(s.equals("*")) {
					res = num1*num2;
				}else if(s.equals("/")) {
					res = num1/num2;
				}else {
					throw new RuntimeException("���������");
				}
				stack.push(""+res);
			}
		}
		
		return Integer.parseInt(stack.pop());
	}
}

class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("û����Ӧ�Ĳ�����");
			break;
		}
		return result;
	}
	
}
