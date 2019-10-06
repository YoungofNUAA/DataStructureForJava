package cn.nuaa.huffmtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}

	public static void preOrder(Node root) {
		if(root==null) {
			System.out.println("树为空");
		}else {
			root.preOrder();
		}
	}
	
	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<Node>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		
		while(nodes.size()>1) {
			Collections.sort(nodes);
			System.out.println(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(leftNode.value+rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//从list中删除处理过得二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
			System.out.println(nodes);
		}
		return nodes.get(0);
	}
}

class Node implements Comparable<Node>{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value = value;
	}
	
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node [value="+value+"]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return (this.value-o.value);
	}
}
