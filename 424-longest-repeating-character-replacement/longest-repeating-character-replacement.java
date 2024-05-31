class Solution {
    public int characterReplacement(String s, int k) {


// Optimized Sliding Window Technique : O(n)

int n = s.length();
    int maxlen = 0;
    int left = 0;
    int right=0;
    int window_size=0;
    // maxFreq will store the count of the most frequent character in the current window
    int maxFreq  = 0;
    // Initialize an array to count the frequency of each character in the window
    int hash[]= new int[26];

// Use two pointers to represent the window, left and right
    while(right < n)
    {
        // Increment the count of the character at the 'right' pointer in hash table
        hash[s.charAt(right)-'A']++;

// Update maxFreq with the frequency of the most frequent character in the current window
        maxFreq = Math.max(maxFreq,hash[s.charAt(right)-'A']);

// Calculate the current window size
        window_size = right-left+1;

 // If the number of replacements needed exceeds k, shrink the window from the left
        if(window_size - maxFreq > k)
        {
            hash[s.charAt(left)-'A']--;
            left++;
        }

       
// Update maxLength with the size of the current valid window
       if(window_size - maxFreq <=k)
       {
             maxlen= Math.max(maxlen,window_size);
       }
       
        right++;

    }

 // Return the maximum length of the valid window found
return maxlen;
    }
}






// Bruteforce : O(n^2)
/*

    int n = s.length();
    int maxlen = 0;
    int changes=0;
    int maxFreq  = 0;




    for(int i = 0;i<n;i++)
    {
        int hash[]=new int[26]; // only english upper case letters
        for(int j = i;j<n;j++)
        {
            hash[s.charAt(j)-'A']++;
        

        maxFreq = Math.max(maxFreq,hash[s.charAt(j)-'A']);
        changes = (j-i+1) - maxFreq;

        if(changes <=k)
        {
            maxlen = Math.max(maxlen,j-i+1);
        }
        else
        break;
        }
    }

      return maxlen;  
    }
}

*/