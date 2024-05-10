class Solution {
    public int mySqrt(int n) {


// Binary Search :

long low=1;
long high = n;
long ans=0;
while(low<=high)
{
    long mid = (low+high)/2;

    if(mid*mid<=n)
    {
        ans =mid;
        low=mid+1;
        
    }
    else 
    {
        high=mid-1;
    }
    
}

return (int)ans;




// Linear Traversal : 
/*
int ans =0;
//int m = (int)x/2;
for(int i = 1;i<=x;i++)
{
    if(i*i<=x)
    {
        ans = i; // stores the last smallest element
    }
    else // if product gets bigger break
    {
        break;
    }
}

   return ans; 
   */    
    }
}