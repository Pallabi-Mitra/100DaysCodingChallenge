class Solution {
    public int maxSubarraySumCircular(int[] nums) {

int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
int n = nums.length;

       for (int i =0;i<n;i++) {

            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);
            

             total += nums[i];

             curMin = Math.min(curMin + nums[i], nums[i]);
             minSum = Math.min(minSum, curMin);
           
           
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}

// optimized :
/*
 int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;


       for (int a : nums) {

            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            

             total += a;

             curMin = Math.min(curMin + a, a);
             minSum = Math.min(minSum, curMin);
           
           
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
 */

//Bruteforce :











    
// Try :

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
        
    }
}
*/