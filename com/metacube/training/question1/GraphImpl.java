package com.metacube.training.question1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl implements Graph {

	private int noOfVertices;
	private LinkedList<Node> adjacentList[];

	@SuppressWarnings("unchecked")
	public GraphImpl(int noOfVertices) {

		if (noOfVertices < 0) {
			throw new AssertionError("Invalid no of vertices");
		} else {
			this.noOfVertices = noOfVertices;
			adjacentList = new LinkedList[noOfVertices];
			for (int i = 0; i < noOfVertices; ++i) {

				adjacentList[i] = new LinkedList<Node>();

			}
		}

	}

	public boolean addNode(int source, int destination, int weight) {

		boolean result = false;

		if (source < 0 || source >= noOfVertices || destination < 0
				|| destination >= noOfVertices || weight < 0) {
			throw new AssertionError("Enter valid values");
		} else {
			Node nodeSource = new Node(destination, weight);
			adjacentList[source].add(nodeSource);
			Node nodeDest = new Node(destination, weight);
			adjacentList[source].add(nodeDest);
			result = true;
		}

		return result;
	}

	@Override
	public boolean isConnected(int startIndex) {

		boolean[] visited = new boolean[noOfVertices];
		if (startIndex >= 0 || startIndex < noOfVertices) {
			recursivelyCallConnected(startIndex, visited);
		} else {
			throw new AssertionError("Enter valid startIndex");
		}
		for (boolean visit : visited) {
			if (visit == false) {
				return false;
			}
		}
		return true;
	}

	public void recursivelyCallConnected(int index, boolean[] visited) {

		visited[index] = true;

		Iterator<Node> neightbour = adjacentList[index].listIterator();

		while (neightbour.hasNext()) {
			Node nextNode = neightbour.next();
			if (!visited[nextNode.getVertex()]) {
				recursivelyCallConnected(nextNode.getVertex(), visited);
			}
		}

	}

	@Override
	public List<Integer> reachable(int source) {

		List<Integer> reachableNodes = new ArrayList<Integer>();

		boolean[] visited = new boolean[noOfVertices];

		if (source >= 0 || source < noOfVertices) {

			recursivelyCallConnected(0, visited);

			
			for (int i = 0; i < noOfVertices; ++i) {

				
				
				if (visited[i] == true) {
					reachableNodes.add(i);
				}
			}
		} else {
			throw new AssertionError("Enter valid startIndex");
		}
		return reachableNodes;
	}

	@Override
	public int[] mst() {
		
		int []key=new int[noOfVertices];
		int []tree=new int[noOfVertices];
		boolean []visited=new boolean[noOfVertices];
		
		for(int i=0;i<noOfVertices;++i){
			key[i]=Integer.MAX_VALUE;
		}
		
		key[0]=0;
		tree[0]=-1;
		
		for(int i=0;i<noOfVertices;++i){
			
			int []index=minDistance(key, visited);
			
			visited[index[1]]=true;
			
			for(int j=0;j<noOfVertices;++j){
				
				if(index[0]!=0&&visited[j]==false){
					tree[j]=index[1];
					key[j]=index[0];
				}
				
			}
		}
		
		return tree;
	}
	
	public int[] minDistance(int []distance,boolean []shortestPath){
		
		int minNode[]=new int[2];
		minNode[0]=Integer.MAX_VALUE;
		minNode[1]=-1;
		
		for(int i=0;i<noOfVertices;++i){
			
			if(!shortestPath[i]&&distance[i]<=minNode[0]){
				minNode[1]=i;
				minNode[0]=distance[i];
			}
			
		}
		
		return minNode;
	}

	@Override
	public int shortestPath(int source, int destination) {
		if (source < 0 || source >= this.noOfVertices || destination < 0
				|| destination >= this.noOfVertices) {
			throw new AssertionError("Please enter correct input");
		}
		int shortestDistance = 0;

		int distance[] = new int[this.noOfVertices];
		boolean shortestPath[] = new boolean[this.noOfVertices];

		for (int count = 0; count < this.noOfVertices; count++) {
			distance[count] = Integer.MAX_VALUE;
		}

		distance[source] = 0;

		outerloop: for (int count1 = 0; count1 < this.noOfVertices - 1; count1++) {

			int[] nextVertex = minDistance(distance, shortestPath);

			shortestPath[nextVertex[1]] = true;

			for (int count2 = 0; count2 < this.noOfVertices; count2++) {
				int dist = nextVertex[0];
				if ((!shortestPath[count2])
						&& dist != 0
						&& distance[nextVertex[1]] != Integer.MAX_VALUE
						&& distance[nextVertex[1]] + dist < distance[count2]) {
					distance[count2] = distance[nextVertex[1]] + dist;
					if (count2 == destination) {
						shortestDistance = distance[count2];
						break outerloop;
					}
				}

			}
		}

		return shortestDistance;
	 
}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}
}
