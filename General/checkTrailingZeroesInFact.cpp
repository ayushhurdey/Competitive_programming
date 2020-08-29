/*
For an integer n find number of trailing zeroes in n! . 

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, it contains an integer 'N'.

Output:
In each seperate line output the answer to the problem.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
1
9
Output:
1
*/


#include <iostream>
#include <cmath>
using namespace std;

int checkTrailingZeroesInFact(int n){
    int temp,zeroes = 0, i = 1;
    if(n < 5)
        return 0;
    temp = floor(n/5);
   
    while(temp != 0){
        zeroes += temp;
        temp = floor(n/pow(5,++i));
    }
    return zeroes;
}

int main() {
	//code
	int tests,num;
	cin >> tests;
	while(tests--){
	    cin >> num;
	    cout << checkTrailingZeroesInFact(num) << endl;
	}
	return 0;
}


/*
Solution:
No. of trailing zeroes in n! =  floor(n/5) + floor(n/5^2) + floor(n/5^3) +.....+ 0.
*/
