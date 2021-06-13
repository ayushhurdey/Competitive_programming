/*

Detect cycle in an undirected graph
Medium Accuracy: 35.66% Submissions: 87523 Points: 4

Given an undirected graph with V vertices and E edges, 
check whether it contains any cycle or not. 

Example 1:

Input:   
V E
5 5
Edges:
0 4
1 2
1 4
2 3
3 4

Output: 1
Explanation: 1->2->3->4->1 is a cycle.

Example 2:

Input: 
V E
4 2
Edges:
1 2
2 3

              Graphical Representation:
                 0  
            1-----------2
                       /
                      3 

Output: 0
Explanation: No cycle in the graph.

 

Your Task:
You don't need to read or print anything. Your task is to complete
the function isCycle() which takes V denoting the number of vertices
and adjacency list as input parameters and returns a boolean value 
denoting if the undirected graph contains any cycle or not.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 ≤ V, E ≤ 10^5
*/


// BFS Solution
class Solution
{
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    private boolean bfsCycle(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(curr, -1));
        vis[curr] = true;
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int parent = pair.second;
            
            for(int each: adj.get(pair.first)){
                /* ---- this logic also works ------*/
                // if(each != parent && vis[each])
                //     return true;
                // if(!vis[each]){
                //     queue.add(new Pair(each, pair.first));
                //     vis[each] = true;    
                // }
                
                if(!vis[each]){
                    queue.add(new Pair(each, pair.first));
                    vis[each] = true;
                }
                else if(parent != each) return true;
            }
        }
        return false;
        
    }
  
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] vis = new boolean[V+1];
        Arrays.fill(vis, false);
        
        for(int i = 0; i < V; i++){
            if(!vis[i])
                if(bfsCycle(i, vis, adj))
                    return true;
        }
        
        return false;
    }
}

