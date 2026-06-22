class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        """
        count = {}
        res,maxCount = 0,0


        for n in nums :
            count[n] = 1 + count.get(n,0)
            res = n if count[n] > maxCount else res
            maxCount = max(count[n],maxCount)
        return res
        """

        count_map = {}
        threshold = len(nums) // 2  # This represents floor(n / 2)
    
        for num in nums:
            # Update the frequency count of the number
            if num in count_map:
                count_map[num] += 1
            else:
                count_map[num] = 1
            
            # Check if this number has crossed the majority threshold
            if count_map[num] > threshold:
                return num