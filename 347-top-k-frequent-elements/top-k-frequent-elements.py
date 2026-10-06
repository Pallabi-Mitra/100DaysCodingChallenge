class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:


        frequency={}
        result=[]
        min_heap=[]
        for num in nums:
            if num in frequency:
                frequency[num]+=1
            else:
                frequency[num]=1

#{1:1, 2:2, 3:3 }

        for num,freq in frequency.items():
            heapq.heappush(min_heap,(freq,num))

            #if we have size of teh heap >k  then just pop
            
            if len(min_heap) > k:

                heapq.heappop(min_heap)

        
        for freq,num in min_heap:
            result.append(num)
        return result
        