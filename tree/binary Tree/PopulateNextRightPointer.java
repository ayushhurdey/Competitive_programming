/**
117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next 
right node. If there is no next right node, the
 next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]

          1
        /  \
       3    4
     /  \    \
    4    5    7

         1 -> null
        /  \
       3 -->4 --> null
     /  \    \
    4 -->5 -->7 --> null
    
Explanation: Given the above binary tree (Figure A),
 your function should populate each next pointer to 
 point to its next right node, just like in Figure B.
 The serialized output is in level order as connected
 by the next pointers, with '#' signifying the end 
 of each level.

Example 2:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 6000].
    -100 <= Node.val <= 100

 

Follow-up:

    You may only use constant extra space.
    The recursive approach is fine. You may assume 
    implicit stack space does not count as extra space 
    for this problem.


 */


 /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            // for all nodes at a particular level only
            while(size-- != 0){ 
                Node top = queue.poll();
                if(size > 0)  // except for last node at each level
                     top.next = queue.peek();
                if(top.left != null)
                    queue.add(top.left);
                if(top.right != null)
                    queue.add(top.right);
            }
        }
        
        return root;
    }
}