class Solution {
    public int[] searchRange(int[] nums, int target) {

int n = nums.length;
int low= 0;
int high = n-1;
int first = -1;
int a[]=new int[2];
// first occurence : 

    while(low<=high)
    {
        int mid = (low+high)/2;

        if(nums[mid]==target)
        {
            first=mid;
            high=mid-1; // keep getting the smallest

        }

        else if(nums[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            high = mid-1;
        }
    }

    if(first==-1)
    {
        a[0]=-1;
a[1]=-1;
return a;
    }
    else {

   

// last occurence :


int last = -1;

low= 0;
high = n-1;


 while(low<=high)
    {
        int mid = (low+high)/2;

        if(nums[mid]==target)
        {
            last=mid;
           low=mid+1; // keep getting the largest

        }

        else if(nums[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            high = mid-1;
        }
    }
    
a[0]=first;
a[1]=last;
return a;
    }
    }
}


//Better : O(n log n )--- Binary Search
/*
// Lower bound :
int n = nums.length;
int low= 0;
int high = n-1;
int lb =n;
int a[]=new int[2];

while(low<=high)
{
    int mid = (low+high)/2;

    if(nums[mid]>=target)
    {
        lb=mid;
        high=mid-1;
    }
    else
    {
        low=mid+1;
    }
}
// Upper Bound :

low=0;
high=n-1;
int ub=n;

while(low<=high)
{
    int mid = (low+high)/2;

    if(nums[mid]>target)
    {
        ub=mid;
        high=mid-1;
    }
    else
    {
        low=mid+1;
    }
}


 if(lb ==n || nums[lb]!= target)// if lower bound didnt find the element return-1
 // it either points to hypothetical n or the array index is not target so we return -1
                {
                    a[0]=-1;
                   a[1]= -1;
                }
            else // it is the occurences of first and last
            {
                a[0]=lb; // first
                a[1]=ub-1; // last, we need to subtract 1 from upper bound
                
            }
            return a;
                }
            }


*/

   //Bruteforce : O(n)
   /*
   
        int first = -1;
        int last = -1;
        int n = nums.length;
        int a[]=new int[2];

        for(int i = 0;i<n;i++)
        {
            if(nums[i]==target)
            {
                if(first==-1)
                
                    first=i;
                    
                    last = i;
                
            }
        }
        a[0]=first;
        a[1]=last;

        return a;
        
    }
}
*/