/*
Merge two sorted linked lists 
Easy Accuracy: 49.26% Submissions: 52378 Points: 2
Given two sorted linked lists consisting of N and M nodes respectively.
The task is to merge both of the list (in-place) and return head of the merged list.
Note: It is strongly recommended to do merging in-place using O(1) extra space.

Example 1:

Input:
N = 4, M = 3 
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40
Explanation: After merging the two linked
lists, we have merged list as 2, 3, 5,]
10, 15, 20, 40.
Example 2:

Input:
N = 2, M = 2
valueN[] = {1,1}
valueM[] = {2,4}
Output:1 1 2 4
Explanation: After merging the given two
linked list , we have 1, 1, 2, 4 as
output.
Your Task:
The task is to complete the function sortedMerge() which takes references to the 
heads of two linked lists as the arguments and returns the head of merged linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N, M <= 104
1 <= Node's data <= 105
 
*/



/*
  Merge two linked lists head pointer input could be NULL as well for empty list.
  Node is defined as 
    class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
*/

class LinkedList{
    Node sortedMerge(Node head1, Node head2) {
        //code here.
        Node dummyNode = new Node(-1);
        Node lastptr = dummyNode;
            
        while(head1 != null && head2 != null){
            if(head2.data > head1.data){ 
                lastptr.next = head1;
                lastptr = head1;
                head1 = head1.next;
            }
            else{
                lastptr.next = head2;
                lastptr = head2;
                head2 = head2.next;
            }   
        }
        if(head1 == null)
            lastptr.next = head2;
        if(head2 == null)
            lastptr.next = head1;
        return dummyNode.next;
    }
}

/*
Explanation:
     Create a dummy node that points to the smaller head initially(out of two LL) and 
     a lastPointer to attach the next greater element node to the next of lastPointer.

TIP: Is is always beneficial to take into consideration the use of dummyNode in LL 
     to make things simple, short and fast.
*/




// Solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                ptr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            else{
                ptr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
             ptr = ptr.next;
        }
        
        if(list1 != null){
           ptr.next = list1;
        }
        else{
            ptr.next = list2;
        }
        
        return dummy.next;
    }
}

