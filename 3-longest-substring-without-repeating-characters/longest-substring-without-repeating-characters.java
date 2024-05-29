class Solution {
    public int lengthOfLongestSubstring(String s) {



// Bruteforce : 

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









        // Hash Map : Optimal 
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