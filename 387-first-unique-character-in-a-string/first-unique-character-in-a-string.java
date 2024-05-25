class Solution {
    public int firstUniqChar(String s) {



// Using HAsh Table :2 passes

/*
        int hash[]=new int[26];

        for(char c : s.toCharArray())
        {
            hash[c-'a']++;
        }
        char [] ch = s.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
            int index = ch[i]-'a';

            if(hash[index]==1)
            {
                return i;
            }
        }
        
        return -1;
        
    }
}
*/
// HashMap : 

// Create a hash map to store the frequency of each character
    Map<Character, Integer> charCount = new HashMap<>();
    
    // Populate the hash map with the frequency of each character
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    
    // Iterate through the string again to find the first unique character
    for (int i = 0; i < s.length(); i++) {
        if (charCount.get(s.charAt(i)) == 1) {
            return i; // Return the index of the first unique character
        }
    }
    
    // If no unique character was found, return -1
    return -1;
}
}