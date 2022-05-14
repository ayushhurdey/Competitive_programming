/*
Intersection Point in Y Shapped Linked Lists 
Medium Accuracy: 49.55% Submissions: 77545 Points: 4
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List
            3
             \
              6
               \
                9    10
                 \  /
                  15
                    \
                     30
Above diagram shows an example with two linked list having 15 as intersection point.

Example 1:

Input:
LinkList1 = {10,20,5,10}
LinkList2 = {30,40,50,5,10}
Output: 5
Explanation:The point of intersection of
two linked list is 5, means both of them
get linked (intersects) with each other
at node whose value is 5.
Your Task:
The task is to complete the function intersetPoint() which finds the point of intersection of two linked list. The function should return data value of a node where two linked lists merge. If linked list do not merge at any point, then it should return -1.

Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
1 <= value <= 1000
*/



/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
*/

class Intersect
{
    int length(Node head){
        int length = 0;
        Node curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }
    
    Node forward(Node head, int count){
        while(count!=0){
            head = head.next;
            count--;
        }   
        return head;
    }
    
    
	int intersectPoint(Node headA, Node headB)
	{
         // code here
         int nodeALength = length(headA);
         int nodeBLength = length(headB);
         int ahead;
         if(nodeALength > nodeBLength){
             ahead = nodeALength - nodeBLength;
             headA = forward(headA,ahead);
             //System.out.println("\nNodeA: " + headA.data);
         }
         else if(nodeALength < nodeBLength){
             ahead = nodeBLength - nodeALength;
             headB = forward(headB,ahead);
             //System.out.println("\nNodeB: " + headB.data);
         }
         while(headA != null  &&  headB != null){
            if(headA == headB)
                return headA.data;
            headA = headA.next;
            headB = headB.next;
         }
         return -1;
	}
}



// Another Simple solution to find intersection point with two iterations only.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while(tempHeadA != tempHeadB){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            tempHeadA = tempHeadA == null ? headB : tempHeadA.next;
            tempHeadB = tempHeadB == null ? headA : tempHeadB.next;
        }
        
        return tempHeadA;
    }
}

