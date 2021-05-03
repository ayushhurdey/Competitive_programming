/*
46. Permutations
Medium

Given an array nums of distinct integers, return all the
possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.


*/

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    
    private int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return list;
        permute(nums, 0, nums.length - 1);
        return list;
    }
    
    private void permute(int[] nums, int left, int right){
        if(left == right){
            List<Integer> result = new ArrayList<>(nums.length);
            for(int i = 0; i < nums.length; i++){
                result.add(nums[i]);
            }
            list.add(result);
        }
        
        else{
            for(int i = left; i <= right; i++){
                nums = swap(nums, left, i);
                permute(nums, left + 1, right);
                nums = swap(nums, left, i);
            }
        }
    }
}



/*
APPROACH:
                                               l     r
                                               [1,2,3]
                                          /       |       \
                                 [1,2,3]       [2,1,3]        [3,2,1]         ---> 0th position fixed
                                /      \       /      \        /       \
                           [1,2,3]  [1,3,2] [2,1,3]  [2,3,1]  [3,2,1]  [3,1,2]  ---> 0th & 1st position fixed.
                           
                     (left == right) satisfied in all these cases in leaf nodes.
                     So as soon as we get this condition we iterate and store the current nums array
                     into result ArrayList and then finally adds it to list ArrayList.
                     
                     for loop is responsible for branching at each level, while recursion is for 
                     moving top to down and back to up.
*/
