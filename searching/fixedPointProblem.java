/*
Fixed Point

Given a list of unique integers nums sorted in ascending order,
return the minimum i such that nums[i] == i. If there's no solution, return -1.

This should be done in O(log(n) time.

Constraints

    n ≤ 100,000 where n is the length of nums

Example 1
Input

nums = [-5, -2, 0, 3, 4]

Output

3

Explanation

Both nums[3] == 3 and nums[4] == 4 but 3 is smaller.
Example 2
Input

nums = [-5, -4, 0]

Output

-1

Explanation

There's no i such that nums[i] = i.

*/



class Solution {
    int ans = Integer.MAX_VALUE;

    public int solve(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid && mid < ans)
                ans = mid;

            if (mid > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
