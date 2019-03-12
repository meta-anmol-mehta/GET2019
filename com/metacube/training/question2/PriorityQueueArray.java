package com.metacube.training.question2;

/**
 * Main class implementing enqueue, dequeue operations on the priority queue
 * 
 * @author Admin
 *
 */
public class PriorityQueueArray implements PriorityQueue {

	private Job[] queue;
	private int rear, front, maxSize;

	public PriorityQueueArray(int maxSize) {
		if (checkSize(maxSize)) {

			this.queue = new Job[maxSize];
			this.maxSize = maxSize;
		}

		this.rear = -1;
		this.front = -1;
	}

	private boolean checkSize(int maxSize) {
		return maxSize > 0 ? true : false;
	}

	@Override
	public boolean enqueue(Job job)  {
		
			if (!checkSize(maxSize)) {

				throw new AssertionError("Invalid size");

			} else if (!isFull()) {
				if (rear == -1) {
					front++;
					rear++;
				} else {
					rear = (rear + 1) % maxSize;
				}
				int pos = -1;
				for (int i = front; i <= (rear - 1) % maxSize; i++) {
					if (job.getPriority() > queue[i].getPriority()) {
						pos = i;
						break;
					}
				}
				if (pos != -1) {
					for (int i = (rear - 1) % maxSize; i >= pos; i--) {
						queue[(i + 1) % maxSize] = queue[i];
					}
					queue[pos] = job;
				} else
					queue[rear] = job;

			} else
				throw new AssertionError("The queue is full!");

			return true;
	}

	@Override
	public Job dequeue()  {
		Job job = null;
		
			if (!checkSize(maxSize)) {

				throw new AssertionError("Invalid size");
			}

			if (!isEmpty()) {
				if (front == rear) {
					job = queue[front];
					front = -1;
					rear = -1;
				} else {
					job = queue[front];
					front = (front + 1) % maxSize;
				}
			} else
				throw new AssertionError("The queue is empty!");
		

		return job;
	}

	@Override
	public boolean isEmpty()  {
		if (!checkSize(maxSize)) {
			
				throw new AssertionError("Invalid size");
			
		}
		return rear == -1 && front == -1 ? true : false;

	}

	@Override
	public boolean isFull()  {
		if (!checkSize(maxSize)) {
			
				throw new AssertionError("Invalid size");
			
		}
		return (rear + 1) % maxSize == front;
	}

}
