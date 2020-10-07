/*
Insert in a Sorted List 

Given a sorted singly linked list and a data, your task is to insert the data in the linked 
list in a sorted way i.e. order of the list doesn't change.

Example 1:

Input:
LinkedList: 25->36->47->58->69->80
data: 19
Output: 19 25 36 47 58 69 80
Example 2:

Input:
LinkedList: 50->100
data: 75
Output: 50 75 100
Your Task:
The task is to complete the function sortedInsert() which should insert the element in sorted
Linked List and return the head of the linked list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
-99999 <= A[i] <= 99999, for each valid i
 
*/



/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node ptr = head1;
        Node node = new Node(key);
        
        if(ptr.data >= key){
            node.next = head1;
            head1 = node;
            return head1;
        }
        
        while(ptr.next != null && ptr.next.data < key){
            ptr = ptr.next;
        }
        
        node.next = ptr.next;
        ptr.next = node;
        
        return head1;
    }
}
