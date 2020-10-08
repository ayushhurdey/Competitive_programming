/*
Delete keys in a Linked list 
Medium Accuracy: 48.44% Submissions: 25628 Points: 4
Given a single linked list and an integer x. Your task is to complete the function
deleteAllOccurances() which deletes all occurences of a key x present in the linked
list. The function takes two arguments: the head of the linked list and an integer x.
The function should

Example 1:

Input:
LinkedList = 2->2->1->4->4
x = 4
Output: 2 2 1 
Example 2:

Input:
LinkedList = 1->2->2->3->2->3
x = 2
Output: 1 3 3
Explanation: Given number to delete is 2.
After deleting all occurrences of 2, we
have elements in the list as 1, 3, and 3.
 

Your Task:
The task is to complete the function deleteAllOccurances() which should delete
all the occurrences of given number x from the list and return the head of the
modified linked list.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
1 <= size of the linkedlist <= 100
1 <= x <= N
*/



/* Linked list Node
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class GfG
{
    public static Node deleteAllOccurances(Node head, int x)
    {
        // Your code here
        Node ptr = head;
        while(ptr.data == x)
           ptr = ptr.next;
        head = ptr;
        
        while(ptr.next != null){
            if(ptr.next.data == x)
                ptr.next = ptr.next.next;
            else
                ptr = ptr.next;
        }
        return head;
    }
}
