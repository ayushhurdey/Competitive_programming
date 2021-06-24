/*

Topological sort
Medium Accuracy: 40.0% Submissions: 56979 Points: 4

Given a Directed Graph with V vertices and E edges, Find any 
Topological Sorting of that Graph.


Example 1:

Input:

       1
        \
         \.
         0 .--- 2
        .
       /
      3

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.

Example 2:

Input:
          4
       /    \
      .      .
      0      1
      .      |
      |      .
      5      1
      \     /
       .   .
       2-->3

Output:
1


Your Task:
You don't need to read input or print anything. Your task is to
complete the function topoSort()  which takes the integer V denoting
the number of vertices and adjacency list as input parameters and 
returns an array consisting of a the vertices in Topological order.
As there are multiple Topological orders possible, you may return any of them.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
2 ≤ V ≤ 10^4
1 ≤ E ≤ (N*(N-1))/2
*/



class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topologicalSort(i, adj, visited, stack);
            }
        }
        
        int i = 0;
        while(!stack.isEmpty()){
            arr[i++] = stack.pop();
        }
        return arr;
    }
    
    // ---------DFS Approach ---------
    private static void topologicalSort(int currentNode, 
                                        ArrayList<ArrayList<Integer>> graph,
                                        boolean[] visited,
                                        Stack<Integer> stack){
        visited[currentNode] = true;
        
        for(int adjacent: graph.get(currentNode)){
            if(!visited[adjacent]){
                topologicalSort(adjacent, graph, visited, stack);
            }
        }
        stack.push(currentNode);
    }
}






//---------- Kahn's Algorithm (BFS)----------

class Solution{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] topoSorted = new int[V];
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            for(int each: adj.get(i))
                indegree[each]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        
        int index = 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            topoSorted[index++] = top;
            
            for(int adjacent: adj.get(top)){
                indegree[adjacent]--;
                if(indegree[adjacent] == 0)
                    queue.add(adjacent);
            }
        }
        
        return topoSorted;
    }
}
