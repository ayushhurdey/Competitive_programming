/*
Triangular Number 
    
Problems
Check whether the number is Triangular or not. A number is termed as triangular number if we can represent it in the form of triangular grid of points such that the points form an equilateral triangle and each row contains as many points as the row number, i.e., the first row has one point, second row has two points, third row has three points and so on. The starting triangular numbers are 1, 3 (1+2), 6 (1+2+3), 10 (1+2+3+4).

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the number to be checked if it is traingular or not.

Output:
If the number is Triangular then display 1 otherwise 0.

Constraints:
1 <= T <= 100
1 <= N <= 107

Example:
Input:
5
3
4
6
55
345

Output:
1
0
1
1
0
*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    static int isNumTriangular(int s){
        double temp = Math.sqrt(1+8*s);
        //System.out.println(temp);
        if(Math.floor(temp) == Math.ceil(temp)){
            return 1;
        }
        return 0;
    }
    
	public static void main (String[] args){
	 //code
    	 Scanner scan = new Scanner(System.in);
    	 int tests = scan.nextInt();
    	 int num;
    	 while(tests-- > 0){
    	        num = scan.nextInt();
    	        System.out.println(isNumTriangular(num));
    	 }
    }
}

/*
sum of n natural numbers(S) = n(n+1)/2
on modifying: n^2 + n -2S = 0
solving for n = (-1 + sqrt(1+8S)) / 2;
So, if  floor(sqrt(1+8S)) == ceil(sqrt(1+8S))    then   return 1;   => integer n
else return 0;
 */
