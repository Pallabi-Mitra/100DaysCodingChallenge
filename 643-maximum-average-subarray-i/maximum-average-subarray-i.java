class Solution {
    public double findMaxAverage(int[] nums, int k) {

//Sliding Window :
/*
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
*/
/*
// Initialize variables for the sliding window
        int left = 0; // Left pointer for the sliding window
        int n = nums.length; // Length of the input array
        int sum = 0; // Sum of the current window
        double result = Double.NEGATIVE_INFINITY; // Maximum average found so far

        // Traverse the array using the sliding window
        for (int right = 0; right < n; right++) {
            // Add the current element to the sum
            sum += nums[right];

            // Check if the window size is reached
            if (right - left + 1 == k) {
                // Calculate the current average
                double avg = (double) sum / k;
                // Update the maximum average found so far
                result = Math.max(result, avg);
                // Remove the leftmost element from the sum and move the left pointer
                sum -= nums[left];
                left++;
            }
        }

        return result; // Return the maximum average

*/

          int n = nums.length; // Length of the input array
        int sum = 0; // Sum of the first window of size k

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize maxSum to the sum of the first window
        int maxSum = sum;

        // Slide the window from k to the end of the array
        for (int i = k; i < n; i++) {
            // Subtract the element that is leaving the window and add the element that is entering the window
            sum = sum - nums[i - k] + nums[i];
            // Update maxSum if the new sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        // Calculate and return the maximum average
        return (double) maxSum / k;
    }
}