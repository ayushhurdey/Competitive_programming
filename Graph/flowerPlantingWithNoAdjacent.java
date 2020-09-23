/*
 Flower Planting With No Adjacent

You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens 
connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower
planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is
guaranteed an answer exists.

 

Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Example 2:

Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 

Note:

1 <= N <= 10000
0 <= paths.size <= 20000
No garden has 4 or more paths coming into or leaving it.
It is guaranteed an answer exists.
*/


class Solution {
    // making undirected graph
    HashMap<Integer,ArrayList<Integer>> createAdjList(int [][]paths){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int []row : paths){
            ArrayList<Integer> l = map.getOrDefault(row[0], new ArrayList<Integer>());
            l.add(row[1]);
            map.put(row[0],l);
            ArrayList<Integer> l1 = map.getOrDefault(row[1], new ArrayList<Integer>());
            l1.add(row[0]);
            map.put(row[1],l1);
        }
        return map;
    }
    
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, ArrayList<Integer>> graph = createAdjList(paths);
        int  []garden = new int[N];
        Arrays.fill(garden, 0);
        for(int i =1; i <= N; i++){
            ArrayList<Integer> neighbours = graph.getOrDefault(i, new ArrayList<Integer>(Arrays.asList(i)));
            HashSet<Integer> plantedFlowers = new HashSet<Integer>();
            for(int neighbour : neighbours){
                if(garden[neighbour-1] != 0)
                    plantedFlowers.add(garden[neighbour-1]);
            }
            for(int j = 1; j <= 4; j++){
                if(!plantedFlowers.contains(j)){
                    garden[i-1] = j;
                    break;
                }
            }
        }
        return garden;
    }
}

