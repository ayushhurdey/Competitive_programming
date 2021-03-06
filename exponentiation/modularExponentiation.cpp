/*   ------------------------------PROBLEM STATEMENT-----------------------------------------------------------------
Nestor was doing the work of his math class about three days but he is tired of make operations a                   |
lot and he should deliver his task tomorrow. His math’s teacher gives him two numbers a and b. The                  |
problem consist of finding the last digit of the potency of base a and index b. Help Nestor with his                |
problem. You are given two integer numbers: the base a (0 <= a <= 20) and the index b (0 <= b <= 2,147,483,000),    |
a and b both are not 0. You have to find the last digit of ab.                                                      |
                                                                                                                    |
Input                                                                                                               |
The first line of input contains an integer t, the number of test cases (t <= 30). t test cases follow.             |
For each test case will appear a and b separated by space.                                                          |
                                                                                                                    |
Output                                                                                                              |
For each test case output an integer per line representing the result.                                              |
                                                                                                                    |
Example                                                                                                             |
Input:                                                                                                              |
2                                                                                                                   |
3 10                                                                                                                |
6 2                                                                                                                 |
                                                                                                                    |
Output:                                                                                                             |
9                                                                                                                   |
6                                                                                                                   |
---------------------------------------------------------------------------------------------------------------------
*/

#include <iostream>
using namespace std;

int main(){
    int a,t;
    long long int x,b,i;
    cin >> t;
    int arr[4]={0,0,0,0};
    while(t--){
        cin >> a >> b;                   
        // a and b cannot be 0 at the same time but can 0 differently..
        if(b==0){                        // edge case if power is 0.
            cout << 1 <<"\n";
            continue;
        }
        if(a==0){                        // edge case if base is 0.
            cout << 0 << "\n"; 
            continue;
        }
        x=a;                             // for all other case pattern is matched with the array of 4.Since after every 4 number pattern repeats...
        for(i=0;i<4;i++){
            x=(x%10*a)%10;
            arr[i]=x;
        }
        b=(b-1)%4;                       // since x=a  =>  one number is already taken that's why (b-1). 
        if(b==0)                         // without this element at index 4 is not reachable if (b-1) is divisible by 4 which gives -1.
            b=4;
        cout << arr[b-1] <<"\n";         
    }
    return 0;
}
