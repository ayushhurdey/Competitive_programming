/**
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest 
substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a
 subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces.


 */

// Solution: Time Complexity: O(n^2)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int len = s.length();
        Queue<Character> queue = new LinkedList<>();
        int right = 0;
        int maxLen = 0;
        
        while(right < len){
             // O(n) operation for searching in queue
            while(queue.contains(s.charAt(right))){   
                queue.poll();
            }
            
            queue.offer(s.charAt(right++));
            maxLen = Math.max(maxLen, queue.size());
        }
        return maxLen;
        
    }
}



 // Solution: Time complexity: O(n)

 class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int len = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        
        while(right < len){
            // O(1) operation for searching in set
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            
            set.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }
        
        return maxLen;
        
    }
}


/**
APPROACH: In this question for 2nd solution,
          we take two pointers left & right.
          We move right pointer for each character in the string.
          We move left when left pointing character in the string
          has to be removed from the set beacause of the reappereance,
          and left kept increasing until the repearred element is 
          not removed from the set, and finally pointing to repearred
          character.

          Now after every addition to a set, we check for max length
          of substring, if the diffference between right & left(i.e. the length
          of substring currently under evaluation), isgreater than previous maxLen
          then update maxLen. 


 */
