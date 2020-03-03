#include <stdio.h>

int main()
{
    int i,j,arr[10][10],rotate[10][10],n;
    int k;
    printf("Enter the size of Array::");
    scanf("%d",&n);
    printf("Enter array::");
    for(i=0;i<n;i++)
       for(j=0;j<n;j++)
           scanf("%d",&arr[i][j]);
       
    // Rotate 90* Anticlockwise
    
    for(i=0;i<n;i++){
        k=n-1;  
        for(j=0;j<n;j++)
           rotate[j][i]=arr[i][k--];
    }
    
    
    printf("\nRotated Matrix 90* Anticlockwise::\n\n");
    for(i=0;i<n;i++)
    {
       for(j=0;j<n;j++)
       {
           printf("%-3d",rotate[i][j]);
       }printf("\n");
    }
    return 0;
}