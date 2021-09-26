/*

Next Greater Element
Medium

Given an array arr[ ] of size N having distinct elements, the task 
is to find the next greater element for each element of the array 
in order of their appearance in the array.
Next greater element of an element in the array is the nearest element
on the right which is greater than the current element.
If there does not exist next greater of current element, then next
greater element for current element is -1. For example, next greater
of the last element is always -1.

Example 1:

Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
Explanation:
In the array, the next larger element 
to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
since it doesn't exist, it is -1.

Example 2:

Input: 
N = 5, arr[] = [6 8 0 1 3]
Output:
8 -1 1 3 -1
Explanation:
In the array, the next larger element to 
6 is 8, for 8 there is no larger elements 
hence it is -1, for 0 it is 1 , for 1 it 
is 3 and then for 3 there is no larger 
element on right and hence -1.

Your Task:
This is a function problem. You only need to complete the function
nextLargerElement() that takes list of integers arr[ ] and N as 
input parameters and returns list of integers of length N denoting 
the next greater elements for all the corresponding elements in the
input array.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 10^6
1 ≤ Ai ≤ 10^18
*/



class Solution{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n){ 
        // Your code here
        Stack<Integer> stack = new Stack<>();
        long[] result = new long[n];
        stack.push(0);
        
        for(int i = 1; i < n; i++){
            if(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    int tempInx = stack.pop();
                    result[tempInx] = arr[i];
                }
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()){
            int tempInx = stack.pop();
            result[tempInx] = -1;
        }
        
        return result;
    } 
}


/*
APPROACH:
   Smaller or equal element can be pushed over top element of stack;
   else pop from the stack & put current element in the result array
        at the popped index until this given condition is matched &
        push the current element in the stack after the condition is met.
      
   After all empty the stack by putting -1 at all the indexes popped from
   the stack in the result array.
*/








/*

503. Next Greater Element II
Medium

Given a circular integer array nums (i.e., the next element
of nums[nums.length - 1] is nums[0]), return the next greater 
number for every element in nums.

The next greater number of a number x is the first greater 
number to its traversing-order next in the array, which means
you could search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

 

Constraints:

    1 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
*/


class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();     // prefer Deque<> in place of Stack<> to give significant performance increase
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < 2 * n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i % n]){
                result[stack.pop()] = arr[i % n];
            }
            stack.push(i % n);
        }
                
        return result;
    }
}

// O(N), O(N) solution

// https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
// https://stackoverflow.com/a/61357726/15348175
