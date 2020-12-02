/*
Row with max 1s

Given a boolean 2D array of n x m dimensions where each row is sorted. 
Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).


Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).


Your Task:  
You don't need to read input or print anything. Your task is to complete
the function rowWithMax1s() which takes the array of booleans arr[][], n
and m as input parameters and returns the 0-based index of the first row 
that has the most number of 1s. If no such row exists, return -1.
 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, M ≤ 103
0 ≤ Arr[i][j] ≤ 1 
*/


class Solution {
    int countOnesStartingIndex(int[][] arr, int n, int m){
        int count = 0;
        for(int i = 0; i < m; i++){
            if(arr[n][i] == 1)
                count++;
        }
        return m - count;
    }
    
    // T : O(n+m) &  S: O(1)
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int onesStartingIndex = countOnesStartingIndex(arr,0,m);
        int maxOnesRow = 0;
        for(int i = 0; i < n; i++){
            if(onesStartingIndex > 0 && arr[i][onesStartingIndex - 1] == 1){
                onesStartingIndex = countOnesStartingIndex(arr,i,m);
                maxOnesRow = i;
            }  
            
        }
        if(maxOnesRow == 0 && onesStartingIndex == m)
            return -1;
        return maxOnesRow;
    }
}


/*
Approach : calculate starting index of 1 in 0th row.
           assume it to be the answer.
           then for each row find if in the current row's starting index of 1 is 
                        (previous max starting index of 1 in previous rows) - 1;
           also maintain the variable for maximum count of 1 among the rows; 
           return the maximum count variable;
*/
