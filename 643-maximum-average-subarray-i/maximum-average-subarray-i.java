class Solution {
    public double findMaxAverage(int[] nums, int k) {

//Sliding Window :

    int left = 0;
    int right = 0;
    int n = nums.length;
    int sum = 0;
    int cnt = 0;
    double avg = 0;
    double result = Double.NEGATIVE_INFINITY;
    

    while(right < n)
    {
        
        cnt ++;

        while(cnt > k)
        {
            sum-=nums[left];
            left++;
            cnt--;
        }
     
        
            sum += nums[right];
        



        if(cnt==k)
        {
            avg = (double)sum/k;
            result = Math.max(result,avg);
        }

        right ++;
    }
        return result;
    }
}