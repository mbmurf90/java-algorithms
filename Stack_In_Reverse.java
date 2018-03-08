package Stacks;
import java.util.Scanner;

public class Stack_In_Reverse 
{

	// Below is a recursive function that inserts an element
	// at the bottom of a stack.
	static void insert_at_bottom(int x)
	{
	
		if(myStack.isEmpty())
			myStack.push(x);
	
		else
		{
			/* All items are held in Function Call Stack until we
			reach end of the stack. When the stack becomes
			empty, the st.size() becomes 0, the
			above if part is executed and the item is inserted
			at the bottom */
				
			int a = myStack.peek();
			myStack.pop();
			insert_at_bottom(x);
	
			//Push all the items held in Function Call Stack
			//once the item is inserted at the bottom
			myStack.push(a);
		}
	}
	
	// Below is the function that reverses the given stack using
	// insert_at_bottom()
	static void reverse()
	{
		if(myStack.size() > 0)
		{
			/* Hold all items in Function Call Stack until we
			reach end of the stack */
			int x = myStack.peek();
			
			myStack.pop();
			reverse();
			
			/* Insert all the items held in Function Call Stack
			one by one from the bottom to top. Every item is
			inserted at the bottom */
			insert_at_bottom(x);
		}
	}
	
	// Driver method
	public static void main(String[] args) 
	{
		//NOTE: I expect the code Friday to look something like
		//the three lines below commented out.
		
		//Scanner sc = new Scanner(System.in);
        //Call in a single string and split by spaces
        //String D = sc.next().split(" ");
		//Using Stack class for stack implementation
	    Stack myStack = new Stack(4);
		
		String D = "North South East West";
		//Push elements into the stack
		myStack.push(Integer.parseInt(D.substring(0,5)));
		myStack.push(Integer.parseInt(D.substring(6,12)));
		myStack.push(Integer.parseInt(D.substring(12,16)));
		myStack.push(Integer.parseInt(D.substring(17,21)));
		
		System.out.println("Directions:");
		
		System.out.println(myStack);
		
		//Function to reverse the stack
		reverse();
		
		System.out.println("\nDirections reversed:");
		
		System.out.println(myStack);
	}

}

class Stack
{
	//stores how big the array can possibly get
    private int maxsize;
    
    //Stores an array stack
    private int[] stackArray;
    
    //To track where is the top of the stack
    private int top;

    //Constructor for the stack, initialises the array of the size of size
    public Stack(int size)
    {
        maxsize = size;
        stackArray = new int[maxsize];
        
        //set to -1 before an array can be referenced, as array elements start at 0
        top = -1;
    }
    
    //place integer x into the top of the stack
    public void push(int x)
    {
    	//increment up stack
        top++;
        
        //place x at top of the stack
        stackArray[top] = x;
    }
    
    //take whatever is in the top of the stack out of it
    public int pop()
    {
    	//
        return stackArray[top--];
    }
    
    //look at whatever is in the top of the array
    public int peek()
    {
        return stackArray[top];
    }
    
    //check if stack is empty
    public boolean isEmpty()
    {
        return(top == -1);
    }
    
    //check if stack is full
    public boolean isFull()
    {
        return(top == maxsize -1);        
    }
    
    //doesn't actually empty stack, but overrides what
    //information storage starting at bottom of stack.
    public void makeEmpty()
    {
        top = -1;
    }
}