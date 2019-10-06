package cn.nuaa.tree.threadbinarytree;


public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode root = new HeroNode(1,"tom");
		HeroNode node2 = new HeroNode(3,"tom");
		HeroNode node3 = new HeroNode(6,"tom");
		HeroNode node4 = new HeroNode(8,"tom");
		HeroNode node5 = new HeroNode(10,"tom");
		HeroNode node6 = new HeroNode(14,"tom");
		root.setLeft(node2);
		root.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		ThreadedBinaryTree tt = new ThreadedBinaryTree();
		tt.setRoot(root);
		tt.threadedNode(root);
		System.out.println("�������");
		tt.threadedList();
		System.out.println("ǰ�����");
		tt.infixThreadedList();
		System.out.println("�������");
		tt.postThreadedList();
//		HeroNode leftNode = node5.getLeft();
//		System.out.println(leftNode);
//		HeroNode rightNode = node5.getRight();
//		System.out.println(rightNode);
	}

}


class ThreadedBinaryTree{
	private HeroNode root;
	private HeroNode pre =null;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	//���������������� �������
	public void threadedList() {
		HeroNode node = root;
		while(node!=null) {
			while(node.getLeftType()==0) {
				node = node.getLeft();
			}
			System.out.println(node);
			
			while(node.getRightType()==1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	//���������������� ǰ�����
	public void infixThreadedList() {
		HeroNode node = root;
		while(node!=null) {
			System.out.println(node);
			while(node.getLeftType()==0) {
				node = node.getLeft();
				System.out.println(node);
			}
			while(node.getRightType()==1) {
				node = node.getRight();
			}
			node = node.getRight();		
		}
	}
	//���������������� �������  ??������һ������
	public void postThreadedList() {
		HeroNode node = root;
		while(node!=null) {
			while(node.getLeftType()==0) {
				node = node.getLeft();
			}
			System.out.println(node);
			
			while(node.getRightType()==1) {
				node = node.getRight();
				System.out.println(node);
			}	
			node = node.getRight();
		}
	}
	//������
	public void threadedNode(HeroNode node) {
		if(node==null) {
			return;
		}
		//��������������
		threadedNode(node.getLeft());
		//��������ǰ�ڵ�
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		//������������
		threadedNode(node.getRight());
	}
	
	public void preOrder() {
		if(this.root!=null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ��");
		}
	}
	
	public void infixOrder() {
		if(this.root!=null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ��");
		}
	}
	public void backOrder() {
		if(this.root!=null) {
			this.root.backOrder();
		}else {
			System.out.println("������Ϊ��");
		}
	}
	
	public HeroNode preOrderSearch(int no) {
		if(root!=null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}
	public HeroNode infixOrderSearch(int no) {
		if(root!=null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}
	public HeroNode backOrderSearch(int no) {
		if(root!=null) {
			return root.backOrderSearch(no);
		}else {
			return null;
		}
	}
	public void delNode(int no) {
		if(root!=null) {
			if(root.getNo()==no) {
				root=null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("����");
		}
	}
	public void delNode2(int no) {
		if(root!=null) {
			if(root.getNo()==no) {
				root=null;;
			}else {
				root.delNode2(no);
			}
		}else {
			System.out.println("����");
		}
	}
}

class HeroNode{
	private int no;
	private String name;
	
	private HeroNode left;
	private HeroNode right;
	
	//  leftType 0==������  1ָ��ǰ���ڵ�   
	//  righType 0==������  1��̽ڵ�
	private int leftType;
	private int rightType;
	
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNode(int no,String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	//�ݹ�ɾ��Ҷ�ӽڵ� ��Ҷ�ӽڵ�ֱ��ɾ������  
	public void delNode(int no) {
		if(this.left!=null && this.left.no==no) {
			this.left=null;
			return;
		}
		if(this.right!=null && this.right.no==no) {
			this.right = null;
			return;
		}
		if(this.left!=null) {
			this.left.delNode(no);
		}
		if(this.right!=null) {
			this.right.delNode(no);
		}
	}
	//�Ľ�ɾ�� ��Ҷ�Ӽ��㲻ɾ������
	public void delNode2(int no) {
		if(this.left!=null && this.left.no==no) {
			if(this.left.left!=null && this.left.right!=null) {
				this.left.no = this.left.left.no;
				this.left.name = this.left.left.name;
				this.left.left = null;
				return;
			}else if(this.left.left!=null) {
				this.left.no = this.left.left.no;
				this.left.name = this.left.left.name;
				this.left.left = null;
				return;
			}else if(this.left.right!=null){
				this.left.no = this.left.right.no;
				this.left.name = this.left.right.name;
				this.left.right = null;
				return;
			}else {
				//Ҫɾ���ĵ�ΪҶ�ӽڵ�
				this.left = null;
				return;
			}
		}

		if(this.right!=null && this.right.no==no) {
			if(this.right.left!=null && this.right.right!=null) {
				this.right.no = this.right.left.no;
				this.right.name = this.right.left.name;
				this.right.left = null;
				return;
			}else if(this.right.left!=null) {
				this.right.no = this.right.left.no;
				this.right.name = this.right.left.name;
				this.right.left = null;
				return;
			}else if(this.right.right!=null){
				this.right.no = this.right.right.no;
				this.right.name = this.right.right.name;
				this.right.right = null;
				return;
			}else {
				this.right = null;
				return;
			}
		}
		
		if(this.left!=null) {
			this.left.delNode2(no);
		}

		if(this.right!=null) {
			this.right.delNode2(no);
		}
	}
	
	//ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	//�������
	public void infixOrder() {
		if(this.left!=null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	//�������
	public void backOrder() {
		if(this.left!=null) {
			this.left.backOrder();
		}
		if(this.right!=null) {
			this.right.backOrder();
		}
		System.out.println(this);
	}
	
	//ǰ���������
	public HeroNode preOrderSearch(int no) {
		System.out.println("ǰ�����~~");
		if(this.no==no) {
			return this;
		}
		HeroNode resNode = null;
		if(this.left!=null) {
			resNode = this.left.preOrderSearch(no);
		}
		if(resNode!=null) {
			return resNode;
		}
		
		if(this.right!=null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	//�������
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if(this.left!=null) {
			return this.left.infixOrderSearch(no);
		}
		if(resNode!=null) {
			return resNode;
		}
		System.out.println("�������");
		if(this.no==no) {
			return this;
		}
		if(this.right!=null) {
			return this.right.infixOrderSearch(no);
		}
		return resNode;
	}
	
	//�����������
	public HeroNode backOrderSearch(int no) {
		HeroNode resNode = null;
		if(this.left!=null) {
			return this.left.backOrderSearch(no);
		}
		if(resNode!=null) {
			return resNode;
		}
		if(this.right!=null) {
			return this.right.backOrderSearch(no);
		}
		if(resNode!=null) {
			return resNode;
		}
		System.out.println("�������");
		if(this.no==no) {
			return this;
		}
		return resNode;
	}
}