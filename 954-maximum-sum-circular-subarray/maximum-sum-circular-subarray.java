class Solution {
    public int maxSubarraySumCircular(int[] nums) {



 int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
       for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    
/*
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = nums[0];

        int i=0;
        while(i+1%n)
        {
                sum+=nums[i];

                if(sum>maxi)
                {
                    maxi=sum;
                }
                if(sum<0)
                {
                    sum=0;
                }
                i++;
                if(i>n/2)
                {
                    break;
                }
        }

        return maxi;
        */
    }
}