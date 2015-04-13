package com.dsa.impl;

public class LinkList {
	private Link first;						// reference to fist link in the list.

	/**
	 * Constructor
	 */
	public LinkList(){
		first = null;
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * Insert first link in the linklist
	 * @param link
	 */
	public void insertFirst(Link link){
		link.next = first;
		first = link;
	}
	
	
	/**
	 * Insert first link in the linklist
	 * @param long
	 */
	public void insertFirst(long data){
		Link link = new Link(data);		//create a link using the data.
		insertFirst( link);
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * 
	 * @return true is empty else fase
	 */
	public boolean isEmpty(){
		return (first==null);
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * Insert last link in the linklist
	 * @param link
	 */
	public void insertLast(Link newLink){
		Link nextlink = first;
		if (first == null){				// if linklist is empty then inter this as first link
			insertFirst(newLink);
		}else{
			while (nextlink.next  != null){		// iterate till last link.	When next link in null then exit the loop.
				nextlink = nextlink.next;			
			}//end while
			nextlink.next = newLink;			// add new link as the last link
		}//end if
		
		
	}
	
	/**
	 * Overload method to support insert using raw data.
	 * @param data
	 */
	public void insertLast(long data){
		Link newLink = new Link(data);	// create a link from the data and insert this as last link
		insertLast(newLink);
		
		
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * 
	 * @return the first link and make the next as the first link
	 */
	public Link removeFirst(){
		Link temp = first;
		if (first.next != null){
			first = first.next;	// remove the first link and make the next as first.
		}else{
			first = null;		//if this is the last link then empty the list completely by dropping the last link.
		}//end if
			
			
		return temp;		
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * 
	 * @return the last link and make the second last link as the last
	 */
	public Link removeLast(){
		Link prevLink = first;
		Link currentLink = first;
		
		
		while(currentLink.next != null){
			prevLink = currentLink;
			currentLink = currentLink.next;
		}//end while
		
		prevLink.next = null;		
		return currentLink;
	}
	
	
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * Delete a given link
	 * @param link
	 */
	public void delete(Link link){
		
		Link currentLink = first;
		Link prevLink = null;
		while (currentLink.data  != link.data){		//iterate and arrive at the link that needs to be deleted.
			prevLink = currentLink;
			currentLink = currentLink.next;			
		}//end while
		prevLink.next = currentLink.next;			//by pass the current link so it becomes unreachable
		
	}
	//-----------------------------------------------------------------------------------------------------------/
	
	/**
	 * Display the content of entire list.
	 */
	public void displayList(){
		Link currentLink = first;
		
		while (currentLink  != null){		//iterate till end.
			
			System.out.println( currentLink.data);
			currentLink = currentLink.next;			
		}//end while
		
				
	}
	
	//-----------------------------------------------------------------------------------------------------------/
	
	interface DataStructureIterator extends java.util.Iterator<Long> { } 

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface

	//-----------------------------------------------------------------------------------------------------------/
	
	
	 public class LinkListIterator implements DataStructureIterator{
		public Link iteratorMarker  = first;	// reference to the current link in the list during iteration
		@Override
		public boolean hasNext() {
			if (iteratorMarker == null){
				iteratorMarker = first;
			}
			return (iteratorMarker.next != null);		// return true is list is not empty.
			
		}

		@Override
		public Long next() {
			if (iteratorMarker == null){		//return first link during initial call.
				iteratorMarker = first;
				return first.data;
			}else{
				Link temp = iteratorMarker;				//take a backup of marker
				iteratorMarker = iteratorMarker.next;	// move marker to the next link
				return temp.data;						// return the marker from tamp.
			}
			
			
		}

		@Override
		public void remove() {
			// DO Nothing
			
		}
		 
	 }
	
}
