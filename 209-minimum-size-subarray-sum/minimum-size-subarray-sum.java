class Solution {
    public int minSubArrayLen(int target, int[] nums) {


            // bruteforce :
/*
        int n = nums.length;
        int length = Integer.MAX_VALUE;
    for(int i =0;i< n;i++)
    {														//int nums[]= {1,4,4};
    														//int target = 4;
	
        int sum = nums[i];
        if(sum >= target)
        {
            length = 1;
          
        }
       
        for(int j = i+1;j<n;j++)
        {
            
        
        	 sum +=nums[j];
		        if(sum >= target)
		        {
		            length = Math.min(length,j-i+1);
		          
		        }
		       
        }
    }
   
    		if(length < Integer.MAX_VALUE)
    		{
    			return length;
    		}
    		else
    			return 0;

                */

                // public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int currentSum = 0;
    int minLength = Integer.MAX_VALUE;

    // Iterate with the right pointer
    for (int right = 0; right < nums.length; right++) {
        currentSum += nums[right]; // Add current element to the sum

        // Shrink the window from the left as long as the sum >= target
        while (currentSum >= target) {
            minLength = Math.min(minLength, right - left + 1); // Update minimum length
            currentSum -= nums[left]; // Shrink from the left
            left++; // Move the left pointer
        }
    }

    // If no valid subarray was found, return 0
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}

    
}