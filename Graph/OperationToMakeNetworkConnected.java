/*
1319. Number of Operations to Make Network Connected
Medium

There are n computers numbered from 0 to n-1 connected by ethernet
cables connections forming a network where connections[i] = [a, b] 
represents a connection between computers a and b. Any computer can
reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain
cables between two directly connected computers, and place them between
any pair of disconnected computers to make them directly connected. 
Return the minimum number of times you need to do this in order to 
make all the computers connected. If it's not possible, return -1. 

 

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between 
computers 1 and 3.

Example 2:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2

Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.

Example 4:

Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
Output: 0

 

Constraints:

    1 <= n <= 10^5
    1 <= connections.length <= min(n*(n-1)/2, 10^5)
    connections[i].length == 2
    0 <= connections[i][0], connections[i][1] < n
    connections[i][0] != connections[i][1]
    There are no repeated connections.
    No two computers are connected by more than one cable.
*/


class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList<>();
        int noOfEdges = connections.length;
        boolean visited[] = new boolean[n];
        int components = 0;
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
      // making adjacency List out of edge List
        for(int[] edge: connections){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
      // DFS for disconnected components
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adjList, i, n, visited);
                components++;
            }
        }
        
        // required cables to connect k disconnected components = (k - 1)
        int requiredCables = components - 1;
        int extraCables = noOfEdges - (n - 1);    // (n-1) => minimum no of edges to connect all nodes of a graph
        return extraCables >= 0 ? requiredCables : -1;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adjList, int i, int n, boolean[] visited ){
        visited[i] = true;
        
        for(int each: adjList.get(i)){
            if(!visited[each]){
                dfs(adjList, each, n, visited);
            }
        }
    }
}

