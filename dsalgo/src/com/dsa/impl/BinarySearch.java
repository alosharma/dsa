package com.dsa.impl;

public class BinarySearch {

	public int arrString[];

	/**
	 * Constructor to create the array
	 * 
	 * @param arraySize
	 */
	public BinarySearch(int arraySize) {
		arrString = new int[arraySize];

	}

	/**
	 * Insert the data into in sorted form
	 * 
	 * @param input
	 */
	public void insertSorted(int input) {

		for (int i = 0; i < arrString.length; i++) {
			if (arrString[i] ==0){			// first entry in array;
				arrString[i] = input;	
				break;
			}
			if (arrString[i] > input) {
				for (int j = arrString.length -2 ; j > i-1; j--) { // traverse from
																// end of the
																// array and
																// make space
																// for input
																// by moving all
																// the elements
																// a space up
					arrString[j + 1] = arrString[j];
				}
				arrString[i] = input; // all elements have moved up. Insert
										// input to current location
				break; // and break the loop.
			}
			
		}
	}

	// --------------------------------------------------------------------------------------------------------------
	/**
	 * This method will called to search for an entry in array
	 * @param data
	 * @return
	 */
	public boolean find(int data) {
		return find(data, 0, 0);			// call real finder method
	}

	// --------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param data
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public boolean find(int data, int lowerBound, int upperBound) {
		boolean result = false;
		int midPoint = 0; // initialize the mid point of an array.
		if (lowerBound == 0 && upperBound == 0) {
			upperBound = arrString.length; // set the upper bound for first
											// call.
		}

		midPoint = (lowerBound + upperBound) / 2;
		if (midPoint==lowerBound ||midPoint==upperBound ){
			return result;
		}
		if (data == midPoint) {
			return true; // found the data in array;
		}
		if (data > midPoint) {
			find(data, midPoint, upperBound); // move to upper half and call
												// this method recursively
		}
		if (data < midPoint) {
			find(data, lowerBound, midPoint); // move to lower half and call
												// this method recursively
		}

		return result;
	}
	// --------------------------------------------------------------------------------------------------------------
}
