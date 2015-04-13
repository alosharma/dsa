package com.dsa.impl;

public class StackOnLL {
	private LinkList stackImpl = new LinkList();
	
	
	/**
	 * Stores data in stack which is built on link list
	 * @param data
	 */
	public void push(long data){
		Link link = new Link(data);
		stackImpl.insertFirst(link);
		
	}
	
	
	/**
	 * 
	 * @param data
	 * @return data from the top of the stack.
	 */
	public long pop(){
		
		return stackImpl.removeFirst().data ;
		
	}
	
}
