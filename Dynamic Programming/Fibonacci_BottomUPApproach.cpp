#include <iostream>
using namespace std;

int* fiboBU(int *dp,int n){
    dp[0]=0;
    dp[1]=1;
    cout << dp[0] <<" " << dp[1] << " ";
    for(int i=2;i<n+1;i++){
        dp[i]=dp[i-1]+dp[i-2];
        cout << dp[i] << " ";
    }
    
    return dp;        //pointer to array is returned..
}

int main()
{
    int n;
    cin >> n;
    int *store = new int[n+1];    // dynamic array allocation in c++.
    
    store = fiboBU(store,n);  //pointer is returned to store array..
    cout << endl <<store[n];  //printing the 5th fibonacci number i.e. 5th index of the array..
    delete [] store;          //deleting the dynamically allocated array..
    store=NULL;
    return 0;
}


//-----------------------Little Modifications-----------------//

#include <iostream>
using namespace std;

int fiboBU(int *dp,int n){
    dp[0]=0;
    dp[1]=1;
    cout << dp[0] <<" " << dp[1] << " ";
    for(int i=2;i<n+1;i++){
        dp[i]=dp[i-1]+dp[i-2];
        cout << dp[i] << " ";
    }
    cout << "\n";
    return dp[n];
}


int main()
{
    int n;
    cin >> n;
    int *store = new int[n+1];    // dynamic array allocation in c++.
    cout << fiboBU(store,n);
    delete [] store;
    store=NULL;
    return 0;
}

