/*
119. Pascal's Triangle II
Easy

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

Example 1:
               
               1
              1 1
             1 2 1
            1 3 3 1
           1 4 6 4 1

Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:

Input: rowIndex = 0
Output: [1]

Example 3:

Input: rowIndex = 1
Output: [1,1]

 

Constraints:

    0 <= rowIndex <= 33

 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

*/


class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}


// Same Appproach - Different way
public class Solution {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
}



/*
APPROACH:

      1 
      1 1  
      1  1  1 -> 1  2  1
      1 2 1 1 -> 1 2 3 1 -> 1 3 3 1
      1 3 3 1 1 -> 1 3 3 4 1 -> 1 3 6 4 1  ->  1 4 6 4 1
      .....
      
      In each row 1 is added to last column & then all the 
      values in the row are recalculated using { arr[j] = arr[j] + arr[j-1] }
      from last-1 to starting + 1
*/
