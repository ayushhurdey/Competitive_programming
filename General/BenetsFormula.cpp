// Benet's Formula to calculate nth fibonacci number directly without the iteration.

#include <iostream>
#include <cmath>
using namespace std;

//program to print fibonacci series in minimum time and space..
int main()
{
    float x;
    for(int i=0;i<20;i++){
        x=(pow(1+sqrt(5),i)-pow(1-sqrt(5),i))/(pow(2,i)*sqrt(5));
        cout <<x <<" ";
    }

    return 0;
}

/*
Benet's Formula to get nth fibonacci number...

   fibo(n)=(1+√5)^n  -  (1-√5)^n
           ---------------------
                  2^n * √5
                  
*/
