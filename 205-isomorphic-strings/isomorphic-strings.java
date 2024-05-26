class Solution {
    public boolean isIsomorphic(String s, String t) {
// Bruteforce :


/*
// Arrays to store character mappings from s to t and t to s
    int[] sMap = new int[256]; // sMap stores mappings from s to t
    int[] tMap = new int[256]; // tMap stores mappings from t to s

    // Traverse both strings
    for (int i = 0; i < s.length(); i++) {
        char sChar = s.charAt(i); // Get the character from s
        char tChar = t.charAt(i); // Get the character from t

        // Check if there is a mismatch in the mappings
        // Using sChar and tChar directly as indices in the arrays

        if (sMap[sChar] != tMap[tChar]) {
            return false; // Mismatch found, so not isomorphic
        }

        // Update the mappings
        // Use i + 1 to avoid default zero value issue
        sMap[sChar] = i + 1; // Store the index+1 for sChar in sMap
        tMap[tChar] = i + 1; // Store the index+1 for tChar in tMap
    }

    return true; // No mismatches found, strings are isomorphic
}
}

*/
// Using 2 hashmap :

        HashMap<Character,Character> mppS = new HashMap<>();
        
        HashMap<Character,Character> mppT = new HashMap<>();


        for(int i = 0;i<s.length();i++)
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            

            if(mppS.containsKey(sChar))
            {
                if(mppS.get(sChar)!=tChar)
                {
                    return false;
                }
            }
            else
            {
                mppS.put(sChar,tChar);
            }

            if(mppT.containsKey(tChar))
            {
                if(mppT.get(tChar)!=sChar)
                {
                    return false;
                }
            }
            else
            {
                mppT.put(tChar,sChar);
            }
        }

       return true;

        
    }
}
