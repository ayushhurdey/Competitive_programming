/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

 

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

    n == height.length
    0 <= n <= 3 * 104
    0 <= height[i] <= 105
    
*/


// solution: Time Complexity: O(n)    Space Complexity: O(n)

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return n;
        
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        int totalWater = 0;
        
        leftHeight[0] = arr[0];
        for(int i = 1; i < n; i++){
            leftHeight[i] = Math.max(leftHeight[i-1], arr[i]);
        }
        
        rightHeight[n-1] = arr[n-1];
        for(int i = n-2; i >=0 ; i--){
            rightHeight[i] = Math.max(rightHeight[i+1], arr[i]);
        }
        
        for(int i = 0; i < n; i++){
            totalWater += Math.min(rightHeight[i], leftHeight[i]) - arr[i];
        }
        
        return totalWater;
    }
}


// solution: Time Complexity: O(n)    Space Complexity: O(1)

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return n;
        
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        int leftIndex = 0;
        int rightIndex = n - 1;
        
        while(leftIndex <= rightIndex){
            if(arr[leftIndex] < arr[rightIndex]){
                if(arr[leftIndex] > leftMax)
                    leftMax = arr[leftIndex];
                else
                    totalWater += leftMax - arr[leftIndex];
                leftIndex++;
            }
            
            else{
                if(arr[rightIndex] > rightMax)
                    rightMax = arr[rightIndex];
                else
                    totalWater += rightMax - arr[rightIndex];
                rightIndex--;
            }
        }
        
        return totalWater;
    }
}

/*
APPROACH: 
    - Until left index doesn't cross right index
        -  Whenever left height is less than the right height:
              the leftMax will be responsible for trapping water
               -  whenever the leftMax < current Height
                     update leftMax with current Height.
               -  else trap water
           else the rightMax will be responsible.
              -  whenever the rightMax < current Height
                     update rightMax with current Height.
              -  else trap water
*/
