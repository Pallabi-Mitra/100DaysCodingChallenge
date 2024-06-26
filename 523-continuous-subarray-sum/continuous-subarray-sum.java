class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
/*


if s2 % k == s1 % k
then every number in between must be a sum divisible by k completely
so we can return true


Using map to store the modulos of every prefix sum
when two modulos matches we know we have sum multiple of K between them, if size is motre than 2 we return true




*/
      //Bruteforce :
      /*  
             int n = nums.length;
    
            for(int i = 0;i<n ; i++)
            {
                int sum = nums[i];
                    for(int j = i+1;j<n;j++)
                {
                    sum += nums[j];
                    if(sum%k==0)
                    {
                        return true;
                    }
                    
                    
                }
            }
    
            return false;
            */
        // Map to store the modulus and its index
    Map<Integer, Integer> modMap = new HashMap<>();
    // Initialize map with modulus 0 at index -1 for cases where the subarray starts from index 0
    modMap.put(0, -1);
    int runningSum = 0;

    for (int i = 0; i < nums.length; i++) {
        runningSum += nums[i];
        int mod = runningSum % k;
        // Adjusting negative mod values
        if (mod < 0) mod += k;
        // Check if we have seen this mod value before
        if (modMap.containsKey(mod)) {
            // Ensure subarray length is at least 2
            if (i - modMap.get(mod) > 1) {
                return true;
            }
        } else {
            // Store the first occurrence of this mod value
            modMap.put(mod, i);
        }
    }
    return false;
    }
}