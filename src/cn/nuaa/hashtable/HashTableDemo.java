package cn.nuaa.hashtable;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashtable = new HashTable(7);
		
		//简单菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("find");
			System.out.println("exit");
			
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("请输入明名字");
				String name = scanner.next();
				hashtable.add(new Emp(id,name));
				break;
			case "list":
				hashtable.list();
				break;
			case "find":
				System.out.println("输入查找id");
				int id1 =scanner.nextInt();
				hashtable.findEmpByTd(id1);
				break;
			case "exit":
				scanner.close();
				loop = false;
			default:
				break;
			}
		}
	}

}

class HashTable{
	EmpLinkedList[] empLinkedListArray;
	int size;
	public HashTable(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		for(int i=0;i<size;i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	public void add(Emp emp) {
		//根据员工id计算应该放入那个数组中的链表
		int empLinkedListNo = hashFun(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
	}
	
	public void list() {
		for(int i=0;i<size;i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	public void findEmpByTd(int id) {
		int empLinkedListNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findById(id);
		if(emp==null) {
			System.out.println("没有该员工");
		}else {
			System.out.println("第"+empLinkedListNo+"链表中查到"+id+"雇员"+"名字:"+emp.name);
		}
		
	}
	public int hashFun(int id) {
		return id%size;
	}
}

class Emp{
	int id;
	String name;
	Emp next = null;

	public Emp(int id,String name) {
		this.id = id;
		this.name = name;
	}
}

class EmpLinkedList{
	Emp head;
	
	public void add(Emp emp) {
		if(head==null) {
			head = emp;
			return;
		}
		Emp curEmp = head;
		while(true) {
			if(curEmp.next==null) {
				break;
			}
			curEmp=curEmp.next;
		}
		curEmp.next=emp;
	}
	
	public void list(int no) {
		if(head==null) {
			System.out.println("第"+no+"链表为空");
			return;
		}
		System.out.println("第"+no+"链表信息为");
		Emp curEmp = head;
		while(true) {
			System.out.printf("=> id=%d name=%s\t",curEmp.id,curEmp.name);
			if(curEmp.next==null) {
				break;
			}
			curEmp=curEmp.next;
		}
		System.out.println();
	}
	
	public Emp findById(int id) {
		if(head==null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		//自己的实现方法
		boolean isIdBraek = false;
		while(true) {
			if(curEmp.id==id) {
				isIdBraek = true;
				break;
			}
			if(curEmp.next==null) {
				break;
			}
			curEmp = curEmp.next;
		}
		if(isIdBraek) {
			return curEmp;
		}else {
			return null;
		}
	}
}
