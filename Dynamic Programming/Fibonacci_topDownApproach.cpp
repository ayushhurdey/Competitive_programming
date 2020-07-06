#include <iostream>
using namespace std;

int fiboTD(int *dp,int n){
    //base case
    if(n==0 || n==1){     
        dp[n]=n;
        return n;
    }    
    // if it is alredy calculated.
    if(dp[n]>0){
        return dp[n];
    } 
    // if it is not calculated yet. Then calculate and put it in 
    // the dp array at the particular position.
    dp[n]= fiboTD(dp, n-1)+fiboTD(dp, n-2);
    /*for(int i=0;i<n+1;i++){           // for seeing how the array is working with each step.
        cout <<dp[i] << " ";*/       
    }cout << endl;
    return dp[n];
}

int main()
{
    int n;
    cin >> n;
    int *store = new int[n+1];    // dynamic array allocation in c++.
    for(int i=0;i<n+1;i++){
        store[i]=-1;
    }
    cout << fiboTD(store,n);
    delete [] store;           // free the dynamically allocated memory..
    store=NULL;
    return 0;
}
