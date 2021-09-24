/*
234. Palindrome Linked List
Easy

Given the head of a singly linked list, return true if it is a palindrome.


Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false


Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

 
*/


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
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }      
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
       slow = reverse(slow);
       fast = head;
       while(slow != null && fast != null){
           if(slow.val != fast.val)
               return false;
           slow = slow.next;
           fast = fast.next;
       }
        return true;
    }
}


/*
APPROACH:
   1. Find middle element
   2. Reverse the list from right of middle element.
   3. Check in both ends(one from start of list & another from middle element) if the list is same or not.
*/
