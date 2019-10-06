package cn.nuaa.bst;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,3,10,12,5,1,9,2};
		BinarySortTree binarysorttree = new BinarySortTree();
		for(int i=0;i<arr.length;i++) {
			Node node = new Node(arr[i]);
			binarysorttree.add(node);
		}
		binarysorttree.infixOrder();
		binarysorttree.delNode(10);
		System.out.println("~~~~~~~~~~~~~");
		binarysorttree.infixOrder();
	}

}

class BinarySortTree{
	Node root;
	
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
