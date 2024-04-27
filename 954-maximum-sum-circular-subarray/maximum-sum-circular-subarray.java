class Solution {
    public int maxSubarraySumCircular(int[] nums) {

/*
int n = nums.length;

int max_straight_sum = INT_MIN;
int min_straight_sum= INT_MAX;
int array_sum=0;

int temp_max_sum=0;
int temp_min_sum=0;

for(int i=0;i<n;i++)
{
    array_sum+=nums[i];
}


*/


 int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;


       for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            

             total += a;

           
            minSum = Math.min(minSum, curMin);
             curMin = Math.min(curMin + a, a);
           
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