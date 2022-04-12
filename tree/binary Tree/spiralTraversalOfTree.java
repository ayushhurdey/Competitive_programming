/*
Level order traversal in spiral form.
                                  
Problems
Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105
*/


class Spiral
{     
      void printArrayList(ArrayList<Integer> arr, Boolean leftToRight){
            if(leftToRight)
                for(int x : arr)
                    System.out.print(x + " ");
            else
               for(int i = arr.size()-1; i>=0; i--)
                    System.out.print(arr.get(i)+" ");
      }
      
      void printSpiral(Node node) 
      {
           // Your code here
           if(node == null) return;
           LinkedList<Node> q = new LinkedList<Node>();
           ArrayList<Integer> elemAtLevel = new ArrayList<Integer>();
           q.add(node);
           int counter = q.size();
           Boolean leftToRight = false;
           
           while(q.size() > 0){
               Node curr = q.poll();
               elemAtLevel.add(curr.data);
               counter--;
               if(curr.left != null)
                    q.add(curr.left);
               if(curr.right != null)
                    q.add(curr.right);
               if(counter == 0){
                   printArrayList(elemAtLevel, leftToRight);
                   counter = q.size();
                   elemAtLevel = new ArrayList<Integer>();
                   leftToRight = !leftToRight;
               }
           }
      }
}

/*
Whenever counter = 0   => level is over.
  if leftToRight = true;
      print from left to right
  else
      print from right to left.
  counter = size(Queue); 
*/




//Another Similar Solution, with slightly less Time complexity
// LEETCODE: 103


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {  
        List<List<Integer>> listOfList = new ArrayList<>();
        
        if(root == null)
            return listOfList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; 
        int size = 1;
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){           
            TreeNode top = queue.poll();
            
            if(leftToRight)
                list.add(top.val);
            else
                list.add(0, top.val);
            size--;
            
            if(top.left != null)
                queue.add(top.left);
            if(top.right != null)
                queue.add(top.right);
            
            if(size == 0){
                listOfList.add(List.copyOf(list));
                leftToRight = !leftToRight;
                size = queue.size();
                list.clear();
            }   
        }
        return listOfList;
    }
}