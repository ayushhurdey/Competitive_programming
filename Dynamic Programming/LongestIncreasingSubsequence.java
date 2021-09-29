/*
300. Longest Increasing Subsequence
Medium

Given an integer array nums, return the length of the longest 
strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array
by deleting some or no elements without changing the order of
the remaining elements. For example, [3,6,2,7] is a subsequence
of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 

Constraints:

    1 <= nums.length <= 2500
    -10^4 <= nums[i] <= 10^4

 
*/


// TC: O(n^2)  , SC: O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        int overallMax = 0;
        
        for(int i = 0; i < n; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && lis[j] > max){
                    max = lis[j];
                }
            }
            lis[i] = max + 1;
            
            overallMax = Math.max(overallMax, lis[i]);
        }
        
        return overallMax;
    }
}


/*
APPROACH:
     For every number in array we look on the left of it 
     to see the what sequence of numbers already makes the longest increasing 
     subsequence finising with the number on their particular index; 
     
      After calculating all this we see the max in the new array formed
      & the max out of it is the answer.
      
      Really Good Expanation here:
      Refer:  https://www.youtube.com/watch?v=odrfUCS9sQk
*/
