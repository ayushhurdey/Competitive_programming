/*
Longest Common Prefix in an Array

Given a array of N strings, find the longest common prefix 
among all strings present in the array.

Example 1:

Input:
N = 4
arr[] = {geeksforgeeks, 
         geeks,
         geek,
         geezer}
Output: gee
Explanation: "gee" is the longest common
prefix in all the given strings.

Example 2:

Input: 
N = 2
arr[] = {hello, world}
Output: -1
Explanation: There's no common prefix
in the given strings.


Your Task:
You don't need to read input or print anything. Your task is
to complete the function longestCommonPrefix() which takes 
the string array arr[] and its size N as inputs and returns
the longest common prefix common in all the strings in the 
array. If there's no prefix common in all the strings, return "-1".


Expected Time Complexity: O(N*max(|arr i|)).
Expected Auxiliary Space: O(max(|arr i|)) for result.


Constraints:
1<=N<=103
1<=|arri|<=103
*/


class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        if(arr.length == 0){
            return "-1";
        }
        for(int i = 0; i < arr[0].length(); i++){
            char toMatch = arr[0].charAt(i);
            for(int j =1; j < arr.length; j++){
                if(i >= arr[j].length() || arr[j].charAt(i) != toMatch){
                    if(i==0) return "-1";
                    return arr[0].substring(0,i);
                }
            }
        }
        return arr[0];
    }
}

/*
If at any point of time i exceeds min length string in array, it 
means length of common prefix cannot be greater than that particular
string with min length string in the array.
*/
