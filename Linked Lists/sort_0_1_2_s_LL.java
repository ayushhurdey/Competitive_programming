/*
Given a linked list of 0s, 1s and 2s, sort it. 

Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. 
The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate 
to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the
linked list as asked in the problem statement and returns the head of the modified
linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
*/


/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/

class LinkedList
{
    static void printLL(Node head){
        while(head != null){
            System.out.print(" "+ head.data + " ");
            head = head.next;
        }
        System.out.print("\n");
    }
    
    static Node segregate(Node head)
    {
        // add your code here
       if(head.next == null) return head;
       Node curr = head;
       Node dummy0 = new Node(0);
       Node dummy1 = new Node(1);
       Node dummy2 = new Node(2);
       Node dummyZeroTail = dummy0;
       Node dummyZeroHead = dummy0;
       Node dummyOneTail = dummy1;
       Node dummyOneHead = dummy1;
       Node dummyTwoTail = dummy2;
       Node dummyTwoHead = dummy2;
       
       while(curr != null){
           if(curr.data == 0){
               dummyZeroTail.next = curr;
               dummyZeroTail = curr;
           }
           
           else if(curr.data == 1){
               dummyOneTail.next = curr;
               dummyOneTail = curr;
           }
           else{
               dummyTwoTail.next = curr;
               dummyTwoTail = curr;
           }
           curr = curr.next;
       }
       dummyTwoTail.next = null;
       
       dummyOneTail.next = dummyTwoHead.next;
       dummyZeroTail.next =dummyOneHead.next;
          
       return dummyZeroHead.next;    
    }
}
