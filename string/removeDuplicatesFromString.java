/*
Remove all duplicates from a given string
Easy Accuracy: 43.24% Submissions: 1147 Points: 2

Given a string Str which may contains lowercase and uppercase chracters.
The task is to remove all duplicate characters from the string and find 
the resultant string. The order of remaining characters in the output 
should be same as in the original string.

Example 1:

Input:
Str = geeksforgeeks
Output: geksfor
Explanation: After removing duplicate
characters such as e, k, g, s, we have
string as "geksfor".

Example 2:

Input:
Str = HappyNewYear
Output: HapyNewYr
Explanation: After removing duplicate
characters such as p, e, a, we have
string as "HapyNewYr".

Your Task:
Complete the function removeDuplicates() which takes a string str, as 
input parameters and returns a string denoting the answer. You don't 
to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
String contains uppercase and lowercase english letters.

##############    No HashSet to be used  ###############
*/



class Solution {
    String removeDuplicates(String str) {
        // code here
        int[] hash = new int[256];
        String output = "";
        for(int i = 0; i < str.length(); i++){
            if(hash[str.charAt(i)] == 0){
                output += str.charAt(i);
                hash[str.charAt(i)]++;
            }
        }
        return output;
    }
}

/*
  Java converts char into ascii values automatically.
*/
