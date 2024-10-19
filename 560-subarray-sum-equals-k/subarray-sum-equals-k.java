class Solution {
    public int subarraySum(int[] nums, int k) {

        
	        HashMap<Integer,Integer> mpp = new HashMap<>();
	        int count = 0;
            int prefixSum = 0;
            int complement = 0;
            mpp.put(0,1);
	        for(int i : nums)
	        {
	        	prefixSum+=i;
                complement = prefixSum-k;
                if(mpp.containsKey(complement))
                {
                    count += mpp.get(complement);
                }

	            mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0)+1);
	            
	        }

	        return count;
        
    }
}