/*
33. Search in Rotated Sorted Array
Medium

There is an integer array nums sorted in ascending
order (with distinct values).

Prior to being passed to your function, nums is 
rotated at an unknown pivot index k (0 <= k < nums.length)
such that the resulting array is
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot
index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer 
target, return the index of target if it is in nums,
or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 

Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is guaranteed to be rotated at some pivot.
    -104 <= target <= 104


*/


class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid = 0;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else{
                if(target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            
        }
        return -1;
    }
}


/*
APPROACH: 
         
         1. Search until match or elements gets over:
            1.1 Calculate mid and check arr[mid] == target
            1.2 if left half is in non-decreasing order
                1.2.1 if target lies in this range
                        then search again in left half only.
                1.2.1 else go for right half as a divided array as a subproblem.
            1.3 otherwise right half is in non-decreasing order automatically
                1.3.1 then if target lies in right half
                      left is set to be mid +1.
                1.3.2 else 
                       left subarray is considered to be divided subproblem.
*/
