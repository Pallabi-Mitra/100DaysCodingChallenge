class Solution:
    def isAnagram(self, s: str, t: str) -> bool:


       return Counter(s) == Counter(t) #DS in python whicg counts things automatically in python

