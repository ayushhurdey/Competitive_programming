/*
Delete node in Doubly Linked List 

Given a doubly linked list and a position. The task is to delete a node from given
position in a doubly linked list.

Example 1:

Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.
Example 2:

Input:
LinkedList = 1 <--> 5 <--> 2 <--> 9  
x = 1
Output: 5 2 9
Your Task:
The task is to complete the function deleteNode() which should delete the node at 
given position and return the head of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
2 <= size of the linked list <= 1000
1 <= x <= N
 
*/


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class GfG
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x){
	// Your code here
	    int i = 1;
	    Node ptr = head;
	    
	    if(x == 1){
	        ptr = ptr.next;
	        head = ptr;
	        ptr.prev = null;
	    }
	    else{
    	    while(i != x-1){
    	        ptr = ptr.next;
    	        i++;
    	    }
    	    ptr.next.prev = ptr;
    	    ptr.next = ptr.next.next;
	    }
	    return head;
    }
}
