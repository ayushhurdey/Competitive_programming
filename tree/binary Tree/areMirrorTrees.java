/*
Check if two binary trees given are mirror tres or not.
Mirror Trees:
     10                         10
    /   \                      /   \
   20    30         ==>       30    20
  /  \                             /  \ 
 40   50                          50   40
*/


class mirror{
      static boolean isMirror(Node root1,Node root2){
              if(root1 == null && root2 == null)
                  return true;
              if(root1 == null || root2 == null)
                  return false;
              return (root1.data == root2.data) &&
                     isMirror(root1.left,root2.right) &&
                     isMirror(root1.right, root2.left);
      }
} 
