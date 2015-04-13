package com.dsa.impl;

/**
 * Implementation of stack data structure
 * @author alosharma
 *
 */
public class Stack extends BaseDsa {

	private int maxSize; 		// size of stack array
	private char[] stackArray;
	private int top; 			// top of stack
	
	/**
	 * Constructor
	 */
	public Stack(int s){
		super();
		
		maxSize = s;					// set array size
		stackArray = new char[maxSize];	// create array
		top = -1;						// no items yet
		
	}
	
	//------------------------------------------------------------------------------------------------//
	/**
	 * Inserts data into data.
	 * @param data
	 */
	public void push(char data){
		stackArray[++top] = data;		// insert into top of the array. 
	}

	
	//------------------------------------------------------------------------------------------------//
	/**
	 * Returns the data form top of the stack
	 * @return
	 */
	public char pop(){
		return stackArray[top--];		//return the top element then move the point one place down. 
	}
	
	//------------------------------------------------------------------------------------------------//
	
	
	/**
	 * 
	 * @return the data at the top of array.
	 */
	public long peek(){
		
		return stackArray[top];		   //peek at the top of the array
		
	}
	//------------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @return true is stack is full
	 */
	public boolean isFull(){
		
		return (top==maxSize-1);		 
		
	}
	/**
	 * 
	 * @return true is stack is empty
	 */
	public boolean isEmpty(){
		
		return (top == -1);
	}
	//------------------------------------------------------------------------------------------------//
	
	/**
	 * For a given string it will reverse and print the string
	 * @param inputStr
	 */
	public String reverser(String inputStr){
		
		String reversedStr = new String();
		
		for (int i=0; i< inputStr.length();i++){		// parse the string and push it in stack.
			
			this.push(inputStr.charAt(i));				
		}
		
		while (!this.isEmpty()){
			reversedStr = reversedStr + this.pop();		// pop and append it to output.
		}
		return reversedStr;
	}
	//------------------------------------------------------------------------------------------------//
	
	/**
	 * 
	 * @param delims
	 * @returns true is delimiters are balanced else false.
	 */
	public boolean checkDelimiters(String delims){
		
		for (int i=0;i< delims.length();i++){
			char ch = delims.charAt(i);

			switch (ch){							// if opening symbol then push them
			case '{':
			case '[':
			case '(':
				push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!isEmpty()){					// if closing symbol then check if corresponding opening symbol was encountered.

					char chx = pop();

					if( (ch=='}' && chx!='{') ||
							(ch==']' && chx!='[') ||
							(ch==')' && chx!='(') )
						System.out.println("Error: "+ch+" at "+i);
						return false;
				}//end if
				else // prematurely empty
					System.out.println("Error: "+ch+" at "+i);
					return false;
				
			default: // no action on other characters
				break;				
			} // end switch

		} //end for
		if (isEmpty()){
			return true;
		}else{
			return false;
		}
	}
			
		
		
	
	
}


