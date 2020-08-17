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
// 3 possible solutions...

int countSetBits(int n){
    if(n == 0 || n == 1)
        return n;
    if(n % 2 == 0)    
        return countSetBits(n/2);
    else
         return countSetBits(n/2)+1;
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
