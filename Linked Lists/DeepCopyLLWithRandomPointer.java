/*
138. Copy List with Random Pointer

A linked list of length n is given such that each node 
contains an additional random pointer, which could point 
to any node in the list, or null.

Construct a deep copy of the list. The deep copy should 
consist of exactly n brand new nodes, where each new node 
has its value set to the value of its corresponding original
node. Both the next and random pointer of the new nodes 
should point to new nodes in the copied list such that the
pointers in the original list and copied list represent the
same list state. None of the pointers in the new list should
point to nodes in the original list.

For example, if there are two nodes X and Y in the original 
list, where X.random --> Y, then for the corresponding two 
nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list
of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) 
that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-10^4 <= Node.val <= 10^4
Node.random is null or is pointing to some node in the linked list.
*/


/*
// Definition for a Node.

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/




class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> map = new HashMap<>();
        Node newPrev = null;
        Node newHead = null;
        Node current = head;
        
        while(current != null){
            Node newNode  = new Node(current.val);
            newNode.random = current.random;
            
            if(newPrev == null)
                newHead = newNode;    // to return head for new LL
            else 
                newPrev.next = newNode;  // to make next pointer link in new LL
            
            map.put(current, newNode);
            newPrev = newNode;
            
            current = current.next;
        }
        
        
        Node newCurrent = newHead;
        
        while(newCurrent != null){
            if(newCurrent.random != null){
                newCurrent.random = map.get(newCurrent.random);
            }
            newCurrent = newCurrent.next;
        }
        
        return newHead;
    }
}



/*
APPROACH:
Runtime Complexity: Linear, O(n)
Memory Complexity: Linear, O(n)

This approach uses a map to track arbitrary nodes
pointed by the original list. You will create a deep 
copy of the original linked list (say list_orig) in two passes.

In the first pass, create a copy of the original linked list.
While creating this copy, use the same values for data and 
arbitrary_pointer in the new list. Also, keep updating the map 
with entries where the key is the address to the old node and 
the value is the address of the new node.

Once the copy has been created, do another pass on the copied 
linked list and update arbitrary pointers to the new address 
using the map created in the first pass.
*/
