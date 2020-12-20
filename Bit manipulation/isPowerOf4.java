/*
Power of Four
Basic Accuracy: 31.03% Submissions: 6290 Points: 1

Given a number N, check if N is power of 4 or not.

Input:

You have to complete the method which takes 1 argument: the number
N  .You should not read any input from stdin/console. There are 
multiple test cases. For each test case, this method will be called
individually.

Output:
Your function should return 1 if N is power of 4, else return 0.

Constraints:
1<=T<=50
1<=N<=108

Example:

Input:
2
64
75

Output:
1
0
*/


class GfG
{
    int isPowerOfFour(long n)
    {
	    // Your code here
	    double temp = Math.log(n) / Math.log(4);
	    if((int)temp - temp == 0)
	        return 1;
	    return 0;
    }
}




/*   
  Explaination:
     log(n) counts no of zeroes (in binary of n) and division by log(4) checks
     if zeroes count is divisible by 2 or not.
     if yes then divisible by 4.
*/
