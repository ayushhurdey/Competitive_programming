/*

Reorder List
Hard Accuracy: 49.92% Submissions: 25769 Points: 8

Given a singly linked list: A0→A1→…→An-1→An, reorder it to:
A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the
nodes' values.

Example 1:

Input:
LinkedList: 1->2->3
Output: 1 3 2

Example 2:

Input:
LinkedList: 1->7->3->4
Output: 1 4 7 3.

Your Task:
The task is to complete the function reorderList() which should reorder 
the list as required. The reorder list is automatically printed by the
driver's code.

Note: Try to solve without using any auxilliary space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 104
*/


class gfg {
    Node reorderlist(Node head) {
        // Your code here
        if(head == null || head.next == null) 
            return head;
        
        
        // find the meddle element using slow and fast ptr.
        Node slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        // Reverse the list from slow ptr.
        Node curr = slow;
        Node prev = null, next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        
        //merge the two lists(direct & reversed)
        Node n1 = head, n2 = prev;
        
        while(n2.next != null){
            next = n1.next;
            n1.next = n2;
            n1 = next;
            
            next = n2.next;
            n2.next = n1;
            n2 = next;
        }
        
        return head;
    }
}


/*
APPROACH: 1. Find middle of the list.
          2. Now reverse the second half of the list.
          3. Combine both the lists
          
          E.g. 
           1 -> 2 -> 3 -> 4 -> 5
           
           After reversing second half.
           
                       null
                      /
           1 -> 2 ->  3  <- 4 <- 5
           |                     |
          n1                     n2
          
          
           Step 1). Insert n2 in n1.next
                        n2  n1
                         |  |
                    1 -> 5  2 -> 3 -> null
                         |       ^
                         4 ______|
          
                         &
                    Insert n1 in n2.next
                    1 -> 5 -> 2 -> 4 -> 3 -> null
*/ 
