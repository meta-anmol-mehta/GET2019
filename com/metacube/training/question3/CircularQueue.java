package com.metacube.training.question3;

public class CircularQueue<E> implements Queue<E> {

	private int front;
	private int rear;
	private int size;
	private E[] queue;

	public CircularQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queue = (E[]) new Object[this.size];
	}

	@Override
	public void insert(E element)  {

		if (!isFull()) {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;

			queue[rear] = (E) element;
		} else {
			throw new AssertionError(
					"QueueOverflow : cannot insert more elements");
		}
	}

	@Override
	public Object remove() {

		if (isEmpty()) {
			throw new AssertionError(
					"Queue Underflow: queue does not contains any element");
		}
		Object element = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % size;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (front == -1) ? true : false;
	}

	@Override
	public boolean isFull() {
		if ((front == 0 && rear == size - 1) || (front - rear == 1)) {
			return true;
		}
		return false;
	}

	@Override
	public Object top() {

		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new AssertionError("Queue is empty");
		}
	}

}