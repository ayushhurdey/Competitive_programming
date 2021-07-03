/*
785. Is Graph Bipartite?


There is an undirected graph with n nodes, where each node 
is numbered between 0 and n - 1. You are given a 2D array 
graph, where graph[u] is an array of nodes that node u is 
adjacent to. More formally, for each v in graph[u], there 
is an undirected edge between node u and node v. The graph
has the following properties:

    There are no self-edges (graph[u] does not contain u).
    There are no parallel edges (graph[u] does not contain duplicate values).
    If v is in graph[u], then u is in graph[v] (the graph is undirected).
    The graph may not be connected, meaning there may be two nodes u and v such
      that there is no path between them.

A graph is bipartite if the nodes can be partitioned into two independent sets A and B 
such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:
          0--------------1
          |  \           |    
          |      \       |
          |           \  |
          3--------------2

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such 
that every edge connects a node in one and a node in the other.

Example 2:
          0--------------1
          |              |    
          |              |
          |              |
          3--------------2
          
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

 

Constraints:

    graph.length == n
    1 <= n <= 100
    0 <= graph[u].length < n
    0 <= graph[u][i] <= n - 1
    graph[u] does not contain u.
    All the values of graph[u] are unique.
    If graph[u] contains v, then graph[v] contains u.


*/


class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int color[] = new int[nodes];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < nodes; i++){
            if(color[i] == -1)
                if(!bfsColor(i,graph, color))   // if true keep going for another components of graph else stop.
                    return false;               // This condition is required for multi component graph otherwise   
        }                                       // simple `return bfsColor(i, graph, color)` would do the task.
        return true;
    }
    
    
    private boolean bfsColor(int currentNode, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        color[currentNode] = 1;
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            
            for(int adj: graph[top]){
                if(color[adj] == -1){
                    queue.add(adj);
                    color[adj] = 1 - color[top];
                }
                else if(color[adj] == color[top])    // if already colored but color of top and current node is same
                    return false;
            }
        }
        return true;
    }
}


// if a graph contains a cycle with odd no. of nodes then bipartite graph is not possible.
// But if a graph has a cycle with even no. of nodes then it may or may not be bipartite.
