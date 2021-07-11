/*
310. Minimum Height Trees
Medium

A tree is an undirected graph in which any two vertices are 
connected by exactly one path. In other words, any connected
graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array
of n - 1 edges where edges[i] = [ai, bi] indicates that there 
is an undirected edge between the two nodes ai and bi in the 
tree, you can choose any node of the tree as the root. When 
you select a node x as the root, the result tree has height h.
Among all possible rooted trees, those with minimum height 
(i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the 
answer in any order.

The height of a rooted tree is the number of edges on the 
longest downward path between the root and a leaf.

 

Example 1:
       0             1            2         3     
       |           / | \          |         |
       1          0  2  3         1         1
      /  \                       / \       / \
     2    3                     0   3     0   2
 
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

Example 2:
         3                    4
     /  / \  \              /   \
    0   1  2  4            5     3
              |                / | \
              5               0  1  2
              
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]

Example 3:

Input: n = 1, edges = []
Output: [0]

Example 4:

Input: n = 2, edges = [[0,1]]
Output: [0,1]

 

Constraints:

    1 <= n <= 2 * 104
    edges.length == n - 1
    0 <= ai, bi < n
    ai != bi
    All the pairs (ai, bi) are distinct.
    The given input is guaranteed to be a tree and there will be no repeated edges.


*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int parent[] = new int[n];
        
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int[] each : edges){
            adjList.get(each[0]).add(each[1]);
            adjList.get(each[1]).add(each[0]);        
        }
        
        Arrays.fill(parent, -1);
        int leafOne = bfs(adjList, 0, parent);
        parent = new int[n];
        Arrays.fill(parent, -1);
        int leafTwo = bfs(adjList, leafOne,parent);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        int temp = leafTwo;
        while(temp != leafOne){
            path.add(temp);
            temp = parent[temp];
        }
        path.add(leafOne);
        
        List<Integer> result = new ArrayList<>();
        int pathLength = path.size();
        result.add(path.get(pathLength/2));
        if(pathLength % 2 == 0 ) result.add(path.get(pathLength/2 -1));
        
        return result;
    }
    
    private int bfs(ArrayList<ArrayList<Integer>> adjList, int start, int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int result = start;
        parent[start] = start;
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            result = first;
            
            for(int adj: adjList.get(first)){
                if(parent[adj] == -1){
                    queue.add(adj);
                    parent[adj] = first;
                }
            }
        }
        
        return result;
        
    }
}


/*
APPROACH: Find the longest leaf to leaf path and the mids of that will give the result.
          Now to find longest leaf to leaf path start bfs from 0th node, find the longest path's
          end one from this.
          Then from this latest end again do bfs as starting node and finally will get a
          second end of the longest path.
          Then just calculate the mid(s) of the path.
*/
