// Check if a given number is prime or not.



#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(long long int n){
    if(n<=1)
        return false;
    if(n <= 3)
        return true; 
        
    if(n % 2 == 0 || n % 3 == 0)
        return false;
        
    for(int i = 5; i < int(sqrt(n)+1); i+=6){
        if(n % i == 0 || n % (i+2) == 0)
            return false;
    }  
    return true;
} 

int main()
{
    bool check = isPrime(84769455677);
    if(check ==  true)
         cout << "number is prime." << endl;
    else 
        cout << "Not prime." << endl;
    return 0;
}

