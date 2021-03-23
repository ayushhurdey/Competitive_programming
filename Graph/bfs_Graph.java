/*

BFS of graph
Easy Accuracy: 42.71% Submissions: 85312 Points: 2

Given a directed graph. The task is to do Breadth First 
Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's 
an edge from u to v and find the BFS traversal of the graph
starting from the 0th vertex, from left to right according 
to the graph. Also, you should only take nodes directly or 
indirectly connected from Node 0 in consideration.


Example 1:  
               0
           /   |  \
          *    *   *
          1    2   3
               |
               *
               4                  * ---> denotes down Arrow
Input:

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.

Example 2:
        
        0
       / \
      *   *
      1   2                      * ---> denotes down Arrow
      
Input:

Output: 0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2 3 4. 


Your task:
You don’t need to read input or print anything. Your task 
is to complete the function bfsOfGraph() which takes the 
integer V denoting the number of vertices and adjacency 
list as input parameters and returns  a list  containing
the BFS traversal of the graph starting from the 0th vertex 
from left to right.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 104
*/



// FOR connected Graphs only(not containing any unreachable vertices or vertices with outdegree = 0)
class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited =  new boolean[V+1];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        //for(int i = 0; i < V; i++){
        //    if(visited[i] != true)
            q.add(0);
            while(!q.isEmpty()){
                int front = q.poll();
                if(visited[front] == false)   // multiple non-distinct elements are added to queue 
                    list.add(front);          // and printed multiple times, without this condition
                visited[front] = true;
                
                ArrayList<Integer> adjVertexes = adj.get(front);
                for(int vertex: adjVertexes){
                    if(visited[vertex] != true)
                        q.add(vertex);
                }
            }
        //}
        return list;
    }
}



// For Disconnnected GRAPHS
class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited =  new boolean[V+1];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        for(int i = 0; i < V; i++){          // We need to iterate to each vertex at least once
            if(visited[i] != true)           // to ensure every vertex is visited in disconnected graph.
                q.add(i);
            while(!q.isEmpty()){
                int front = q.poll();
                if(visited[front] == false)   // multiple non-distinct elements are added to queue 
                    list.add(front);          // and printed multiple times, without this condition
                visited[front] = true;
                
                ArrayList<Integer> adjVertexes = adj.get(front);
                for(int vertex: adjVertexes){
                    if(visited[vertex] != true)
                        q.add(vertex);
                }
            }
        }
        return list;
    }
}
