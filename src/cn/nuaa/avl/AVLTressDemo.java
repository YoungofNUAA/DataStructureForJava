package cn.nuaa.avl;


public class AVLTressDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {4,3,6,5,7,8};
		int[] arr = {10,12,8,9,7,6};
		AVLTree avltree = new AVLTree();
		for(int i=0;i<arr.length;i++) {
			avltree.add(new Node(arr[i]));
		}
		System.out.println("�������");
		avltree.infixOrder();
		System.out.println("ƽ�⴦��");
		System.out.println("���ĸ߶ȣ�"+avltree.getRoot().height());
		System.out.println("�����������߶ȣ�"+avltree.getRoot().leftHeight());
		System.out.println("�����������߶ȣ�"+avltree.getRoot().rightHeight());
		
	}

}

class AVLTree{
	Node root;
	
	public Node getRoot() {
		return root;
	}
	//����Ҫɾ���Ľڵ�
	public Node search(int value) {
		if(root==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	//����Ҫɾ���ĸ��ڵ�
	public Node searchParent(int value) {
		if(root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	/**
	 * 
	 * @return ��NodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		while(target.left!=null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}
	
	/**
	 * 
	 * @param node
	 * @return ��NodeΪ���ڵ�Ķ����������������������ڵ��ֵ
	 */
	public int delLeftTreeMax(Node node) {
		Node target = node;
		while(target.right!=null) {
			target = target.right;
		}
		delNode(target.value);
		return target.value;
	}
	
	//ɾ���ڵ�
	public void delNode(int value) {
		if(root == null) {
			return;
		}else {
			Node targetNode = search(value);
			if(targetNode == null) {
				return;
			}
			//�����ǰ���BSTֻ��һ���ڵ�
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			//��targetNode�ĸ��ڵ�
			Node parent = searchParent(value);
			//Ҷ�ӽڵ�
			if(targetNode.left==null && targetNode.right==null) {
				//�ж�targetNode��parent���������ӽڵ�
				if(parent.left!=null && parent.left.value==value) {
					parent.left = null;
				}else if(parent.right!=null && parent.right.value==value) {
					parent.right = null;
				}
			}else if(targetNode.left!=null && targetNode.right!=null) {//ɾ�������������Ľڵ�
//				int minVal = delRightTreeMin(targetNode.right);
//				targetNode.value = minVal;
				//ɾ��target�����������ֵ
				int maxVal = delLeftTreeMax(targetNode.left);
				targetNode.value = maxVal;
			}else {//ɾ����һ�������Ľڵ�
				//ɾ���Ľڵ������ӽڵ�
				if(targetNode.left!=null) {
					if(parent!=null) {
						if(parent.left.value==value) {
							parent.left = targetNode.left;
						}else {
							parent.right = targetNode.left;
						}
					}else {
						root = targetNode.left;
					}
				}else {
					if(parent!=null) {
						if(parent.left.value==value) {
							parent.left = targetNode.right;
						}else {
							parent.right = targetNode.right;
						}
					}else {
						root = targetNode.right;
					}
				}
				
			}
			
		}
	}
	public void add(Node node) {
		if(root==null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	public void infixOrder() {
		if(root!=null) {
			root.infixOrder();
		}else {
			System.out.println("The tree is null");
		}
	}
}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	//�����Ե�ǰ�ڵ�Ϊ���ڵ�����ĸ߶�
	public int height() {
		return Math.max(left == null? 0:left.height(), right == null?0:right.height())+1;
	}
	
	public int leftHeight() {
		if(left==null) {
			return 0;
		}
		return left.height();
	}
	
	public int rightHeight() {
		if(right==null) {
			return 0;
		}
		return right.height();
	}
	
	//����ת
	public void leftRotate() {
		Node newNode = new Node(value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left = newNode;
	}
	public void rightRotate() {
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}

	//����Ҫɾ���Ľڵ�
	public Node search(int value) {
		if(value==this.value) {
			return this;
		}else if(value<this.value) {
			if(this.left==null) {
				return null;
			}
			return this.left.search(value);
		}else {
			if(this.right==null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	//����Ҫɾ���ڵ�ĸ��ڵ�
	/**
	 * 
	 * @param  value
	 * @return ����Ҫɾ���ڵ�ĸ��ڵ�
	 */
	public Node searchParent(int value) {
		if((this.left!=null && this.left.value==value)||(this.right!=null && this.right.value==value)) {
			return this;
		}else {
			if(value<this.value && this.left!=null) {
				return this.left.searchParent(value);
			}else if(value>=this.value && this.right!=null) {
				return this.right.searchParent(value);
			}else {
				return null;  //û�и��ڵ�
			}
		}
	}
	
	//��ӽڵ�
	public void add(Node node) {
		if(node==null) {
			return;
		}
		if(node.value<this.value) {
			if(this.left==null){
				this.left=node;
			}else {
				this.left.add(node);
			}
		}else {
			if(this.right==null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
		}
		//�����ڵ�� 
		if((rightHeight()-leftHeight())>1) {
			//����������������������������������������ĸ߶�
			if(right!=null && right.leftHeight()>right.rightHeight()) {
				right.rightRotate();
				leftRotate();
			}else {
				leftRotate();
			}
			return;
		}
		
		if((leftHeight()-rightHeight())>1) {
			//������������������ĸ߶ȴ����� ���������ĸ߶�
			if(left!=null && left.rightHeight()>left.leftHeight()) {
				left.leftRotate();
				rightRotate();
			}else {
				rightRotate();
			}
			return;
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
}

