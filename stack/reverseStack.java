
/*Reverse a Stack without using any additional space.
 Approach :: So the approach is to pop top element from stack and recusively reverse the rest of the stack.
             and for doing this after recursively reversing, pop all elements from the stack and put the initially
             popped element in the empty stack and fill the stack at is was.
*/               


import java.io.*;
import java.util.*;

class GFG {
	static void printStack(Stack<Integer> s){
	    while(!s.empty()){
	        System.out.print(s.peek() + " ");
	        s.pop();
	    }     
	}
	
	static void reverseStack(Stack<Integer> s){
	    int x = 0;
	    if(!s.empty()){
	        x = s.peek();
	        s.pop();
	        reverseStack(s);
	        pushAtBottom(s,x);
	    }
	
	}
	
	static void pushAtBottom(Stack<Integer> s, int x){
	    int y = 0;
	    if(!s.empty()){
	        y = s.peek();
	        s.pop();
	        pushAtBottom(s,x);
	        s.push(y);
	    }
	    else
	        s.push(x);
	}
	
	public static void main (String[] args) {
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(1);
	    s.push(20);
	    s.push(3);
	    s.push(49);
	    s.push(30);
	    reverseStack(s);
	    printStack(s);
	}
}
