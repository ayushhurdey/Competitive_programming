/*
1046. Last Stone Weight
Easy

We have a collection of stones, each stone has 
a positive integer weight.

Each turn, we choose the two heaviest stones 
and smash them together.  Suppose the stones
have weights x and y with x <= y.  The result
of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally 
    destroyed, and the stone of weight y has new weight y-x.

At the end, there is at most 1 stone left.  Return 
the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's 
the value of last stone.

 

Note:

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000


*/


// O(nlogn) solution
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; 
            }
        });
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());   // this also works

        for(int i = 0; i < n; i++)
            maxHeap.add(stones[i]);
        
        while(maxHeap.size() > 1){
            int stoneOne = maxHeap.poll();
            int stoneTwo = maxHeap.poll();
            if(stoneOne != stoneTwo)
                maxHeap.add(Math.abs(stoneOne - stoneTwo));
        }
        return maxHeap.size() > 0 ? maxHeap.poll() : 0;
    }
}


/*
APPROACH: 
        This problem can be solved by sorting array also
        but the problem in that is that after smashing stones left
        weight stone has again to be inserted in sorted order
        and that can like O(n^2) time.
        
        So using Heap is better appraoch here because poll() and push()
        operation in heap are just O(logn) while at most we can iterate 
        to almost n times. So that gives TC to O(nlogn)
*/
