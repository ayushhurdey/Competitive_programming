/*
Insert in Middle of Linked List 

Given a linked list of size N and a key. The task is to insert the key in the middle of the linked list.

Example 1:

Input:
LinkedList = 1->2->4
key = 3
Output: 1 2 3 4
Explanation: The new element is inserted
after the current middle element in the
linked list.

Example 2:

Input:
LinkedList = 10->20->40->50
key = 30
Output: 10 20 30 40 50
Explanation: The new element is inserted
after the current middle element in the
linked list and Hence, the output is
10 20 30 40 50.
 

Your Task:
The task is to complete the function insertInMiddle() which takes head reference and element
to be inserted as the arguments. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 104
*/


/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        Node slowPtr = head;
        Node fastPtr = head;
        while(fastPtr != null && fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        Node newNode = new Node(data);
        newNode.next = slowPtr.next;
        slowPtr.next = newNode;
        
        return head;
    }
}

/*
Considerations: in 0 based index.
a):
1 -> 2 -> 3 -> 4 -> 5
inserted at index = 3
insert 8:
1 -> 2 -> 3 -> 8 -> 4 -> 5
               ^
               
b):
1 -> 2 -> 3 -> 4 -> 5 -> 6
inserted at index = 3
insert 8:
1 -> 2 -> 3 -> 8 -> 4 -> 5 -> 6
               ^
*/
