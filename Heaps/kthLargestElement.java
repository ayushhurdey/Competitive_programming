/*
215. Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, 
return the kth largest element in the array.

Note that it is the kth largest element in the
sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 

Constraints:

    1 <= k <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
*/


//Max-Heap Solution
//Time Complexity : O(n + klogn) => O(klogn)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, (a,b) -> b - a);

        for(int i = 0; i < n; i++){
            maxHeap.add(nums[i]);
        }

        for(int i = 0; i < k-1; i++){
            int top = maxHeap.poll();
        }

        return maxHeap.poll();
    }
}


// Quick Select Algorithm
// T.C. -> O(n) average, best & O(n^2) for worst case
// Word of Advice -> Prefer Heap Solution.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthLargest(nums, 0, nums.length-1, nums.length - k +1);
    }
    
    public int kthLargest(int[] nums,int left, int right, int k) {
        int pivot = quickSelect(nums, left, right);
        if(pivot == k -1)
            return nums[pivot];
        else if(pivot > k - 1)
            return kthLargest(nums, left, pivot -1 , k);
        else
            return kthLargest(nums, pivot+1, right, k);
    }
    
    private int quickSelect(int[] arr, int left, int right){
        int pivot = arr[right];
        
        int j = left;
        for(int i = left; i <= right; i++){
            if(arr[i] < pivot){
                swap(arr, i, j++);
            }
        }
        swap(arr, right, j);
        return j;
    }
    
    
    private void swap(int arr[], int elementOne, int elementTwo){
        int temp = arr[elementOne];
        arr[elementOne] = arr[elementTwo];
        arr[elementTwo] = temp;
    }
}
