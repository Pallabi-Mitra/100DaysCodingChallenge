class Solution {
    public String longestCommonPrefix(String[] strs) {

// sorting the string array,lexicographically, then checking with only first and last string.
// how much they match will be the max available length of prefix common among all.
// TC: O(n log n + m):

   

      

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






/*
        String res="";
        int j = 0;
        int i  =0;

        int m = strs.length;
        int n = strs[0].length();
       
      
        if(m==1)
        {
            while(i<n)
            {
                 res+= strs[0].charAt(i);
                 i++;
            }
          
          
        }
        else if(m==2 && strs[0].equals(""))
        {
            return "";
        }
        
        else
        {

        for(i =1;i<strs.length;i++)
        {

            for(j=0;j<strs[i].length;i++)
            {
                if(strs[i-1].charAt(0)!=strs[i].charAt(0))
              {
                return "";
              }
               else if(strs[i-1].charAt(j)==strs[i].charAt(j))
                {
                        res+=charAt(j);
                }
        
            }
              
              
            
        }
        
       // int n = strs[0].length();
        for(i=0;i<strs[0].length()&&j>0;i++)
        {
                res+=strs[0].charAt(i);
                j--;
        }
        }
        return res;
         }
        
    
}

       */ 
   