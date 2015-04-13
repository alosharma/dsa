package com.dsa.impl;

public class QueueOnLL {
		
	private LinkList queueImpl = new LinkList();
	
	

	/**
	 * 
	 * @param link
	 */
	public void enqueue (long data){
		Link link = new Link(data);
		queueImpl.insertLast(link);
	}
	
	/**
	 * 
	 * @param link
	 */
	public long dequeue (){
	
		return queueImpl.removeFirst().data;
	}
	
	/**
	 * 
	 * @return true if empty, false if not empty.
	 */
	public boolean isEmpty(){
		return queueImpl.isEmpty();
	}
	
	/**
	 * Display all the data in the queue.
	 */
	public void displayQueue(){
		queueImpl.displayList();
	}
	
}
