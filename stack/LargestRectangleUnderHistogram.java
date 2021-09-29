/*
84. Largest Rectangle in Histogram
Hard

Given an array of integers heights representing the histogram's
bar height where the width of each bar is 1, return the area of 
the largest rectangle in the histogram.

 

Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:

Input: heights = [2,4]
Output: 4

 

Constraints:

    1 <= heights.length <= 10^5
    0 <= heights[i] <= 10^4


*/


class Solution {
    private void calcLeftArray(int[] arr, int[] heights, int n){
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                arr[i] = 0;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                arr[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }
        }
    }
    
    
    private void calcRightArray(int[] arr, int[] heights, int n){
        Deque<Integer> stack = new ArrayDeque<>();
    
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()){
                arr[i] = n - 1;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    stack.pop();
                }
                arr[i] = stack.isEmpty() ? n-1 : stack.peek() - 1;
                stack.push(i);
            }
        }
    }
    
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        calcLeftArray(leftMin, heights, n);
        calcRightArray(rightMin, heights, n);
        
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, (rightMin[i] - leftMin[i] + 1) * heights[i]);
        }
        return max;
    }
}


/*
APPROACH:
    For each index in heights find nearest left minimum & 
    nearest right minimum &
    answer is maximum of (right[i] - left[i] + 1)* height[i] 
    
    E.g. heights = [2,1,5,6,2,3]
         left =    [0,0,2,3,2,5]
         right=    [0,5,3,3,5,5]
         max =     [2,6,10,8,6,3]  ==> Max = 10
         
*/
