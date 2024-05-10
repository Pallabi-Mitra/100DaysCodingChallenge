class Solution {

        public int roseGarden(int[] bloomDay, int mid, int k)
        {
            int total =0;
            int count=0;
            for(int i=0;i<bloomDay.length;i++)
            {
                if(bloomDay[i]<=mid)
                {
                    count++;
                }
                else
                {
                    total += Math.floor((double)count/(double)k);
                    count=0;
                }
            }
              total += Math.floor((double)count/(double)k);
            return total;
        }

    public int minDays(int[] bloomDay, int m, int k) {

    int n = bloomDay.length;
    int maxi = Integer.MIN_VALUE;
    int mini = Integer.MAX_VALUE;
    long mul = m * k;
    if(n < mul)
        return -1;

    for(int i =0;i<n;i++)
    {
        maxi = Math.max(maxi,bloomDay[i]);
        mini=Math.min(mini,bloomDay[i]);
    }

    int low = mini;
    int high=maxi;
    int ans=-1;
   
    while(low<=high)
    {
        int mid = (low+high)/2;
        int total = roseGarden(bloomDay,mid,k);

        if(total>=m)
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