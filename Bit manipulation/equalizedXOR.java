/*
XOR of two numbers after making length of their binary representations equal 
Given two numbers say a and b. Print their XOR after making the lengths of their binary
representation equal by adding trailing zeros to the binary representation of smaller one.

Input:
The first line of the input contains integer T denoting the number of test cases. For each
test case, there are two integer inputs a & b. 

Output:
For each test case, the output is the integer displaying the  XOR of a & b after making
them of equal lengths.

Constraints:
1<=T<=100
1<=a,b<=107

Example:
Input:
4
2 6
3 10
5 24
1 20
Output:
2
6
12
4

Explanation:
1. The binary representation of 2 is 10 and of 6 is 110. As the length of "10" is smaller, so add a '0' to it making it "100', to make the length of binary representations equal. XOR of 100 and 110 gives 010 which is 2.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    // getting number of bits in a number..
    private static int getBits(int num){
        int count = 0;
        while(num > 0){
            count++;
            num/=2;
        }    
        return count;
    }
     
     
	public static void main (String[] args)
	 {
	        //code
            int tests, num1, num2, minElem, maxElem,equalizedMin,diff;
            Scanner scan = new Scanner(System.in);
            tests = scan.nextInt();
            while(tests-- > 0){
                num1 = scan.nextInt();
                num2 = scan.nextInt();
                minElem = Math.min(num1, num2);
                maxElem = Math.max(num1, num2);
                diff = Math.abs(getBits(num1) - getBits(num2));
                equalizedMin = minElem << diff;
                System.out.println(equalizedMin^maxElem);
            }
	 }
}
