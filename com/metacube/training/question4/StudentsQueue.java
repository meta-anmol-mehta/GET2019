package com.metacube.training.question4;

import com.metacube.training.question3.Queue;



public class StudentsQueue<StudentNode> implements Queue<StudentNode> {

	private int front; // front element of the queue
	private int rear; // rear element of the queue
	private int size; // maximum size of the array
	private StudentNode[] queue;

	public StudentsQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queue = (StudentNode[]) new Object[this.size];
	}
	



	@Override
	public void insert(StudentNode information)  {
		if (front == -1) {
			front++;
			rear++;
			queue[front] = information;
		} else if (!isFull()) {
			rear++;
			queue[rear] = information;
		} else {
			throw new AssertionError(
					"Queue overflow: cannot insert more elements");
		}
	}

	@Override
	public StudentNode remove()  {
		StudentNode data = null;
		if (!isEmpty()) {
			data = queue[front];
			front++;
		} else {
			throw new AssertionError(
					"Queue Underflow: no element is present in the queue");
		}
		return data;
	}

	@Override
	public boolean isEmpty() {

		return front == rear ? true : false;

	}

	@Override
	public boolean isFull() {

		return rear == queue.length - 1 ? true : false;
	}

	@Override
	public StudentNode top() {
		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new AssertionError("Empty Queue");
		}
	}

}
