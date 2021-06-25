/*

Maximum of all subarrays of size k
Medium 

Given an array arr[] of size N and an integer K. Find the maximum 
for each and every contiguous subarray of size K.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6

Example 2:

Input:
N = 10, K = 4
arr[] = 8 5 10 7 9 4 15 12 90 13
Output: 
10 10 10 15 15 90 90
Explanation: 
1st contiguous subarray = {8 5 10 7}, Max = 10
2nd contiguous subarray = {5 10 7 9}, Max = 10
3rd contiguous subarray = {10 7 9 4}, Max = 10
4th contiguous subarray = {7 9 4 15}, Max = 15
5th contiguous subarray = {9 4 15 12}, 
Max = 15
6th contiguous subarray = {4 15 12 90},
Max = 90
7th contiguous subarray = {15 12 90 13}, 
Max = 90


Your Task:  
You dont need to read input or print anything. Complete the function 
max_of_subarrays() which takes the array, N and K as input parameters
and returns a list of integers denoting the maximum of every contiguous
subarray of size K.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(k)

Constraints:
1 ≤ N ≤ 10^7
1 ≤ K ≤ N
0 ≤ arr[i] <= 10^7
*/




class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a,b) -> (b - a));
        for(int i = 0; i < k; i++)
            maxHeap.add(arr[i]);
        
        int prev = 0;
        for(int i = 1; i < n - k + 1; i++){
            int max = maxHeap.peek();         
            list.add(max);
            maxHeap.remove(arr[prev++]);
            maxHeap.add(arr[i+k-1]);
        }
        
        list.add(maxHeap.peek());
        
        return list;
    }
}


/*
APPROACH: Make a max-heap of size k in which top will give the maximum
          always in the sliding window.
          Whenever window slides look for the max element i.e. top of heap
          then, add it to the list.
          then, remove the element occuring ouside the window after sliding
                window forward i.e. prev                        => O(k): finding->O(K) + deleting->O(logK)
          then, add the next new element in window to maxHeap.  => O(logK)
          
          finally => n-size array is divide into k-parts => total n/k parts
                  => n/k(logk + k) => n/k(k) => O(n) => T.C. of this algorithm 
                   Space Complexity -> O(k)
*/




// Better Approach wrt Time complexity -> O(n) but still better than previous one.
// Space Complexity -> O(2n) -> O(n)

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];
        
        for(int i = 1; i < n; i++){
            leftMax[i] = (i % k == 0) ? arr[i] : Math.max(leftMax[i-1], arr[i]);
        }// whenever i is divisible by k => window has changed
        
        for(int j = n-2; j >= 0 ; j--){
            rightMax[j] = (j % k == 0) ? arr[j] : Math.max(rightMax[j+1], arr[j]);
        }// whenever j is divisible by k => window has changed
        
        int[] slidingMax = new int[n-k+1];
        for(int i = 0, j = 0; i + k <= n; i++){
            slidingMax[j++] = Math.max(rightMax[i], leftMax[i+k-1]);
        }
        
        return slidingMax;
    }
}

/*
APPROACH: 
        - Calculate left max array.
        - Calculate right max array.
        - then calculate sliding window maximum & for that
          in each rightmax window leftmost element is maximum,
          but in each leftMax window rightmost element is maximum,
          So, in each of the sliding window it will have the maximum
          either one from leftmost of rightMax window, rightmost of 
          leftMax window.
*/
