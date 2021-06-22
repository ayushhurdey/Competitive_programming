/*
Leetcode
462. Minimum Moves to Equal Array Elements II

Given an integer array nums of size n, return the minimum number of moves 
required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

Example 2:

Input: nums = [1,10,2,9]
Output: 16

 

Constraints:

    n == nums.length
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9


*/


class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int median = nums[nums.length / 2];
        
        int minMoves = 0;
        for(int i = 0; i < nums.length ; i++){
            minMoves += Math.abs(median - nums[i]);
        }
        
        return minMoves;
    }
}


// Second Approach --> looks differnt but same mathematically.
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length -1;
        int minMoves = 0;
        while(i < j){
            minMoves += nums[j] - nums[i];
            i++;
            j--;
        }
        return minMoves;
    }
}



/*
Proof of second Approach:
Assume all nums will finally be modified to some value C in the middle of the array, 
so we need to sum the diff of all nums larger than C, and all nums less than C, so it 
transforms to: 
(nums[n-1]-C) + (nums[n-2]-C) +....+ (C-nums[mid-1]) + (C-nums[mid-2]) +...+ (C-nums[0]) = 
(nums[n-1]-nums[0]) + (nums[n-2]-nums[1]) +....
*/
