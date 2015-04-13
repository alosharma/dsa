package com.dsa.impl;

public class MergeRecursive {

	int[] arrayInt;
	int current_size = 0; // current size of array. Number of data element.

	/** 
	 * Constructor to initialize the array with a specific size
	 * 
	 * @param sizee
	 */
	public MergeRecursive(int size) {
		arrayInt = new int[size];
	}

	// ---------------------------------------------------------------------------------------------------------

	/**
	 * Insert data into next available empty position
	 * 
	 * @param arrayElement
	 */
	public void insert(int arrayElement) {
		arrayInt[current_size++] = arrayElement;

	}

	// ---------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @return true if array is empty.
	 */
	public boolean isEmpty() {
		return current_size == 0;
	}

	// ---------------------------------------------------------------------------------------------------------
	/**
	 * Displaying all elements of array.
	 */
	public void display() {
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.println(arrayInt[i]);
		}
	}

	// ---------------------------------------------------------------------------------------------------------

	public void mergeSort() {
		int[] workSpace = new int[current_size];
		recursiveMerge(workSpace, 0, current_size - 1);
	}

	// ---------------------------------------------------------------------------------------------------------
	/**
	 * Recursively call the the method by breaking it in half then merge
	 * @param workSpace
	 * @param startIndex
	 * @param endIndex
	 */
	public void recursiveMerge(int[] workSpace, int startIndex, int endIndex) {

		int mid = 0;
		if (startIndex == endIndex) {
			return;
		}
		mid = (startIndex + endIndex) / 2;
		recursiveMerge(workSpace, startIndex, mid);
		recursiveMerge(workSpace, mid + 1, endIndex);

		merge(workSpace, startIndex,mid +1, endIndex);

	}

	/**
	 * 
	 * @param workSpace
	 * @param lowPtr
	 * @param highPtr
	 * @param upperBound
	 */
	private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items
		
		while (lowPtr <= mid && highPtr <= upperBound)
			if (arrayInt[lowPtr] < arrayInt[highPtr])
				workSpace[j++] = arrayInt[lowPtr++];
			else
				workSpace[j++] = arrayInt[highPtr++];
		
		while (lowPtr <= mid)
			workSpace[j++] = arrayInt[lowPtr++];
		
		while (highPtr <= upperBound)
			workSpace[j++] = arrayInt[highPtr++];
		
		for (j = 0; j < n; j++)
			arrayInt[lowerBound + j] = workSpace[j];
		
		
		
	} // end merge()
	// -----------------------------------------------------------

}
