/*

Implementing Dijkstra Algorithm
Medium Accuracy: 49.0% Submissions: 37164 Points: 4

Given a weighted, undirected and connected graph of V vertices
and E edges, Find the shortest distance of all the vertex's 
from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.

Example 1:

Input:
    [[[1,9]]]
      
          Graph:
                    9
 Source--->    0----------1
    
S = 0

Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.

Example 2:

Input:
    [
      [[2,6],[1,1]],
      [[0,1],[2,3]],
      [[0,6],[1,3]]
    ]
    
    Graph:
        0
   1 /    \ 3
    /      \
   1--------2    <-- Source
       3
    
S = 2
Output:
4 3 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The other distances are pretty straight-forward.

 

Your Task:
You don't need to read input or print anything. Your task is to 
complete the function dijkstra()  which takes number of vertices
V and an adjacency list adj as input parameters and returns a list
of integers, where ith integer denotes the shortest distance of 
the ith node from Source node. Here adj[i] contains a list of 
lists containing two integers where the first integer j denotes 
that there is an edge between i and j and second integer w denotes
that the weight between edge i and j is w.

 

Expected Time Complexity: O(V^2).
Expected Auxiliary Space: O(V^2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
0 ≤ S < V
*/




class Solution
{
    static class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int vertices = adj.size();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        int weights[] = new int[vertices];
        boolean[] done  = new boolean[vertices];   // for vertices which have the minimum distance already
        
        for(int i =0; i < vertices; i++)
            weights[i] = Integer.MAX_VALUE;
        
        pq.add(new Node(S, 0));
        weights[S] = 0;
        done[S] = true;
        
        while(pq.size() > 0){
            Node min = pq.poll();

            for(ArrayList<Integer> neighbour: adj.get(min.vertex)){
                if(!done[neighbour.get(0)] && weights[neighbour.get(0)] > weights[min.vertex] + neighbour.get(1)){
                    weights[neighbour.get(0)] = weights[min.vertex] + neighbour.get(1);
                    pq.add(new Node(neighbour.get(0), weights[neighbour.get(0)]));
                }
            }
            done[min.vertex] = true;
        }
        
        return weights;
    }
}
