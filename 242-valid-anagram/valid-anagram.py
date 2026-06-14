class Solution:
    def isAnagram(self, s: str, t: str) -> bool:


#HashMap solution

        if len(s)!=len(t): #If string lengths are diff definently they are not anagrams
            return False

#Creating two HashMap to store letters and their counts
        countS, countT = {},{}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i],0)  #get the key and add 1, if doesnt exist default  
            countT[t[i]] = 1 + countT.get(t[i],0)

        for c in countS:  #Iterating through all keys of the hashmap
            if countS[c] != countT.get(c,0): #if doesnt have key get default
                return False

        return True




        