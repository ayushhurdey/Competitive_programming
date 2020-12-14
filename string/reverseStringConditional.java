/*
Reverse String II

Given a string and an integer k, you need to reverse the first k characters
for every 2k characters counting from the start of the string. If there are
less than k characters left, reverse all of them. If there are less than 2k
but greater than or equal to k characters, then reverse the first k characters
and left the other as original.

Example:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:

   1. The string consists of lower English letters only.
   2. Length of the given string and k will in the range [1, 10000]

*/

class Solution {
    public void reverse(char[] ch, int left, int right){
        while(left <= right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
    
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int current = 0;
        int size = s.length();
        int remainingLength = size - current;
        
        while(current < size){
            if(remainingLength < k){
                reverse(ch,current, size - 1);
                current = size;
            }
            else if(remainingLength > k && remainingLength < 2*k){
                reverse(ch, current, current + k- 1);
                current += 2*k;
            }
            else{
                reverse(ch, current, current + k - 1);
                current += 2*k;
            }
            remainingLength = size - current;
        }
        
        return new String(ch);
    }
}
