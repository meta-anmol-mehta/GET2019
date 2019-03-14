package com.metacube.training.question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphImplTest {

	@Test
	public void testIsConnectedPositive()  {
		GraphImpl graph = new GraphImpl(4);
		graph.addNode(0, 1, 1);
		graph.addNode(0, 2, 1);
		graph.addNode(0, 3, 2);
		graph.addNode(1, 3, 3);

		assertEquals(true, graph.isConnected(0));

	}
	
	@Test(expected = AssertionError.class)
	public void testValidation() {
		GraphImpl graph = new GraphImpl(-4);
		graph.addNode(0, 1, 1);

	}

	@Test(expected = AssertionError.class)
	public void testInvalidInputNegativeVertices()  {
		GraphImpl graph = new GraphImpl(4);
		graph.addNode(0, -1, 1);

	}

	@Test(expected = AssertionError.class)
	public void testInvalidInputNegativeWeight() {
		GraphImpl graph = new GraphImpl(4);
		graph.addNode(0, 1, -1);

	}

	@Test(expected = AssertionError.class)
	public void testInvalidInputOutOfRangeNodeIndex() {
		GraphImpl graph = new GraphImpl(4);
		graph.addNode(0, 5, 1);

	}

	@Test
	public void testIsConnectedNegative() {
		GraphImpl graph = new GraphImpl(6);
		graph.addNode(0, 1, 1);
		graph.addNode(0, 2, 1);
		graph.addNode(0, 3, 2);
		graph.addNode(1, 3, 3);
		graph.addNode(4, 5, 3);
		assertEquals(false, graph.isConnected(0));

	}
	@Test
	public void testReachable()  {
		GraphImpl graph = new GraphImpl(6);
		graph.addNode(0, 1, 1);
		graph.addNode(0, 2, 1);
		graph.addNode(0, 3, 2);
		graph.addNode(1, 3, 0);
		List<Integer> actualResult = graph.reachable(3);
		List<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(3);
		for (int count = 0; count < actualResult.size(); count++) {
			assertEquals(expectedResult.get(count), actualResult.get(count));
		}
	}
	@Test
	public void testMST() {
		GraphImpl graph = new GraphImpl(6);
		graph.addNode(0, 1, 1);
		graph.addNode(0, 2, 1);
		graph.addNode(0, 3, 2);
		graph.addNode(1, 3, 0);
		int actualResult[] = graph.mst();
		int expectedResult[] = new int[4];
		expectedResult[0] = -1;
		expectedResult[1] = 2;
		expectedResult[2] = 3;
		expectedResult[3] = 4;
		for (int count = 0; count < expectedResult.length; count++) {
			assertEquals(expectedResult[count], actualResult[count]);
		}
	}
	
	@Test
	public void testShortestPath() {
		GraphImpl graph = new GraphImpl(6);
		graph.addNode(0, 1, 1);
		graph.addNode(0, 2, 1);
		graph.addNode(0, 3, 2);
		graph.addNode(1, 3, 0);
		assertEquals(0, graph.shortestPath(1, 3));

	}
	
}
