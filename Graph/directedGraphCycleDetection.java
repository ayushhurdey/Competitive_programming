/*

Detect cycle in a directed graph
Medium Accuracy: 30.19% Submissions: 100k+ Points: 4

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:
  0-------> 1
            |
 ___        |
 \ /        ''
  3<--------2

self cycle on 3

Output: 1
Explanation: 3 -> 3 is a cycle


Example 2:

Input:
0-------> 1
          |
          |
         ''
          2

Output: 0
Explanation: no cycle in the graph


Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
*/



class Solution 
{
    //Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        
        for(int i = 0 ; i < V; i++){
            if(!visited[i])
                if(cycleDirected(i, adj, visited, dfsVisited))
                    return true; 
        }
        return false;
    }
    
    private boolean cycleDirected(int currentNode, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] dfsVisited){
        visited[currentNode] = true;
        dfsVisited[currentNode] = true;
        
        for(int adj: graph.get(currentNode)){
            if(!visited[adj]){
                if(cycleDirected(adj, graph, visited, dfsVisited)){ return true; }
            }
            else if(dfsVisited[adj])
                return true;
        }
        dfsVisited[currentNode] = false;
        return false;
    }
}


/*Two visited nodes are required to keep track of visited nodes and visited by DFS nodes (beacuse
  it is possible that a node can be reached during DFS from multiple paths but there is no cycle 
  in that case but if we take only one visited array it will consider it as cycle which is wrong.)
  
  The way DFS works is it makes a tree like structure while visiting each node(in depth) and we
  detect a cycle if there is any back edge from any node to any of its ancestor.
*/

