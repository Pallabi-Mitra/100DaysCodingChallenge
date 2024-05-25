class Solution {
    public String longestCommonPrefix(String[] strs) {



 // Return empty string if input array is empty
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Sort the array of strings
        Arrays.sort(strs);
        
        // Take the first and last strings in the sorted array
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        // Initialize an index to track the common prefix length
        int i = 0;
        
        // Compare characters of the first and last strings
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        // Return the common prefix
        return first.substring(0, i);
    }
}



// sorting the string array,lexicographically, then checking with only first and last string.
// how much they match will be the max available length of prefix common among all.
// TC: O(n log n + m):

   

  // Optimized :
  /*    

    Arrays.sort(strs); // sorts the string array lexicographically
      if (strs[0].equals("")|| strs.length == 0) {
            return "";
        }
    int n = strs.length;
    int i;

    String first = strs[0];
    String last = strs[n-1];

    int f = strs[0].length();
    int l = last.length();

    int len = f>l ? l : f;
    if(first.charAt(0)!=last.charAt(0))
        {
            return "";
        }

    for(i = 0;i<len;i++)
    {
        
        if(first.charAt(i)==last.charAt(i))
        {
           continue;
        }
        else
        {
            break;
        }
    }

    return first.substring(0,i);

    }
}
*/






