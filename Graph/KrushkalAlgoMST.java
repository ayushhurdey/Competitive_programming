
/**
Given an undirected connected graph with weighted edges.
Find the cost of MST.

Sample input:
[(1,2,5),(2,3,2),(3,4,8),(4,1,5)]
Each contains edges in format -> (from, to, weight)
output: 12
**/


import java.util.*;

class Mst{
  public static void main(String[] args){
    //int arr[][] = {{1,2,5}, {2,3,2}, {3,4,8}, {4,1,5}};
    int arr[][] = {{1,2,3}, {1,3,4}, {2,4,1}, {1,5,8}, {2,5,2}, {3,4,6}, {3,5,6}, {4,5,2}};
    System.out.println(krushkal(5, arr));
  }

  static class Node{
    int from;
    int to;
    int weight;
    Node(int from, int to, int weight){
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  static class DSUF{
    int parent;
    int rank;
    DSUF(int parent, int rank){
      this.parent = parent;
      this.rank = rank;
    }
  }

  static int krushkal(int v, int[][] edgeList){
      PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
      
      // building a min heap according to weighs of edges
      for(int edge[]: edgeList){
        minHeap.add(new Node(edge[0]-1, edge[1]-1, edge[2]));
      }

      // initiating Disjoint Set elements
      DSUF[] dsuf = new DSUF[v];
      for(int i = 0; i < v; i++){
        dsuf[i] = new DSUF(-1, 0);
      }

      int mst = 0;
      
      while(!minHeap.isEmpty()){
        Node top = minHeap.poll();
        int parentX = find(dsuf, top.from);
        int parentY = find(dsuf, top.to);
            
        if(parentX != parentY){
          union(dsuf, parentX, parentY);
          mst += top.weight;
        }
      }
      
      return mst;
  }

  static int find(DSUF[] dsuf, int key){
    if(dsuf[key].parent == -1)
      return key;
    return dsuf[key].parent = find(dsuf, dsuf[key].parent);
  }

  static void union(DSUF[] dsuf, int x, int y){
    if(dsuf[x].rank > dsuf[y].rank)
      dsuf[y].parent = x;
    else if(dsuf[y].rank > dsuf[x].rank)
      dsuf[x].parent = y;
    else{
      dsuf[x].parent = y;
      dsuf[y].rank++;
    } 
  }

}
