/*
Find the Town Judge

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
*/


class Solution {
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int rows = trust.length;
        int[] childOfNode = new int[N+1];
        int[] occurenceOfNode = new int[N+1];
        Arrays.fill(childOfNode,0);
        Arrays.fill(occurenceOfNode,0);
        
        for(int []row : trust){
            ArrayList<Integer> l = map.getOrDefault(row[0], new ArrayList<Integer>());
            l.add(row[1]);
            map.put(row[0], l);
            childOfNode[row[0]] = map.get(row[0]).size();
            occurenceOfNode[row[1]]++;
        }
        
        for(int i = 1; i < N+1; i++){
            if(childOfNode[i] == 0 && occurenceOfNode[i] == N-1)
                return i;
        }
        return -1;
    }
}


/*
Eg  N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    then map : {1:[4,3], 2: [4,3], 4: [3]}
    indexes:          0  1  2  3  4
    childOfNode:     [0, 2, 2, 0, 1] -> maintains the size of list of each element in map.
    occurenceOfNode: [0, 0, 0, 3, 2] -> maintains the occurence of each element in all lists of map.
                               |------> when key does not exists and total occurence of any single element in every list of map = N-1
                                  
*/
