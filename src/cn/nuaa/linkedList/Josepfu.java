package cn.nuaa.linkedList;

public class Josepfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList boyList = new CircleSingleLinkedList();
		boyList.addBoy(20);
		boyList.showBoy();
		System.out.println();
		boyList.countBoy(1, 2, 20);
	}

}

//创建环形单向链表
class CircleSingleLinkedList{
	private Boy first = new Boy(-1);
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("nums should be bigger than one");
		}
		Boy curBoy = null;
		
		for(int i=1;i<=nums;i++) {
			Boy boy = new Boy(i);
			if(i==1) {
				first = boy;
				first.next = first;
				curBoy = first;
			}else {
				curBoy.next = boy;
				boy.next = first;
				curBoy = boy;
			}
		}
	}
	
	public void showBoy() {
		if(first==null) {
			System.out.println("list is null");
			return;
		}
		
		Boy curBoy = first;
		while(true) {
			System.out.print(curBoy+"\t");
			if(curBoy.next==first) {
				break;
			}
			curBoy = curBoy.next;
		}
	}
	
	//根据用户输入 计算出出圈的顺序
	public void countBoy(int startNo,int countNum,int nums) {
		if(first==null||startNo<1||startNo>nums) {
			System.out.println("输入参数有误");
			return;
		}
		Boy helper = first; //helper永远跟在first后面
		while(true) {
			if(helper.next==first) {
				break;
			}
			helper = helper.next;
		}
		//保证从startNO开始数数
		for(int j=0;j<startNo-1;j++) {
			first = first.next;
			helper = helper.next;
		}
		
		while(true) {
			if(helper==first) {
				break;
			}
			for(int i=0;i<countNum-1;i++) {
				first = first.next;
				helper = helper.next;
			}
			System.out.println("出圈Boy-->"+first);
			first = first.next;
			helper.next = first;
		}
		
		System.out.println("最后留在圈中的Boy-->"+first);
	}
}

class Boy{
	 int no;
	 Boy next;
	
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Boy:"+no;
	}
	
}
