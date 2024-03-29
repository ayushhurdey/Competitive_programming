/*
987. Vertical Order Traversal of a Binary Tree
Hard

Given the root of a binary tree, calculate the vertical order 
traversal of the binary tree.

For each node at position (row, col), its left and right children
will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of 
top-to-bottom orderings for each column index starting from
the leftmost column and ending on the rightmost column. 
There may be multiple nodes in the same row and same column.
In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:
            (0,0)
            3
          /  \ 
  (1,-1) 9    20 (1, 1)
             /   \
     (2,0) 15     7 (2,2)  
            
            
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

Example 2:

            1
          /   \
         2     3
       /  \   /  \
      4   5  6    7
      
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them 
          by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.

Example 3:

           1
          /   \
         2     3
       /  \   /  \
      4   6  5    7

Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same 
location and should be ordered by their values.

 

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 1000


*/




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


// DFS Approach: TC: O(logN * logN * logN * N)
// Leetcode(3ms)
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        
        dfs(root, 0, 0, map);
        for(TreeMap<Integer, PriorityQueue<Integer>> order: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> queue: order.values()){
                while(!queue.isEmpty()){
                    list.get(list.size()-1).add(queue.poll());
                }
            }
        }
        return list;
    }
    
    
    private void dfs(TreeNode current, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(current == null) return;
        
        if(!map.containsKey(y))
            map.put(y, new TreeMap<>());
        if(!map.get(y).containsKey(x))
            map.get(y).put(x, new PriorityQueue<>());
        map.get(y).get(x).add(current.val);
        
        dfs(current.left, x+1, y-1, map);
        dfs(current.right, x+1, y+1, map);
    }
}




// BFS Appraoch:   
// Leetcode(5ms)
class Solution {
    class Pair{
        TreeNode node;
        int verticalOrder;
        
        Pair(TreeNode node, int verticalOrder){
            this.node = node;
            this.verticalOrder = verticalOrder;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, PriorityQueue<Integer>> tempMap = new TreeMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int size = 1;
        
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            TreeNode node = top.node;
            int order = top.verticalOrder;
            tempMap.putIfAbsent(order, new PriorityQueue<>());
            tempMap.get(order).add(node.val);
            size--;
            
            if(node.left != null)
                queue.add(new Pair(node.left , order - 1));
            if(node.right != null)
                queue.add(new Pair(node.right , order + 1));
            if(size == 0){                       // when one level is complete
                size = queue.size();
                //adding to the map from tempMap
                for(Map.Entry<Integer, PriorityQueue<Integer>> each: tempMap.entrySet()){
                    map.putIfAbsent(each.getKey(), new ArrayList<>());
                    PriorityQueue<Integer> pq = each.getValue();
                    while(!pq.isEmpty()){
                        map.get(each.getKey()).add(pq.poll());
                    }
                }
                tempMap = new TreeMap<>();   // clearing the temporary Map
            }
        }
        return new ArrayList<List<Integer>>(map.values());
    }
}



