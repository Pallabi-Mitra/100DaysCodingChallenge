class Solution {
    public int findKthPositive(int[] arr, int k) {

//optimized : O(logn):
 int n = arr.length;
int low = 0;
int high = n-1;
while(low<=high)
{
    int mid = (low+high)/2;
    int missing = arr[mid]-(mid+1);

    if(missing<k)
    {
        low=mid+1;
    }
    else
    {
        high = mid-1;
    }
}
return k+high+1;
    }
}







        /// bruteforce : o(n)
        /*
       // [2,3,4,7,11], k=5

      //  [1,2,3,4,5,6,7,8,9,10,11,....], here 9 is missing no

        int n = arr.length;

        for(int i=0;i<n;i++)
        {
            if(arr[i]<=k)
            {
                k++;
            }
            else
            {
                break;
            }
        }
        return k;
            }
}
        */
