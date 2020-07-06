#include <iostream>
using namespace std;
 
int ways(int n){                        // Recursive solution
    if(n==0)
        return 1;
    if(n>0)
        return ways(n-1)+ways(n-2)+ways(n-3);
    return 0;    
}

int waysTD(int *dp, int n){             // Top Down Approach
    if(n==0){
        dp[n]=1;
        return 1;
    }
    
    if(n<0)
        return 0;                      // handling -ve's
        
    if(dp[n]>0)                        // already calculated subproblem..
        return dp[n];
    
    dp[n]=waysTD(dp,n-1)+waysTD(dp,n-2)+waysTD(dp,n-3);
                                       // non-calculated problem.
    for(int i=0;i<n+1;i++)             // vizualization code..
        cout<< dp[i] << " ";
        
    cout << endl;    
    return dp[n];
}

int waysBU(int n,int k){               // Bottom UP Approach
    int *dp =new int[n+1];
    dp[0]=1;
    for(int step=1;step<n+1;step++){   // iterating to n
        dp[step]=0;
        for(int j=1;j<k+1;j++){        // iterating to add all [ f(n)=f(n-1)+f(n-2)+f(n-3)+.....+f(n-k) ]
            if(step-j>=0)              //handling -ve's
                dp[step]+=dp[step-j];
        }
    }
    for(int i=0;i<n+1;i++)             // vizualization code..
        cout<< dp[i] << " ";
    cout <<endl;    
    return dp[n];
}

int main()
{
    int n,k=3;                         // k= no. of max steps at a time ,till now 3 i.e.-> 1,2,3
    cin >> n;
    int *arr= new int[n+1];
    for(int i=0;i<n+1;i++)
        arr[i]=-1;
    cout << ways(n) << endl;           // recursive approach solution...
    cout << waysTD(arr,n) <<endl;      // Top Down Approach solution...
    cout << waysBU(n,k);               // Bottom Up Approach Solution...

    return 0;
}

  
