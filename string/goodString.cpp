/*
Good String 
Given a string S of length N, you have to tell whether it is good or not. A good string is
one where the distance between every two adjacent character is exactly 1. Here distance is
defined by minimum distance between two character when alphabets from 'a' to 'z' are put in
cyclic manner. For example distance between 'a' to 'c' is 2 and distance between 'a' to 'y' 
is also 2. The task is to print "YES" or "NO" (without quotes) depending on whether the given
string is Good or not.


Input:
First line of the input contains T denoting the number of test cases.Then T lines follow.
Each line contains a string S.


Output:
Print  the answer for each testcase in a separate line.


Constraints:

1≤T≤50
1≤|S|≤50

Note: S contains only lowercase alphabetic characters


Input:
3
aaa
cbc
bcd

Output:
NO
YES
YES
*/


#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

bool isGoodString(string str){
    for(int i = 0; i <= str.size()-2; i++){
        if(abs(str[i+1]-str[i])%24 != 1)
           return false;
    }
    return true;
}

int main() {
	//code
	    string str;
	    int tCases;
	    bool goodString;
	    cin >> tCases;
	    while(tCases--){
	        cin >> str;
	        goodString = isGoodString(str);
	        if(goodString == true || str.size()==1)
	           cout << "YES" << endl;
	        else
	           cout << "NO" << endl;
	    }
	    return 0;
}
