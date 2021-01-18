/*

Determine if Two Trees are Identical

Given two binary trees, the task is to find if both of them are identical or not. 

Example 1:

Input:
     1          1
   /   \      /   \
  2     3    2     3
Output: Yes
Explanation: There are two trees both
having 3 nodes and 2 edges, both trees
are identical having the root as 1,
left child of 1 is 2 and right child
of 1 is 3.

Example 2:

Input:
    1       1
  /  \     /  \
 2    3   3    2
Output: No
Explanation: There are two trees both
having 3 nodes and 2 edges, but both
trees are not identical.

Your task:
Since this is a functional problem you don't have to worry about input,
you just have to complete the function isIdentical() that takes two 
rootsas parameters and returns true or false. The printing is done by
the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 1000
1 <=Data of a node <= 1000
*/



class Tree
{   
    int flag = 0;
    void check(Node head1, Node head2){
        if(head1 == null && head2 == null)
            return;
            
        if(head1 == null || head2 == null){
            flag = 1;
            return;
        }
        
        if(head1.data != head2.data){
            flag = 1;
            return;
        }
        
        check(head1.left, head2.left);
        check(head1.right, head2.right);
    }
    
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    flag = 0;
	    check(root1, root2);
	    if(flag == 0)
	        return true;
	    else return false;
	}
	
}
