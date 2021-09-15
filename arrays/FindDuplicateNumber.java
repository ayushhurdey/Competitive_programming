/*
287. Find the Duplicate Number
Medium

Given an array of integers nums containing n + 1 integers where each
integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses 
only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [1,1]
Output: 1

Example 4:
Input: nums = [1,1,2]
Output: 1

Constraints:

    1 <= n <= 10^5
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one
    integer which appears two or more times.

 

Follow up:

    How can we prove that at least one duplicate number must exist in nums?
    Can you solve the problem in linear runtime complexity?


*/




// Solution for immutable arrays
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
}

/*
APPROACH: 
    Similar to finding loop in linked list.
    1. detect loop
    2. reinitialize fast to nums[0]
    3. find the duplicate by running the loop
       one step for both slow & fast until
       both are equal.
*/



// Solution for mutable arrays
class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
      
        for(int i = 0; i < nums.length; i++){
           int curr = nums[Math.abs(nums[i])];
           if( curr < 0)
               res =  Math.abs(nums[i]);
           
           nums[Math.abs(nums[i])] = -curr;
        }
        return res;
    }
}

/*
APPROACH:
        1. Go to the index of array pointed by current array element 
           & mark the value there as negative of the current value.
        2. If the value of any location pointed by the current location
           is already negative that means the current value is the duplicate.
*/



// REFER:  https://www.youtube.com/watch?v=dfIqLxAf-8s
