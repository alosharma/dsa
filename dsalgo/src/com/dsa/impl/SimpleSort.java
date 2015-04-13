package com.dsa.impl;

public class SimpleSort extends BaseDsa{

	private long[] dataHolder; // reference to array a
	private int nElems; // number of data items
	/*
	 * Constructor
	 */
	public SimpleSort(int iMax){
		
		dataHolder = new long[iMax];  //initiate the data holder array
		nElems = 0;					  // no elements yet
	}
	
	/**
	 * Add data to array
	 * @param data
	 */
	public void add(long data){
		
		dataHolder[nElems]= data;	//Insert data into next position
		nElems ++;					// increment number of elements
	}
	
	/**
	 * Display all elements in the array.
	 */
	public void display(){

		for (int i= 0; i < dataHolder.length; i++){

			System.out.print(dataHolder[i] + "");
			System.out.println("");
		}
	}

	/**
	 * sort the array using bubble sort technique.
	 */
	public void bubbleSort(){
		
		boolean notAllSorterd = true;		//initialize this variable as true. Iterate through array until its all sorted.
		int iSortCount = 0;
		int ilOOPCount = 0;
		long temp;
		
		while (notAllSorterd){
			
			for (int J = 0; J < dataHolder.length -1; J++){
				if (dataHolder[J] > dataHolder[J+1] ){	// Check is current element is bigger then the next one.
					temp = dataHolder[J];				// if yes then swap.
					dataHolder[J] = dataHolder[J+1];
					dataHolder[J+1] = temp;
					iSortCount++;						// increment number of shuffling done.
				}//end if
				
			}// end for
			if (iSortCount == 0){
				notAllSorterd = false;					// if no shuffling done then, mark the boolean false and close the while loop. 
			}else{
				
				iSortCount = 0 ;						// reset the sort count to 0 for next for loop.
			}
			ilOOPCount ++;
		}//end while
		
		System.out.println("Number of times loop executed: " + ilOOPCount);
	} // end bubbleSort
	
	
	/**
	 * sort the array using selection sort technique.
	 */
	public void selectionSort(){
		
		long temp;
		for (int i = 0; i < dataHolder.length; i++){ 		//outer loop
			long referenceVal = dataHolder[i];					//take the first value as reference

			for (int j = i+1; j < dataHolder.length; j++){	// inner loop, starts from next pointer of outer loop start.
				
				if (referenceVal > dataHolder[j]){				// if next value is smaller than reference value then
					temp = referenceVal;
					referenceVal = dataHolder[j];				// make this as new reference value
					dataHolder[j] = temp;
					
				}
			}//end for
			
			dataHolder[i] =  referenceVal;						// make the smallest value as the first value in current loop.
			
		}// end for

	} // end selectionSort.
	
	/**
	 * sort the array using insertion sort technique.
	 */
	public void insertionSort(){
		long marker ;
		
		for (int i =1; i<dataHolder.length ; i++){		//forward loop
			marker = dataHolder[i];
			for (int j =i-1; j >= 0 ; j--){				//reverse loop
				
				if ( marker <  dataHolder[j]){
					dataHolder[j+1] = dataHolder[j];	//if marker is smaller then current value, move values to one place forward.
					dataHolder[j] = marker;				// insert marker in empty position
				}//end if
				
			}// end for	
			
		}// end for
		
	} // end insertionSort
	
}
