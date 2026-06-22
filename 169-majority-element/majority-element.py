class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        # 'candidate' stores the number we currently suspect is the majority element.
    # We initialize it to None because we haven't looked at any numbers yet.
        candidate = None
        
        # 'count' tracks the "voting power" or net balance of our current candidate.
        count = 0
        
        # Iterate through each number in the array
        for num in nums:
            # If the count drops to 0, it means the previous candidate was 
            # completely canceled out by other numbers. We must pick a new candidate.
            if count == 0:
                candidate = num
            
            # If the current number matches our candidate, we increase their voting power.
            if num == candidate:
                count += 1
            # If it's a different number, they "fight" and cancel each other out, 
            # decreasing the candidate's voting power by 1.
            else:
                count -= 1
                
        # Because the majority element appears more than n // 2 times, it is 
        # mathematically guaranteed to be the last candidate standing.
        return candidate


        """
        count = {}
        res,maxCount = 0,0


        for n in nums :
            count[n] = 1 + count.get(n,0)
            res = n if count[n] > maxCount else res
            maxCount = max(count[n],maxCount)
        return res
        """

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

                """