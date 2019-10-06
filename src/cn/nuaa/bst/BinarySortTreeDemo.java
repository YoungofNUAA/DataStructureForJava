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
	
	//查找要删除的节点
	public Node search(int value) {
		if(root==null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	//查找要删除的父节点
	public Node searchParent(int value) {
		if(root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	/**
	 * 
	 * @return 以Node为根节点的二叉排序树的最小节点的值
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
	 * @return 以Node为根节点的二叉排序树的左子树的最大节点的值
	 */
	public int delLeftTreeMax(Node node) {
		Node target = node;
		while(target.right!=null) {
			target = target.right;
		}
		delNode(target.value);
		return target.value;
	}
	
	//删除节点
	public void delNode(int value) {
		if(root == null) {
			return;
		}else {
			Node targetNode = search(value);
			if(targetNode == null) {
				return;
			}
			//如果当前这颗BST只有一个节点
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			//找targetNode的父节点
			Node parent = searchParent(value);
			//叶子节点
			if(targetNode.left==null && targetNode.right==null) {
				//判断targetNode是parent的左还是右子节点
				if(parent.left!=null && parent.left.value==value) {
					parent.left = null;
				}else if(parent.right!=null && parent.right.value==value) {
					parent.right = null;
				}
			}else if(targetNode.left!=null && targetNode.right!=null) {//删除有两颗子树的节点
//				int minVal = delRightTreeMin(targetNode.right);
//				targetNode.value = minVal;
				//删除target左子树的最大值
				int maxVal = delLeftTreeMax(targetNode.left);
				targetNode.value = maxVal;
			}else {//删除有一颗子树的节点
				//删除的节点有左子节点
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

	//查找要删除的节点
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
	
	//查找要删除节点的父节点
	/**
	 * 
	 * @param  value
	 * @return 返回要删除节点的父节点
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
				return null;  //没有父节点
			}
		}
	}
	
	//添加节点
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
	//中序遍历
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
