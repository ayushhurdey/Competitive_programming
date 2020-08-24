/*
Binary Tree to DLL 
                    
Problems
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

TreeToList

Example 1:

Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3 
Explanation: DLL would be 3<=>1<=>2
Example 2:

Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:  DLL would be 
40<=>20<=>60<=>10<=>30.
Your Task:
You don't have to take input. Complete the function bToDLL() that takes root node of the tree as a parameter and returns the head of DLL . The driver code prints the DLL both ways.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000
*/



class GfG
{
    // DLLInfo class could be treated as a tuple.
    private class DLLInfo{
        Node head,tail;
        DLLInfo(Node head,Node tail){
            this.head = head;
            this.tail = tail;
        }
    }
    
    DLLInfo treeToDLL(Node root){
        if(root == null)
            return  null;
        DLLInfo lDll= treeToDLL(root.left);
        DLLInfo rDll = treeToDLL(root.right);
        
        Node head = root , tail = root;   // default head and tails are root.
        
        // leftcase handling if not null
        if(lDll != null){
            head = lDll.head;
            lDll.tail.right = root;
            root.left = lDll.tail;
        }
        // rightcase handling if not null
        if(rDll != null){
            tail = rDll.tail;
            rDll.head.left = root;
            root.right = rDll.head;
        }
        
        return new DLLInfo(head,tail);
    }
    
    Node bToDLL(Node root)
    {
     	//  Your code here	
	    return treeToDLL(root).head;
	        
    }
}
