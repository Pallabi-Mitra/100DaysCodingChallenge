class Solution {
    public int trap(int[] arr) {

// Optimized : T.C : O(n) ; S.C : O(n) : Using 2 Pointers
/*
int n = arr.length;

int left = 0;
int right = n-1;
int res=0;
int maxleft=0;
int maxright=0;

    while(left<=right)
    {
        if(arr[left]<=arr[right])
        {
            if(arr[left]>=maxleft)
                {
                    maxleft=arr[left]; // reassign max of left
                }
            else
                {
                    res+=maxleft-arr[left]; // if same or lesser we can store water
                }
        left++;
        }
        else
        {
            if(arr[right]>=maxright)
            {
                maxright= arr[right];
            }
            else
            {
                res+=maxright-arr[right]; //if same or lesser we can store water
            }
            right--;
        }
     
    }

    return res;
*/
// Better : T.C : O(n) ; S.C : O(2N)

//Precompute leftmax and right max


int n = arr.length;
int lmax []= new int[n];
int rmax[]= new int[n];
int res=0;

lmax[0]=arr[0];

for(int i=1;i<n;i++)
{
    lmax[i]=Math.max(arr[i],lmax[i-1]);
}

rmax[n-1]=arr[n-1];

for(int i = n-2;i>=0;i--)
{
    rmax[i]=Math.max(arr[i],rmax[i+1]);
}

for(int i=1;i<n-1;i++)
{
    res=res+(Math.min(lmax[i],rmax[i])-arr[i]);
}

return res;







// Bruteforce : O(n2) :

/*

        int res=0;
        int n = arr.length;

        for(int i =1;i<n-1;i++)
        {
            int lmax = arr[i]; // initializing the first

            for(int j =0;j<i;j++)
            {
                lmax = Math.max(lmax,arr[j]); // finding the maximum in left
            }

            int rmax = arr[i];

            for(int j = i+1;j<n;j++) 
            {
                rmax = Math.max(rmax,arr[j]);// finding the max in right
            }

            res = res + (Math.min(lmax,rmax)- arr[i]); 
                // the rain store will be minimum of both - the height of the present bar
        }

        return res;

  */      
        
    }
}