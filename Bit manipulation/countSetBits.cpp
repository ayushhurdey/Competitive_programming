/*
Set Bits
                  
Given a positive integer N, print count of set bits in it. For example, if the given number is 6(binary: 110), output should be 2 as there are two set bits in it.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each testcase contains single line of input containing the N.

Output:
For each test case, in a new line, print count of set bits in it.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
2
6
11
Output:
2
3
*/

#include <iostream>
using namespace std;
/*
// 4 possible solutions...

int countSetBits(int n){
    if(n == 0 || n == 1)
        return n;
    return countSetBits(n/2) + (n % 2);
}
*/
/*
int countSetBits(int n){
    int oneCount = 0;
    while(n >= 1){
        oneCount += (n%2);
        n = n/2;
    }
    return oneCount;
}
*/
/*
// best method - O(No of setBits)
int setBits(int N){
        // code here
        int count = 0;
        while(N != 0){
            N = N & (N - 1);
            count++;
        }
        return count;
 }
 */

// O(no of total bits)
int countSetBits(int n){
    int oneCount = 0;
    while(n >= 1){
        oneCount += (n & 1);
        n = (n >> 1);
    }    
    return oneCount;
}

int main() {
	//code
	int tests,number;
	cin >> tests;
	while(tests--){
	    cin >> number;
	    cout << countSetBits(number) << endl;
	}
	return 0;
}



/*
 Java:
 Best solution if n is unsigned int
 because in Java des not have unsigned integers
*/
public static int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
}



/*
    DESCRIPTION:
    An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.
    To count the 1s in the Integer representation we put the input int
    n in bit AND with 1 (that is represented as
    00000000000000000000000000000001, and if this operation result is 1,
    that means that the last bit of the input integer is 1. Thus we add it to the 1s count.

    ones = ones + (n & 1);

    Then we shift the input Integer by one on the right, to check for the
    next bit.

    n = n>>>1;

    We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)

    We keep doing this until the input Integer is 0.

    In Java we need to put attention on the fact that the maximum integer is 2147483647. 
    Integer type in Java is signed and there is no unsigned int. So the input 2147483648
    is represented in Java as -2147483648 (in java int type has a cyclic representation,
    that means Integer.MAX_VALUE+1==Integer.MIN_VALUE). 
    This force us to use
    n!=0 in the while condition and we cannot use n>0
    because the input 2147483648 would correspond to -2147483648 in java and the code
    would not enter the while if the condition is n>0 for n=2147483648.
    
    
    REFER: 
    https://stackoverflow.com/questions/2811319/difference-between-and
    https://stackoverflow.com/questions/19058859/what-does-mean-in-java/19058871
*/
