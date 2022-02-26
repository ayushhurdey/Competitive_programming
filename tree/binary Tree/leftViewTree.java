/*
Left View of Binary Tree
                              
Problems
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2         3
   /     \    /  \
  4     5   6     7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:
          10
         /  \
        20   30
       /  \
      40   60 

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
*/

class Tree
{
    static int maxLevel= -1;
    void leftView(Node root)
    {
      // Your code here
      if(root == null) return;
      maxLevel = -1;
      leftViewUtil(root,0);
      
    }
    
    void leftViewUtil(Node root,int level){
        if(root == null) return;
        if(level > maxLevel){
            //System.out.println("\nLevel and maxLevel = " + level + " " + maxLevel);
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        //System.out.print("\nbefore left Level = " + level+" ,max Level="+maxLevel);
        leftViewUtil(root.left, level+1);
        //System.out.print("\nbefore right Level = " + level+" ,max Level="+maxLevel);
        leftViewUtil(root.right, level+1);
        
    }
}

/*
Hint: Draw Horizontal levels. Starting with -1(i.e null level).
      Maintain maxLevelAchievedSoFar to track the maximum level achieved
        that will be helpful when right subtree's height > left subtree height.
        Increase level each time you traverse to left or right subtree.
*/
