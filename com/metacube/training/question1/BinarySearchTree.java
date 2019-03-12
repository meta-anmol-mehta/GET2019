package com.metacube.training.question1;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JsonObject;

public class BinarySearchTree<T> implements Dictionary<T> {

	private TreeNode<T> root;
	private List<Node<T>> sortedList;
	private List<Node<T>> sortedBetweenTwoKeys;

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public BinarySearchTree(JSONObject object) {
	
		sortedList = new ArrayList<Node<T>>();	
		sortedBetweenTwoKeys = new ArrayList<Node<T>>();
		this.root=null;
		for(Object key:object.keySet()){
			addNode(String.valueOf(key).toLowerCase(), (T)object.get(key));
		}
	
	}

	@Override
	public TreeNode<T> addNode(String key, T value) {
		
		if(key==null||key.equals(" ")){
			throw new AssertionError("invalid key");
		}
		else if(value!=null){
			throw new AssertionError("invalid value");	
		}
		else{
			if(root==null){
				root=new TreeNode<T>(key, value);
			}
			else if(key.compareToIgnoreCase(root.getData().getKey())>0){
				root.setRightNode(addNode(key, value));
			}
			else if(key.compareToIgnoreCase(root.getData().getKey())<0){
				root.setLeftNode(addNode(key, value));
			}
		}
		
		return root;
	}

	@Override
	public TreeNode<T> deleteNode(String key) {
		
		if(key.length()<1||key==null||key.equals(" ")){
			throw new AssertionError("key doesnt exist");
		}
		else{
			TreeNode<T> tempTreeNode1 = null;
			if (root != null) {
				if (key.equalsIgnoreCase(root.getData().getKey())) {
					TreeNode<T> leftNode = root.getLeftNode();
					TreeNode<T> rightNode = root.getRightNode();
					if (leftNode == null && rightNode == null) {
						return null;
					} else if (leftNode == null) {
						return rightNode;
					} else if (rightNode == null) {
						return leftNode;
					} else {
						tempTreeNode1 = rightNode;
						while (tempTreeNode1.getLeftNode() != null) {
							tempTreeNode1 = tempTreeNode1.getLeftNode();
						}
						tempTreeNode1.setLeftNode(leftNode);
						return rightNode;
					}
				} else if (key.compareToIgnoreCase(root.getData().getKey()) > 0) {
					setRoot(root.getRightNode());
					root.setRightNode(deleteNode( key));
				} else if (key.compareToIgnoreCase(root.getData().getKey()) < 0) {
					setRoot(root.getLeftNode());
					root.setLeftNode(deleteNode( key));
				}
			}
		}
		return null;
	}

	@Override
	public T getValue(String key) {
		
		T value;
		if(key.length()<1||key==null||key.equals(" ")){
			throw new AssertionError("key doesnt exist");
		}
		else{
		if (key.compareToIgnoreCase(root.getData().getKey()) == 0) {
			value=(T) root.getData().getValue();
		} else if (key.compareToIgnoreCase(root.getData().getKey()) > 0) {
			setRoot(root.getRightNode());
			value =(T) getValue( key);
		} else if (key.compareToIgnoreCase(root.getData().getKey()) < 0) {
			setRoot(root.getLeftNode());
			value = (T) getValue( key);
		} else {
			throw new AssertionError("Enter valid key");
		}
		}
		return value;
		
	}

	@Override
	public List<Node<T>> sortedOrder() {
		if (root != null) {
			setRoot(root.getLeftNode());
			sortedOrder();
			sortedList.add(root.getData());
			setRoot(root.getRightNode());
			sortedOrder();
		}
		return sortedList;
	}

	@Override
	public List<Node<T>> sortBetweenTwoKeyValue(String key1, String key2) {
	
		if(key1.length()<1||key1==null||key1.equals(" ")||key2.length()<1||key2==null||key2.equals(" ")){
			throw new AssertionError("key doesnt exist");
		}
		
		if (root != null) {
			if (key1.compareToIgnoreCase(root.getData().getKey()) < 0) {
				setRoot(root.getLeftNode());
				sortBetweenTwoKeyValue( key1, key2);
			}
			if (key1.compareToIgnoreCase(root.getData().getKey()) <= 0
					&& key2.compareToIgnoreCase(root.getData().getKey()) >= 0) {
				sortedBetweenTwoKeys.add(root.getData());
			}
			if (key2.compareToIgnoreCase(root.getData().getKey()) > 0) {
				setRoot(root.getRightNode());
				sortBetweenTwoKeyValue( key1, key2);
			}
		
	}
		return sortedBetweenTwoKeys;
	}
}
