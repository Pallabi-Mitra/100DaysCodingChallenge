/*

class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
       
        //if (bloomDay.length < val) return -1;
        if((long) m * k > bloomDay.length) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
       

//        Take the boundary starting from 1 to the max day in the bloomDay.
        while (min < max) {
            int mid = min + (max - min) / 2;
            int possibleBookies = getPossibleBookies(bloomDay, mid, k);
//            The
            if (possibleBookies < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int getPossibleBookies(int[] bloomDay, int day, int k) {
//        This method is to find the number of bouquets that can be formed on a given day.
        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= day) {
//                If the current flower can be taken with in days then increase the flower flowersCollected.
                flowersCollected++;
            } else {
//                If there is a flower in between that takes more number of days then the given day, then resent the counter.
                flowersCollected = 0;
            }
//            If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
    }
}


*/












class Solution {

/*
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
        */

 public int roseGarden(int[] bloomDay, int mid, int k){
        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= mid) {
//                If the current flower can be taken with in days then increase the flower flowersCollected.
                flowersCollected++;
            } else {
//                If there is a flower in between that takes more number of days then the given day, then resent the counter.
                flowersCollected = 0;
            }
//            If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
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
