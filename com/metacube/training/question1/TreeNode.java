package com.metacube.training.question1;

public class TreeNode<T> {

	Node<T> data;
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	public Node<T> getData() {
		return data;
	}
	public void setData(Node<T> data) {
		this.data = data;
	}
	public TreeNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	public TreeNode(String key,T value) {
		
		this.data = new Node<T>(key, value);
		this.leftNode = null;
		this.rightNode = null;
	}
	
	
	
}
