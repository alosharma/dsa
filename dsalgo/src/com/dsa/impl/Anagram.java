package com.dsa.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creates permutation and combinations of the given word i.e. creates anagram.
 */
public class Anagram {

	static int size;
	static int count; 
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException
	{
		System.out.print("Enter a word: "); // get word
		String input = getString();
		size = input.length(); // find its size
		count = 0;
		
		
		for(int j=0; j<size; j++) // put it in array
			arrChar[j] = input.charAt(j);
		doAnagram(size); // anagram it
		
		
	} // end main()

	// -----------------------------------------------------------

	public static void doAnagram(int newSize) {
		if (newSize == 1) { // if too small then dont go further, return.
			return;
		}
		for (int j = 0; j < newSize; j++) {
			doAnagram(newSize - 1); // anagram remaining
			if (newSize == 2) { // if innermost then display it
				displayWord();
			}// end if
			rotate(newSize); // rotate word
		}// end for
	}

	// ---------------------------------------------------------------------------------------------------

	/**
	 * rotate left all chars from position to end
	 * 
	 * @param newSize 
	 */
	private static void rotate(int newSize) {
		int j;
		
		int position = size - newSize;
		char temp = arrChar[position];		//save first letter
		
		for (j = position+1; j < size;j++){	// Shift others left
			
			arrChar[j-1] = arrChar[j];			
		}//end for	
		arrChar [j] = temp;					// put first on right
	//-------------------------------------------------------------		
	}
	private static void displayWord(){
		if(count < 99)
			System.out.print(" " );
		if(count < 9)
			System.out.print(" ");
		
		System.out.print(++count + " ");
		
		for (int j=0;j<size;j++){
			System.out.print(arrChar[j]);
		}//end for
		System.out.flush();
		if(count%6 == 0)
		System.out.println(" ");
	}
		
	//-------------------------------------------------------------

	private static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//-------------------------------------------------------------
	} // end class AnagramApp
