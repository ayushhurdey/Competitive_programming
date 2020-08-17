/*
Generate Binary Numbers 

Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.

Input:
The first line of input contains an integer T denoting the number of test cases. There will be a single line for each testcase which contains N.

Output:
Print all binary numbers with decimal values from 1 to N in a single line.

Constraints:
1 ≤ T ≤ 106
1 ≤ N ≤ 106

Example:
Input:
2
2
5

Output:
1 10
1 10 11 100 101

Explanation:
Testcase 1: Binary numbers from 1 to 2 are 1 and 10.
*/


#include <iostream>
#include <queue>
using namespace std;

void generateBinary(int n,string bin){
    queue<string> q;
    int count = n;
    if(n == 0)
        return;
    q.push(bin);
    while(count != 0){
        string curr = q.front();
        q.pop();
        cout << curr << " ";
        q.push(curr + "0");
        q.push(curr + "1");
        count--;
    }
    cout << endl;    
}

int main() {
	//code
	int tests,n;
	cin >> tests;
	while(tests--){
	    cin >> n;
	    generateBinary(n, "1");
	}
	return 0;
}
