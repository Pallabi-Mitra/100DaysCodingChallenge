class Solution {

    public int calculateWeight(int a[], int mid)
    {
        int total=0;
        int count=1;
        /*
        for(int i=0;i<a.length;i++)
        {
           
            if(total<mid)
            {
                 total+=a[i];
            }
            else
            {
                count++;
                total=0;
            }
            return count;
        }
*/
/*
int i =0;
int m = a.length;
        while(total<=mid && i<m)
        {
             total+=a[i];
             
                    if(total>mid)
                {
                    count++;
                    total=0;
                    i--;
                }
                i++;
        }
        return count;
 */
    for(int i = 0;i< a.length;i++)
    {
        if(a[i]+total>mid)
        {
            count++;
            total=a[i];
        }
        else
        {
            total+=a[i];
        }
        
    }

return count;

    }
    public int shipWithinDays(int[] weights, int days) {


        int n = weights.length;
        int maxi = Integer.MIN_VALUE;
        int sum=0;

        for(int i = 0;i<n;i++)
        {
            maxi = Math.max(maxi,weights[i]);
            sum+=weights[i];
        }

        int low = maxi;
        int high = sum;
        int ans =-1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int res = calculateWeight(weights, mid);

            if(res<=days)
            {
                ans=mid;
               high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return ans;
        
    }
}