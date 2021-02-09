/*

First Repeating Element

Given an array arr[] of size N, find the first repeating
element. The element should occurs more than once and the
index of its first occurrence should be the smallest.

 

Example 1:

Input:
N = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 
5 is appearing twice and 
its first appearence is at index 2 
which is less than 3 whose first 
occuring index is 3.


Example 2:

Input:
N = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation: 
All elements appear only once so 
answer is -1.


Your Task:
You don't need to read input or print anything. Complete 
the function firstRepeated() which takes arr and N as input
parameters and return the position of the first repeating
element. If there is no such element, return -1.
The position you return should be according to 1-based indexing. 

 

Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)

 

Constraints:
1 <= N <= 106
0 <= Ai<= 106
*/




public static int firstRepeated(int []arr, int n) {
    //Your code here
    
    HashSet<Integer> set = new HashSet<Integer>();
    int min = -1;
    for(int i = n - 1; i >= 0; i--){
        if(set.contains(arr[i])){
            min = i; 
        }
        else
            set.add(arr[i]);
    }
    if(min != -1)
        return min+1;
    return min;
}

