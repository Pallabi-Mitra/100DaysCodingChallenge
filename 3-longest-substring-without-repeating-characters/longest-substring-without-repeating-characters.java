class Solution {
    public int lengthOfLongestSubstring(String s) {


// Using Character Array :

     int maxLength = 0; // Variable to store the maximum length of the substring found
    int[] charIndex = new int[128]; // Array to store the last index of each character (for ASCII)
    Arrays.fill(charIndex, -1); // Initialize all positions to -1 indicating the character has not been seen
    int start = 0; // Start pointer of the current window

    for (int end = 0; end < s.length(); end++) { // End pointer to expand the window
        char currentChar = s.charAt(end); // Get the current character
        
        // Check if the character has been seen before and is within the current window
        if (charIndex[currentChar] >= start) {
            // Move the start to the right of the last occurrence of currentChar
            start = charIndex[currentChar] + 1;
        }
        
        // Update the maxLength if the current window is larger
        maxLength = Math.max(maxLength, end - start + 1);
        
        // Update the last seen index of the current character
        charIndex[currentChar] = end;
    }
    
    return maxLength;
    }
}


        // Hash Map : Optimal : O(n)
/*
HashMap<Character,Integer> mpp = new HashMap<>();


int n = s.length();

int left=0;
int right=0;
int maxLen= 0;

while(right<n)
{
      
    if(mpp.containsKey(s.charAt(right)))
    {
        if(left <= mpp.get(s.charAt(right)))
        left = mpp.get(s.charAt(right))+1;
    }
    

   
     mpp.put(s.charAt(right),right);
      maxLen = Math.max(maxLen,right-left+1);
        right++;
  

}

    return maxLen;



        
    }
}

*/

// Bruteforce :  O(n2)
/*

int maxlen=0;

int n = s.length();

for(int i = 0;i<n;i++)
{
    Set<Character> st = new HashSet<>();
    for(int j = i;j<n;j++)
    {
            if(st.contains(s.charAt(j)))
            {
                    break;
            }
            st.add(s.charAt(j));
               maxlen=Math.max(maxlen,j-i+1);
    }
  
   
}



return maxlen;

    }
}

*/









// HashSet :
/*
if(str.length()==0)
             return 0;
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
        
        
        
    }
}

*/