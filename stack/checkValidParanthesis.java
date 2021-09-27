/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

  1.  Open brackets must be closed by the same type of brackets.
  2.  Open brackets must be closed in the correct order.

 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([)]"
Output: false

Example 5:

Input: s = "{[]}"
Output: true

 

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
*/

// SOLUTION 1

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push('0');
        int len = s.length();
        
        if(len == 1)
            return false;
        
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(ch == ')' && stack.peek() == '(')
                    stack.pop();
                else if(ch == '}' && stack.peek() == '{')
                    stack.pop();
                else if(ch == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        stack.pop();
        return stack.isEmpty();
    }
}




// SOLUTION 2 (better in code only)

class Solution {

  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {

    // Initialize a stack to be used in the algorithm.
    Deque<Character> stack = new ArrayDeque<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}






// SOLUTION 3: Best solution in both time and space

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1)
            return false;
  
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
