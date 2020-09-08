/*
Easy string 
Compress the string when lower and upper case are same. In compressed string characters should be in lowercase.

for ex:     input    aaABBb

            output  3a3b

Input

The first line of the input contains a single integer T denoting the number of test cases.
The first line of each test case contains string s.
Output

For each test case, output the required string.

Constraints

    •    1 ≤ T ≤ 101

    •    1 ≤ |s|≤ 1000

Example

Input:

3

aabbB

abc

aaacca

Output:

2a3b

1a1b1c

3a2c1a

*/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    private static String modifyString(String str){
            String strOut = "";
            str = str.toLowerCase();
            int tempCount = 1,i;
            
            for(i = 1; i < str.length(); i++){
                if((str.charAt(i-1)) == (str.charAt(i))){
                     tempCount++;
                 }
                 else{
                     strOut +=  tempCount;
                     strOut += str.charAt(i-1);
                     tempCount = 1;
                 }
            }
            strOut +=  tempCount;
            strOut +=  str.charAt(i-1);
            
            return strOut;
            
    } 
    
	public static void main (String[] args)
	 {
	        //code
	        String strIn = "";
	        int tests;
	        Scanner scan = new Scanner(System.in);
	        tests = scan.nextInt();
	        while(tests-- > 0){
	            strIn = scan.next();
	            System.out.println(modifyString(strIn));
	        }
	 }
}
