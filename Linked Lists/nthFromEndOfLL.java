/*
Nth node from end of linked list 

Given a linked list consisting of L nodes and given a number N. The task is to find the
Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end os 8.  
Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.
Your Task:
The task is to complete the function getNthFromLast() which takes two arguments:
reference to head and N and you need to return Nth from the end or -1 in case node
doesn't exist..

Note:
Try to solve in single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 103
1 <= N <= 103
*/



/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node slowptr;
    	Node fastptr = head;
    	int counter = 0, k = n;
        while(fastptr != null && n > 0){
            fastptr = fastptr.next;
            n -= 1;
            counter += 1;
        }

        if(counter != k && fastptr == null)
            return -1;
        slowptr = head;
        while(fastptr != null){
            fastptr = fastptr.next;
            slowptr = slowptr.next;
        }    
        return slowptr.data;
    }
}

