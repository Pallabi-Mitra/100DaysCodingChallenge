class Solution {
    public int longestPalindrome(String s) {

/*
        HashMap<Character,Integer> mpp = new HashMap<>();
        int count = 0;
       // boolean odd_flag = false;
        int i = 0;


       // for(ch : s.toCharArray())
       for(;i<s.length();i++)
        {
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }

        if(mpp.size()==1)
        {
            count = mpp.get(s.charAt(i-1));
            return count;
        }

       // for(int n : mpp.values())

       for(Map.Entry<Character,Integer> entry : mpp.entrySet())
        {
            if(entry.getValue()%2==0)
            {
                count+=entry.getValue();
            }
            else
            {
               
               
                count+=entry.getValue()-1;

                
               
                mpp.put(entry.getKey(),entry.getValue()%2);
            }
            
        }
                 count++;
        
        

        return count;

        
    }
}
*/

        HashMap<Character,Integer> mpp = new HashMap<>();
        int count = 0;
       // boolean odd_flag = false;
        int i = 0;


       // for(ch : s.toCharArray())
       for(;i<s.length();i++)
        {
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }

        if(mpp.size()==1)
        {
            count = mpp.get(s.charAt(i-1));
            return count;
        }

       // for(int n : mpp.values())

       for(Map.Entry<Character,Integer> entry : mpp.entrySet())
        {
            if(entry.getValue()%2==0)
            {
                count+=entry.getValue();
                //mpp.remove(entry.getKey());
                mpp.put(entry.getKey(),entry.getValue()%2);
            }
            else
            {
               
               
                count+=entry.getValue()-1;

                
               
                mpp.put(entry.getKey(),entry.getValue()%2);
            }
            
        }

        // just for 1 value :
        for(int n : mpp.values())
        {
            if(n==1)
            {
                count++;
                break;
            }
        }
       
               
        
        

        return count;
    }
}