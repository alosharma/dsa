package com.dsa.impl;

public class Queue extends BaseDsa {
	
	private int maxSize;				//maximum size of the queue 
	private long[] queueArray;			//Array to hold the data
	private int front;					//front pointer
	private int rear;					//rear pointer
	private int nItems;					//number of items in the queue
	
	//--------------------------------------------------------------------------------------------//
	/**
	 * Constructor: defines the size of the queue.
	 * @param s
	 */
	public Queue(int s){
		maxSize = s;
		queueArray = new long[maxSize];
		front = 0;
		rear= -1;
		nItems=0;
	}
	//--------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @param data to insert in queue
	 * @return flag to show is insertion if successful or failed.
	 */
	public boolean enqueue(long data){
		
		boolean enqueuedSuccessfully = true;
		boolean enqueueFailed= false;
		
		if (rear ==-1){
			queueArray[front] = data;		//first data element
			rear = front;					//both pointer point to same element.			
		}
		
		if (rear == maxSize && front ==0){
			return enqueueFailed;			// queue full
		}
		if (rear == maxSize && front !=0){
			rear=0;
			queueArray[rear++] = data;						
		}else{
			queueArray[rear++] = data;		
		}
		nItems++;
		return enqueuedSuccessfully;
	}
	//--------------------------------------------------------------------------------------------//
	
	/**
	 * 
	 * @param data to insert in queue in order of priority
	 * @return flag to show is insertion if successful or failed.
	 */
	public boolean enqueuePriotity(long data){
		
		boolean enqueuedSuccessfully = true;
		boolean enqueueFailed= false;
		int i;
		if (nItems == maxSize ){
			return enqueueFailed;			// queue full
		}
		
		if (rear ==-1){
			queueArray[front] = data;		//first data element
			rear = front;					//both pointer point to same element.
			
		}else{
			for ( i=nItems-1; i>=0;i--){
				if (data >queueArray[i]){					
					queueArray[i+1] = queueArray[i];//shift upward					
				}else{
					break;	// done shifting
				}//end if													
			}//end for
			queueArray[i+1] = data;
			nItems++;
		}//end if
		
		nItems++;	// increment the size of the queue.
		return enqueuedSuccessfully;
	}
	
	
	
	
	//--------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @return data at the front of the queue.
	 */
	public long dequeue(){
		long data =0;
		if (front != maxSize-1){			  
			nItems--;						// decrement the item counter.
			
			data = queueArray[front];		// remove the data and replace with 0;
			queueArray[front] = 0;			// remove the data and replace with 0;
			front++;
			return data;						// return the data from front of the queue and increment the from point. 
		}else{
			front = 0;
			nItems--;						// In wrap around case if front pointer is at the end of queue then
			return queueArray[maxSize-1];	// return the data and move front pointer to start of the queue.
		}
		
	}
	//--------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @return show the data from front of the queue.
	 */
	public long peek(){
	
			return queueArray[front];		// return the data from front of the queue and increment the from point. 
	
	}
	//--------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @return true is queue is empty
	 */
	public boolean isEmpty(){
		return (nItems ==0);
	}
	//--------------------------------------------------------------------------------------------//
	
	/**
	 * 
	 * @return true is queue is Full
	 */
	public boolean isFull(){
		return (nItems == maxSize);
	}
	//--------------------------------------------------------------------------------------------//
	
	
	/**
	 * 
	 * @return size of the queue
	 */
	public int size(){
		return nItems ;
	}
	//--------------------------------------------------------------------------------------------//
	/**
	 * Display entire queue
	 */
	public void displayQueue(){

		for (int i=0; i< nItems;i++){
			System.out.print(" "+ i +" -- "+ queueArray[i]);
		}
	}
}
