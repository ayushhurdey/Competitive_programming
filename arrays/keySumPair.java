/*
Key Pair

Given an array Arr of N positive integers and another number X. 
Determine whether or not there exist two elements in Arr whose 
sum is exactly X.

Example 1:

Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16

Example 2:

Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10

Your Task:
You don't need to read input or print anything. Your task is to
complete the function hasArrayTwoCandidates() which takes the 
array of integers arr, n and x as parameters and returns boolean
denoting the answer.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 105

 
*/


// O(nlogn) solution
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        
        Arrays.sort(arr);
        
        int left = 0;
        int right= n-1;
        
        while(left < right){
            if(arr[left] + arr[right] > x)
                right--;
            else if(arr[left] + arr[right] == x)
                return true;
            else{
                left++;
            }
        }
        return false;
    }
}

// T.C. can be improved by using hashMap.

/*
Approach - Sort the array.
           if Sum of currentLeft & currentRight is > x :
                then this pair can never be the required one
                also right is having larger elements so decrease right
                to check on smaller values from right.
           if Sum of currentLeft & currentRight is < x :
                then increase left.
           else:
                key pair is found.
*/
