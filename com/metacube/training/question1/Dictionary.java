package com.metacube.training.question1;

import java.util.List;

public interface Dictionary<E> {

	/**
	 * Method to add tree node to a tree
	 * 
	 * @param key
	 * @param value
	 * @return true if tree node is added successfully else false
	 */
	public TreeNode<E> addNode(String key, E value) ;

	/**
	 * Method to delete tree node with a given key
	 * 
	 * @param key,
	 *            key to be deleted
	 * @return root node of the resultant tree 
	 */
	public TreeNode<E> deleteNode(String key)  ;

	/**
	 * Method to return the value mapped to the given key
	 * 
	 * @param key,
	 *            whose value is to be search
	 * @return the value mapped to the given key
	 * @  if key is invalid
	 */
	public E getValue(String key)  ;

	
	public List<Node<E>> sortedOrder() ;

	/**
	 * Method to return the list of sorted nodes lying between the given two key
	 * values
	 * 
	 * @param key1
	 *            is smaller than key2
	 * @param key2
	 *            requires to greater than key2
	 * @return list of sorted nodes
	 */
	public List<Node<E>> sortBetweenTwoKeyValue(String key1, String key2) ;
	
}
