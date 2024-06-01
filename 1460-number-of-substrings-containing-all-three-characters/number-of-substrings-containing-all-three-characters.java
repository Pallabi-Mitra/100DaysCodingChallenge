class Solution {
    public int numberOfSubstrings(String s) {


// Optimized Sliding Window :


int lastSeen[]=new int[3];
Arrays.fill(lastSeen,-1);
// int lastSeen[]={-1,-1,-1};
int n = s.length();
int count = 0;

for(int i = 0;i<n;i++)
{
        lastSeen[s.charAt(i)-'a']=i; // add index of the last seen position of the characters

        if(lastSeen[0]!= -1 && lastSeen[1]!= -1 && lastSeen[2]!= -1 ) // all 3 characters are present
        {
            // no of subarrays 
            count = count + 1+ Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]);
        } 
}
return count;
    }
}









//Hashing:
/*
 int[] count = new int[3]; // count[0] for 'a', count[1] for 'b', count[2] for 'c'
        int left = 0;
        int result = 0;
        int n = s.length();

        // Iterate over the string with the right pointer
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++; // Update the count for the current character

            // Check if the window contains at least one of each 'a', 'b', 'c'
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - right; // All substrings starting from current left to end are valid
                count[s.charAt(left) - 'a']--; // Reduce the count of the left character
                left++; // Move the left pointer to the right
            }
        }
        return result;
    }
}
*/

// Optimized Bruteforce :
/*
int count = 0;

int n = s.length();

for(int i = 0;i<n;i++)
{
int hash[]=new int[3];
    for(int j = i;j<n;j++)
    {
        hash[s.charAt(j)-'a']=1;

        if(hash[0]+hash[1]+hash[2]==3)
        {
              count = count + (n-j); 
              break;
        }
     
    }
}
return count;
    }
}

*/
//Bruteforce : 
/*
        int count = 0;
      

        int n = s.length();

        for(int i = 0;i<n;i++)
        {
            
            for(int j = i+1;j<=n;j++)
            {
               
               String substring = s.substring(i,j);
// Check if the substring contains 'a', 'b', and 'c'
                if(substring.contains("a")&&substring.contains("b")&&substring.contains("c"))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
*/