/*
Check if a number is divisible by 8 or any number that is power of 2
Given a number n, check if it is divisible by 8.

Input:
The first line of the input contains an integer T denoting the number of test cases. For each test case, there is an integer n whose divisibility we need to check. 

Output:
For each test case, the output is 1 if the number is divisible by 8 else -1.

Constraints:
1 <= T <= 100
1 <= digits in n < 1000

Example:
Input:
2
16
15
Output:
1
-1

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    int tests, num; 
	    Scanner scan = new Scanner(System.in);
	    tests = scan.nextInt();
	    while(tests-- > 0){
	        num = scan.nextInt();
	        if((num & 7) == 0)
	            System.out.println("1");
	        else
	            System.out.println("-1");
	    }
	 }
}
