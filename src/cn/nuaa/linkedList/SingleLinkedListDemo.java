package cn.nuaa.linkedList;

import java.util.Stack;

/**
 * 添加英雄不考虑排名  顺序为插入顺序 add()
 * 添加英雄考虑排名  顺序为插入顺序 addByOrder()
 * 单链表演示
 * @author Young
 *
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(3,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(4,"吴用","智多星");
		
		HeroNode hero4 = new HeroNode(2,"林冲","豹子头");
		HeroNode hero5 = new HeroNode(5,"卢俊义","玉麒麟");
		HeroNode hero6 = new HeroNode(6,"吴用","智多星");
		HeroNode hero7 = new HeroNode(7,"林冲","豹子头");
		SingleLinkedList singlelist1 = new SingleLinkedList();
		SingleLinkedList singlelist2 = new SingleLinkedList();
		System.out.println();
		singlelist1.add(hero1);
		singlelist1.add(hero2);
		singlelist1.add(hero3);
		singlelist2.add(hero4);
		singlelist2.add(hero5);
		singlelist2.add(hero6);
		singlelist2.add(hero7);
		singlelist1.list();
		singlelist2.list();
		HeroNode newHead = combineList(singlelist1.getHead(), singlelist2.getHead());
		System.out.println("合并后");
		printList(newHead);
		
		
		
//		singlelist.add(hero1);
//		singlelist.add(hero2);
//		singlelist.add(hero3);
//		singlelist.add(hero4);
//		singlelist.list();
		
//		singlelist.addByOrder(hero1);
//		singlelist.addByOrder(hero4);
//		singlelist.addByOrder(hero2);
//		singlelist.addByOrder(hero3);
//		singlelist.list();
		
//		HeroNode newHeroNode = new HeroNode(2,"小卢","小路子");
//		singlelist.update(newHeroNode);
//		//修改后
//		System.out.println("修改后~~~~~~~~~~~~");
//		singlelist.list();
//		
//		singlelist.del(1);
//		System.out.println("删除演示~~~~~~~~~~~~");
//		singlelist.list();
//		
//		HeroNode res = findLastIndexNode(singlelist.getHead(), 2);
//		System.out.println("倒数第一个"+res);
//		
//		reverseList(singlelist.getHead());
//		singlelist.list();
//		
//		reversePrint(singlelist.getHead());
//		singlelist.list();
		
	}
	
	/**
	 * 链表面试题1：
	 * head 链表的头结点 返回链表有效节点个数
	 */
	public static int getLength(HeroNode head) {
		if(head==null) {
			System.out.println("list is null");
		}
		//不统计头结点
		HeroNode cur = head.next;
		int length = 0;
		while(cur.next!=null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	/**
	 * 单链表满试题2
	 * 查找单链表的倒数第k个节点
	 */
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		if(head.next==null) {
			System.out.println("list is null");
			return null;
		}
		int size = getLength(head);
		//index校验
		if(index<=0||index>size) {
			return null;
		}
		HeroNode cur = head.next;
		for(int i=0;i<size-index;i++) {
			cur = cur.next;
		}
		return cur;
	}
	/**
	 * 单链表面试题3
	 * 反转单链表
	 */
	public static void reverseList(HeroNode head) {
		if(head.next==null||head.next.next==null) {
			return;
		}
		
		HeroNode cur = head.next;
		HeroNode next = null; //只想cur节点的下一个节点即链表剩余部分
		HeroNode reverseHead = new HeroNode(0,"","");
		while(cur!=null) {
			next=cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur=next;
		}
		head.next = reverseHead.next;
	}
	
	/**
	 * 单链表面试题4
	 * 逆序打印单链表  利用stack
	 */
	public static void reversePrint(HeroNode head) {
		if(head.next==null) {
			return;
		}
		
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur!=null) {
			stack.add(cur);
			cur=cur.next;
		}
		
		//打印stack的节点
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
	
	//合并两个有序链表  课后练习题  023集数
	public static HeroNode combineList(HeroNode head1,HeroNode head2) {
		HeroNode cur1 = head1.next;
		HeroNode cur2 = head2.next;
		HeroNode result = new HeroNode(0,"","");
		result = null;
		HeroNode tail = null;
		HeroNode next = null;
		
		while((cur1!=null)&&(cur2!=null)) {
			if(cur1.no<cur2.no) {
				if(result!=null) {
					next = cur1.next;
					tail.next = cur1;
					cur1.next = null;
					tail = cur1;
					cur1 = next;
				}else {
					next = cur1.next;
					result = cur1;
					cur1.next = null;
					tail = cur1;
					cur1 = next;
				}
			}else {
				if(result!=null) {
					next = cur2.next;
					tail.next = cur2;
					cur2.next = null;
					tail = cur2;
					cur2 = next;
				}else {
					next = cur2.next;
					result = cur2;
					cur2.next = null;
					tail = cur2;
					cur2 = next;
				}
				
			}
			
		}
		if(cur1==null) {
			tail.next = cur2;
		}
		if(cur2==null) {
			tail.next = cur1;
		}
		
		return result;
	}
	
	public static void printList(HeroNode head) {
		if(head==null) {
			return;
		}
		
		//Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head;
		while(cur!=null) {
			System.out.println(cur);
			cur=cur.next;
		}
		
	}
	
}

class SingleLinkedList{
	private HeroNode head = new HeroNode(0,"","");
	public HeroNode getHead() {
		return head;
	}
	//不考虑编号顺序时 找到链表最后的节点添加数据节点
	public void add(HeroNode heronode) {
		HeroNode temp = head;
		
		while(true) {
			if(temp.next==null) {
				break;
			}
			
			temp = temp.next;
		}
	    temp.next = heronode;
	}
	//添加英雄按照英雄排名
	public void addByOrder(HeroNode heronode) {
		//temp为要加入位置的前一个节点
		HeroNode temp = head;
		boolean flag = false; //标志添加的标号是否存在
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no>heronode.no) {
				break;
			}else if(temp.next.no==heronode.no) {
				flag = true;
				break;
			}
			temp =temp.next;
		}
		
		if(flag) {
			System.out.printf("插入的影响编号%d 已经存在 不能加入\n",heronode.no);
		}else {
			heronode.next = temp.next;
			temp.next = heronode;
		}
		
	}
	
	//修改节点的信息
	public void update(HeroNode newHeroNode) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			temp.nickname = newHeroNode.nickname;
			temp.name = newHeroNode.name;
		}else {
			System.out.printf("没有招待编号%d的节点",newHeroNode.no);
		}
	}
	
	public void del(int no) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.next.no==no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
		}else{
			System.out.println("待删除节点不存在");
		}
	}
	
	//显示链表
	public void list(){
		if(head.next==null) {
			System.out.println("list is null");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
}

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode(int no,String name,String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
	}
	
}
