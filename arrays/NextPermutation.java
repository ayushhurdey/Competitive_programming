/**
31. Next Permutation
Medium

A permutation of an array of integers is an arrangement of 
its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are
    considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].

The next permutation of an array of integers is the next 
lexicographically greater permutation of its integer.
More formally, if all the permutations of the array 
are sorted in one container according to their lexicographical 
order, then the next permutation of that array is the permutation
that follows it in the sorted container. If such arrangement 
is not possible, the array must be rearranged as the lowest 
possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3]
    because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100

 */


 // Solution: TC: O(n), SC: O(1)

 class Solution {
    public void nextPermutation(int[] nums) {
        int len  = nums.length;
        
        if(len < 2) return;
        
        // Find first decreasing element
        int firstDecreasing = -1;
        for(int i = len -2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                firstDecreasing = i;
                break;
            }
        }
        
        // if no first decreasing element found, just reverse the array because
        // that is the lowest possible permutation
        if(firstDecreasing == -1){
            reverseArray(nums, firstDecreasing + 1, len);
            return;
        }
        

        // find nextGreater elem which is just greater than firstDecreasing
        int nextGreater, j;
        for(j = len - 1; j >= 0; j--){
                if(nums[firstDecreasing] < nums[j]){
                    break;
                }
        }
        nextGreater = j;
        
        //System.out.println("FD: " + firstDecreasing);
        //System.out.println("NG: " + nextGreater);
        
        // swap the two & reverse the remaining subarray until last
        swap(nums, firstDecreasing, nextGreater);
        reverseArray(nums, firstDecreasing + 1, len);
        return;
    }
    
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverseArray(int[] nums, int start, int end){
        end = end-1;
                
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
        
    }
}


/**
APPROACH:

  1. find the first decreasing element from right side
  2. Find nextGreater number in remaining subarray from the
     first decreasing elemnt to the right.
  3. Swap both firstDecreasing & nextGreater
  4. Reverse the subarray on the right from firstDecreasing + 1
     to last element in the array in ascending order.
 */