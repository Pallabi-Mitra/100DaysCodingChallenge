class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low =1;
        int n = piles.length;
        
        int maxi = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++)
        {
            if(piles[i]>maxi)
            {
                maxi = piles[i];
            }
        }

        int high = maxi;
        
        int ans = Integer.MAX_VALUE;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int total = 0;
            for(int i = 0;i<n;i++)
            {
                total +=Math.ceil((double)piles[i]/(double)mid); 
            }

            if(total<=h) // keep looking for minimum speed value possible
            {
                ans = mid;
                high=mid-1;
            }
            else // time is exceeding deadline so need to increase up the k value
            {
                low=mid+1;
            }
        }

        return ans;
        

    }
}