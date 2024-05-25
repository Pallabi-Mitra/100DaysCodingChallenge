class Solution {
    public String longestCommonPrefix(String[] strs) {



    if (strs == null || strs.length == 0) {
            return "";
        }
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        return first.substring(0, i);
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
   