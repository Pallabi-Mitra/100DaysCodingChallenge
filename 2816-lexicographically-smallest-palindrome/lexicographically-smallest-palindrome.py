class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:

        #Convert String to List of characters

        chars=list(s)

        left=0
        right = len(s)-1

        while left<right:
            if chars[left]<chars[right]:
                chars[right]=chars[left]
            elif chars[right]<chars[left]:
                chars[left]=chars[right]

            left+=1
            right-=1

        
        return "".join(chars)
        