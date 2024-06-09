class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         // Initialize a HashMap to store the frequency of prefix sum remainders
        Map<Integer, Integer> remainderFrequency = new HashMap<>();
        remainderFrequency.put(0, 1); // To handle subarrays that directly sum up to a multiple of k
        
        int count = 0; // To count the number of valid subarrays
        int cumulativeSum = 0; // To store the cumulative sum of elements
        
        for (int num : nums) {
            cumulativeSum += num; // Update the cumulative sum
            
            // Calculate the remainder of the cumulative sum when divided by k
            int remainder = cumulativeSum % k;
            // If remainder is negative, adjust it to be within the range [0, k-1]
            if (remainder < 0) {
                remainder += k;
            }
            
            // If the remainder has been seen before, it means there is a subarray
            // whose sum is divisible by k
            if (remainderFrequency.containsKey(remainder)) {
                count += remainderFrequency.get(remainder);
            }
            
            // Update the frequency of the remainder in the HashMap
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }
        
        return count; // Return the total count of valid subarrays
        
    }
}