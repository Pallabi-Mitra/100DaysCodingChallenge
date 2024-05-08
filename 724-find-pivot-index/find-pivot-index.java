class Solution {
    public int pivotIndex(int[] dp) {

/*

 int n=nums.length;
        int tSum=0;
        for(int i=0;i<n;i++) tSum+=nums[i];
        int prefixSum=0;
        int suffixSum=tSum;
        for(int i=0;i<n;i++){
            if(i==0){
                prefixSum=nums[i];
                suffixSum=tSum;
            } else{
                nums[i]+=nums[i-1];
                prefixSum=nums[i];
                suffixSum=tSum-nums[i-1];
            }
            if(prefixSum==suffixSum) return i;
        }
        return -1;
        */
         int n=dp.length;
        for(int i=1;i<n;i++){
            dp[i]+=dp[i-1];
        }
        if(dp[n-1]-dp[0]==0)
            return 0;
        for(int i=1;i<n-1;i++){
            if(dp[i-1]==dp[n-1]-dp[i])
                return i;
        }
        if(dp[n-2]==0)
            return n-1;
        return -1;
    }
}
//bruteforce : O(n2):
/*

        int n = nums.length;
        
        int index=Integer.MAX_VALUE;

        for(int i =0;i<n;i++)
        {
            int leftSum = 0;
        int rightSum = 0;
            for(int j = 0;j<i;j++)
            {
                    leftSum+=nums[j];
            }
            for(int k = i+1;k<n;k++)
            {
                rightSum+=nums[k];
            }

            if(rightSum==leftSum)
            {
                index = Math.min(index,i);
            }
            
        }

        if(index==Integer.MAX_VALUE)
                 return -1;
        else
                return index;
        
    }
}
*/