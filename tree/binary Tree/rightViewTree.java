/*
Right View of Binary Tree 

Problems
Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60
Your Task:
Just complete the function rightView() that takes node as parameter and prints the right view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105.
 
*/


class Tree{
    void rightView(Node node) {
        //add code here.
        if(node == null) return;
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(node);
        int counter = q.size();
        
        while(q.size() > 0){
            Node curr = q.poll();
            counter--;
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
            if(counter == 0){
                System.out.print(curr.data + " ");
                counter = q.size();
            }    
        }
    }
}
