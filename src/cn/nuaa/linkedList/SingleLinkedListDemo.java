package cn.nuaa.linkedList;

import java.util.Stack;

/**
 * ���Ӣ�۲���������  ˳��Ϊ����˳�� add()
 * ���Ӣ�ۿ�������  ˳��Ϊ����˳�� addByOrder()
 * ��������ʾ
 * @author Young
 *
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(3,"¬����","������");
		HeroNode hero3 = new HeroNode(4,"����","�Ƕ���");
		
		HeroNode hero4 = new HeroNode(2,"�ֳ�","����ͷ");
		HeroNode hero5 = new HeroNode(5,"¬����","������");
		HeroNode hero6 = new HeroNode(6,"����","�Ƕ���");
		HeroNode hero7 = new HeroNode(7,"�ֳ�","����ͷ");
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
		System.out.println("�ϲ���");
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
		
//		HeroNode newHeroNode = new HeroNode(2,"С¬","С·��");
//		singlelist.update(newHeroNode);
//		//�޸ĺ�
//		System.out.println("�޸ĺ�~~~~~~~~~~~~");
//		singlelist.list();
//		
//		singlelist.del(1);
//		System.out.println("ɾ����ʾ~~~~~~~~~~~~");
//		singlelist.list();
//		
//		HeroNode res = findLastIndexNode(singlelist.getHead(), 2);
//		System.out.println("������һ��"+res);
//		
//		reverseList(singlelist.getHead());
//		singlelist.list();
//		
//		reversePrint(singlelist.getHead());
//		singlelist.list();
		
	}
	
	/**
	 * ����������1��
	 * head �����ͷ��� ����������Ч�ڵ����
	 */
	public static int getLength(HeroNode head) {
		if(head==null) {
			System.out.println("list is null");
		}
		//��ͳ��ͷ���
		HeroNode cur = head.next;
		int length = 0;
		while(cur.next!=null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	/**
	 * ������������2
	 * ���ҵ�����ĵ�����k���ڵ�
	 */
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		if(head.next==null) {
			System.out.println("list is null");
			return null;
		}
		int size = getLength(head);
		//indexУ��
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
	 * ������������3
	 * ��ת������
	 */
	public static void reverseList(HeroNode head) {
		if(head.next==null||head.next.next==null) {
			return;
		}
		
		HeroNode cur = head.next;
		HeroNode next = null; //ֻ��cur�ڵ����һ���ڵ㼴����ʣ�ಿ��
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
	 * ������������4
	 * �����ӡ������  ����stack
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
		
		//��ӡstack�Ľڵ�
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
	
	//�ϲ�������������  �κ���ϰ��  023����
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
	//�����Ǳ��˳��ʱ �ҵ��������Ľڵ�������ݽڵ�
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
	//���Ӣ�۰���Ӣ������
	public void addByOrder(HeroNode heronode) {
		//tempΪҪ����λ�õ�ǰһ���ڵ�
		HeroNode temp = head;
		boolean flag = false; //��־��ӵı���Ƿ����
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
			System.out.printf("�����Ӱ����%d �Ѿ����� ���ܼ���\n",heronode.no);
		}else {
			heronode.next = temp.next;
			temp.next = heronode;
		}
		
	}
	
	//�޸Ľڵ����Ϣ
	public void update(HeroNode newHeroNode) {
		if(head.next==null) {
			System.out.println("����Ϊ��");
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
			System.out.printf("û���д����%d�Ľڵ�",newHeroNode.no);
		}
	}
	
	public void del(int no) {
		if(head.next==null) {
			System.out.println("����Ϊ��");
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
			System.out.println("��ɾ���ڵ㲻����");
		}
	}
	
	//��ʾ����
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
