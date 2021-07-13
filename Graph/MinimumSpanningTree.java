/*

Minimum Spanning Tree
Medium Accuracy: 49.39% Submissions: 28670 Points: 4

Given a weighted, undirected and connected graph of V 
vertices and E edges. The task is to find the sum of 
weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.

Example 2:

Input:

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.

 

Your task:
Since this is a functional problem you don't have to worry about 
input, you just have to complete the function  spanningTree() 
which takes number of vertices V and an adjacency matrix adj as 
input parameters and returns an integer denoting the sum of weights 
of the edges of the Minimum Spanning Tree. Here adj[i] contains a list 
of lists containing two integers where the first integer j denotes
that there is an edge between i and j and second integer w denotes 
that the distance between edge i and j is w.
 

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V^2).
 
*/

// Time Comp: OVLogE);

   if(adj == null) return 0;
        int weight[] = new int[V];
        int parent[] = new int[V];
        boolean visited[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            weight[i] = 10000000;
            parent[i] = -1;
        }
        
        weight[0] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        minHeap.add(new Pair(0, weight[0]));
        
        for(int i = 0; i < V-1; i++){
            int u = minHeap.poll().vertex;
            visited[u] = true;
            
            for(ArrayList<Integer> each: adj.get(u)){
                int v = each.get(0);
                int wt = each.get(1);
                if(!visited[v] && wt < weight[v]){
                    weight[v] = wt;
                    parent[v] = u;
                    minHeap.add(new Pair(v, weight[v]));
                }
            }
        }
        
        int totalSpanningWeight = 0;
        for(int i = 1; i < V; i++){
            totalSpanningWeight += weight[i];
        }
        return totalSpanningWeight;
        
    }
