class Solution {
    public int maxSubArray(int[] nums) {
        




// Optimal : O(N): Kadane Algorithm :


int n = nums.length;

int sum = 0;
int i;
int maxi = nums[0];

for(i=0;i<n;i++)
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

        //maxi=Math.max(maxi,sum);

}
return maxi;

        // BruteForce : O(N^2)
        /*

    int i,j;
    int n = nums.length;
    int sum;
    int maxi=Integer.MIN_VALUE;

    for(i=0;i<n;i++)
    {
        sum=0;
        for(j=i;j<n;j++)
        {
            sum+=nums[j];
            maxi=Math.max(maxi,sum);
        }
    }
    return maxi;
*/


    }
}