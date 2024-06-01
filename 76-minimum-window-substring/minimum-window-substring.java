class Solution {
    public String minWindow(String s, String t) {
 

// Sliding Window :


int hash[]= new int[256];

int left = 0;
int right = 0;
int m = t.length();
int n = s.length();
int minLen = Integer.MAX_VALUE;
int sIndex = -1;
int count = 0;

// pre insert the characters of t string in hash table
    for(int i = 0;i<m;i++)
    {
        hash[t.charAt(i)]++;
    }

    while( right < n)
    {
        if(hash[s.charAt(right)]>0)// matches with character of t so positive pre inserted
        {
            count++; 
        }
        hash[s.charAt(right)]--; //  decrease the value of s string characters

        while(count == m) // possible answer // but keep shrinking to get least size
        {
            if(right-left+1 < minLen)
            {
                minLen = right - left+1;
                sIndex = left;
            }
// Reduce the value of the left characters
            hash[s.charAt(left)]++;
//
            if(hash[s.charAt(left)]>0) // gets positive means t character got removed from the substring
            {
                count--;
            }
            left++;
        }
        right++;
    }

    return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
    }
}


 // Bruteforce :
/*
 int n = s.length();
    int m = t.length();
    int sIndex = -1;
    int minLen = Integer.MAX_VALUE;

    // Edge case: if t is longer than s, no window can contain t
    if (m > n) {
        return "";
    }

    // Hash table to store character frequency of t
    int[] hashT = new int[256];
    for (int i = 0; i < m; i++) {
        hashT[t.charAt(i)]++;
    }

    for (int i = 0; i < n; i++) {
        int[] hashS = new int[256];
        int count = 0;

        for (int j = i; j < n; j++) {
            // Insert character from s in the hash table
            hashS[s.charAt(j)]++;
            
            // Check if the character is part of t and is still needed
            if (hashS[s.charAt(j)] <= hashT[s.charAt(j)]) {
                count++;
            }

            // If all characters are matched
            if (count == m) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    sIndex = i;
                }
                break; // break since we are looking for minimum window
            }
        }
    }

    // If no valid window is found
    if (sIndex == -1) {
        return "";
    }

    return s.substring(sIndex, sIndex + minLen);
    }
}
 
 */
 
 // Bruteforce :
 /*
 
         int minLength = Integer.MAX_VALUE;
    String minWindow = "";
    
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
            String substring = s.substring(i, j + 1);
            if (containsAllChars(substring, t)) {
                if (substring.length() < minLength) {
                    minLength = substring.length();
                    minWindow = substring;
                }
            }
        }
    }
    
    return minWindow;
}

private boolean containsAllChars(String s, String t) {
    int[] count = new int[128];
    for (char c : t.toCharArray()) {
        count[c]++;
    }
    for (char c : s.toCharArray()) {
        count[c]--;
    }
    for (int i : count) {
        if (i > 0) return false;
    }
    return true;
        
    }
}


*/