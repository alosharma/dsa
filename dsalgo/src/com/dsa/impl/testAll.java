package com.dsa.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testAll {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// SimpleSort simpleSort = new SimpleSort(10);
		// simpleSort.add(1);
		// simpleSort.add(8);
		// simpleSort.add(3);
		// simpleSort.add(12);
		// simpleSort.add(15);
		// simpleSort.add(4);
		// simpleSort.add(2);
		// simpleSort.add(7);
		// simpleSort.add(11);
		// System.out.println("Raw Array");
		// simpleSort.display(); //display the raw array
		// System.out.println("Sorting");
		//
		//
		// //simpleSort.bubbleSort(); // do the bubble sort
		// //simpleSort.selectionSort(); // do the selection sort
		// simpleSort.enqueueionSort(); // do the enqueueion sort
		// System.out.println("Sorted Array");
		// simpleSort.display(); // display the array after bubble sort.

		//teststack();
		//teststackOnLL();
		// testQueue();
		// testLL();
		//testLLIterator();
		//binarySearch();
		mergeRecursive();
	}

	private static void mergeRecursive(){
		
		MergeRecursive  mergeRecursive = new MergeRecursive(10);
		mergeRecursive.insert(1);
		mergeRecursive.insert(10);
		mergeRecursive.insert(2);
		mergeRecursive.insert(9);
		mergeRecursive.insert(2);
		mergeRecursive.insert(8);
		mergeRecursive.insert(4);
		mergeRecursive.insert(7);
		mergeRecursive.insert(5);
		mergeRecursive.insert(6);
		
		mergeRecursive.display();
		
		mergeRecursive.mergeSort();
		System.out.println("merging");
		mergeRecursive.display();
	}
	
	private static void binarySearch(){
		
		BinarySearch binarySearch = new BinarySearch(10);
		binarySearch.insertSorted(1);
		binarySearch.insertSorted(10);
		binarySearch.insertSorted(2);
		binarySearch.insertSorted(9);
		binarySearch.insertSorted(3);
		binarySearch.insertSorted(8);
		binarySearch.insertSorted(4);
		binarySearch.insertSorted(7);
		binarySearch.insertSorted(5);
		binarySearch.insertSorted(6);
		
		if (binarySearch.find(5)){
			System.out.print("found" );
		}else{
			System.out.print("didn't find" );
		}
		
		
	}
	private static void  testLLIterator(){
		LinkList linkList = new LinkList();
		linkList.insertFirst(10);
		linkList.insertLast(20);
		linkList.insertLast(30);
		linkList.insertLast(40);
		linkList.insertLast(50);
		
		LinkList linkList2 = new LinkList();
		linkList2.insertFirst(150);
		linkList2.insertLast(140);
		linkList2.insertLast(130);
		linkList2.insertLast(120);
		linkList2.insertLast(110);
		
		LinkList.LinkListIterator llIter = linkList.new LinkListIterator();
		LinkList.LinkListIterator llIter2 = linkList2.new LinkListIterator();
		
		while (llIter.hasNext()){
			System.out.println(llIter.next());
			if (llIter2.hasNext()){
				System.out.println(llIter2.next());
			}
		}
		
		
	}
	private static void testLL() {
		LinkList linkList = new LinkList();

		linkList.insertFirst(10);
		linkList.insertLast(20);
		linkList.insertLast(30);
		linkList.insertLast(40);
		linkList.insertLast(50);
		linkList.displayList();

		System.out.println(linkList.removeLast().data);
		System.out.println(linkList.removeLast().data);
		System.out.println(linkList.removeLast().data);
		System.out.println(linkList.removeLast().data);
		System.out.println(linkList.removeLast().data);
	}

	private static void teststack() throws IOException {

		String s = getString();

		Stack stack = new Stack(50);

		boolean good = stack.checkDelimiters(s);
		System.out.println("String: " + s + " is ");
		if (good) {
			System.out.println("Balanced;");
		} else {
			System.out.println("Not Balanced;");
		}
	}

	private static void teststackOnLL() throws IOException {

		

		StackOnLL stack = new StackOnLL();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// String reversedString = stack.reverser(s);
		//
		// System.out.println("String : " + s + " reversed: "+reversedString);

	}

	/**
	 * 
	 * @return get input string from console
	 * @throws IOException
	 */
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	};

	private static void testQueue() {

		long data = 0;
		// Queue theQueue = new Queue(5); // queue holds 5 items
		QueueOnLL theQueue = new QueueOnLL(); // queue holds 5 items

		theQueue.enqueue(10); // enqueue 4 items
		theQueue.enqueue(30);
		theQueue.enqueue(20);
		theQueue.enqueue(40);

		System.out.println("\n added.");
		theQueue.displayQueue();

		data = theQueue.dequeue(); // dequeue 3 items
		System.out.println("\n removed " + data);

		data = theQueue.dequeue(); // (10, 20, 30)
		System.out.println("\n removed " + data);

		data = theQueue.dequeue();
		System.out.println("\n removed " + data);

		theQueue.enqueue(12); // enqueue 4 more items
		System.out.println("\n added 1");

		theQueue.enqueue(35); // (wraps around)
		System.out.println("\n added 2");

		theQueue.enqueue(8);
		System.out.println("\n added 3");

		theQueue.enqueue(80);
		System.out.println("\n added 4");

		while (!theQueue.isEmpty()) {
			System.out.println(theQueue.dequeue());
		}

	}// end testQueue
}
