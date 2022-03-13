/* 
LEETCODE:

128. Longest Consecutive Sequence
Medium

Given an unsorted array of integers nums,
 return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements
 sequence is [1, 2, 3, 4]. Therefore its length is 4.


Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9

*/



// Time complexity : O(n)
class Solution {
    private int maxLCS = 1;
    private Map<Integer, Integer> map = new HashMap<>();
    
    private int LCS(int val){
        if(!map.containsKey(val))
            return 0;
        
        if(map.get(val) > 1)
            return map.get(val);    
        
        int lcsLen = LCS(val - 1) + 1; 
        map.put(val, lcsLen);
        maxLCS = Math.max(maxLCS, lcsLen);
        return lcsLen;
    }
    
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        
        // initially for each number LCS is 1 by default.
        for(int num: nums){
            map.put(num, 1);
        }
        
        for(int i = 0; i < len; i++)
            LCS(nums[i]);
        
        return maxLCS;
        
    }
}

/*
APPROACH:
    For each value in the array maintain the longest consecutive sequence
    and keep updating for further values based on previous values.
 */