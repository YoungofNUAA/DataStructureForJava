package cn.nuaa.linkedList;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("˫������Ĳ���");
		HeroNode2 hero1 = new HeroNode2(1,"�ν�","��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2,"¬����","������");
		HeroNode2 hero3 = new HeroNode2(3,"����","�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4,"�ֳ�","����ͷ");
		
		DoubleLinkedList doublelist = new DoubleLinkedList();
//		doublelist.add(hero1);
//		doublelist.add(hero2);
//		doublelist.add(hero3);
//		doublelist.add(hero4);
		doublelist.list();
//		System.out.println("ɾ������");
//		doublelist.del(3);
//		doublelist.list();
		System.out.println("�����˳�����");
		doublelist.addByOrder2(hero1);
		doublelist.addByOrder2(hero4);
		doublelist.addByOrder2(hero2);
		doublelist.addByOrder2(hero3);
	
		doublelist.list();
	}

}

class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	
	public HeroNode2(int no,String name,String nickname) {
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

class DoubleLinkedList{
	private HeroNode2 head = new HeroNode2(0,"","");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	public void list(){
		if(head.next==null) {
			System.out.println("list is null");
			return;
		}
		HeroNode2 temp = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	//���
	public void add(HeroNode2 heronode) {
		HeroNode2 temp = head;
		
		while(true) {
			if(temp.next==null) {
				break;
			}
			
			temp = temp.next;
		}
	    temp.next = heronode;
	    heronode.pre = temp;
	}
	
	//��ʱ������ ����ʵ���������
	public void addByOrder2(HeroNode2 heronode) {
		
		HeroNode2 temp = head;
		boolean flag = false;
		while(temp.next!=null) {
			if(heronode.no>temp.no) {
				break;
			}else if(heronode.no==temp.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			System.out.println("����ı���Ѿ�����");
		}else {
			if(temp.next==null) {
				temp.next = heronode;
				heronode.pre = temp;
			}else {
				heronode.next = temp.next;
				temp.next.pre = heronode;
				temp.next = heronode;
				heronode.pre = temp;
			}

		}
	}
	
	public void update(HeroNode2 newHeroNode) {
		if(head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
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
		if(head==null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head;
		boolean flag = false;
		
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.no==no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.pre.next = temp.next;
			if(temp.next!=null) {
				temp.next.pre = temp.pre;
			}
		}else{
			System.out.println("��ɾ���ڵ㲻����");
		}
	}
}