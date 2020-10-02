/*
Finding middle element in a linked list 
Basic Accuracy: 47.37% Submissions: 100k+ Points: 1
Given a singly linked list of N nodes. The task is to find the middle of the linked list.
For example, if given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print the second
middle element. For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.

Example 1:

Input:
LinkedList: 1->2->3->4->5
Output: 3

Example 2: 

Input:
LinkedList: 2->4->6->7->5->1
Output: 7
Your Task:
The task is to complete the function getMiddle() which takes a head reference as the only 
argument and should return the data at the middle node of the linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 5000
*/


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    int getMiddle(Node head)
    {
        // Your code here.
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }    
        return slow.data;
         
    }
}
