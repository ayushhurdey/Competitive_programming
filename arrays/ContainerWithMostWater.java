/**
11. Container With Most Water
Medium

You are given an integer array height of length n.
 There are n vertical lines drawn such that the 
 two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a
 container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:

            |              |
            |              |     |
            |  |           |     |
            |  |     |     |     |
            |  |     |  |  |     |
            |  |     |  |  |  |  |
            |  |  |  |  |  |  |  |
         |  |  |  |  |  |  |  |  | 
    ====================================
         1  8  6  2  5  4  8  3  7

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented 
by array [1,8,6,2,5,4,8,3,7]. In this case, the max 
area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

 

Constraints:

    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104


*/


class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return n;
        
        int totalWater = 0;
        int leftIndex = 0;
        int rightIndex = n - 1;
        
        while(leftIndex < rightIndex){
            int currWater = Math.min(arr[leftIndex], arr[rightIndex]) * (rightIndex - leftIndex);
            totalWater = Math.max(totalWater, currWater);
            if(arr[leftIndex] < arr[rightIndex]) leftIndex++;
            else rightIndex--;
        }
        
        return totalWater;
    }
}


/**

APPROACH:
  Maximize { Min (arr[i], arr[j]) * (j - i)}
  Take one pointer from leftInx & one from rightInx,
  whenever arr[leftInx] < arr[rightInx] increament leftInx
           else decreament rightInx
           
  At each iteration calculate the minimum of arr[leftInx] & arr[rightInx]
  & mutiply it differnce in indexes  i.e. (rightInx - leftInx)

  then calculate whether the currentWater Capacity is greater than total until now
  if yes then update it. 
 */