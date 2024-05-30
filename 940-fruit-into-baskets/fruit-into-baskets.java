class Solution {
    public int totalFruit(int[] fruits) {

// Sliding Window Better :


    int left = 0;
    int right = 0;
    int n = fruits.length;
    
    int maxlen = 0;

    HashMap<Integer,Integer> mpp = new HashMap<>();

    while(right < n)
    {

        //if(!mpp.containsKey(fruits[right]))
        
            mpp.put(fruits[right], mpp.getOrDefault(fruits[right],0)+1);

            while(mpp.size()>2)
            {
                mpp.put(fruits[left],mpp.get(fruits[left])-1);
                
                if(mpp.get(fruits[left])==0)
                {
                     mpp.remove(fruits[left]);
                }
               
                left++;
            }

            if(mpp.size()<=2)
            {
                maxlen = Math.max(maxlen,right-left+1);
            }
        

        
        right++;
    }
    return maxlen;
    }
}





















// Bruteforce : o(n2)
/*

        int n = fruits.length;
        int count = 0;

        for(int i = 0;i<n;i++)
        {
            Set<Integer> st = new HashSet<>();
            for(int j=i;j<n;j++)
            {
                
                
                     st.add(fruits[j]);
                 if(st.size()<=2)
                

                count = Math.max(count , j-i+1);
                else
                break;
               


               


            }
        }

    return count;
        
    }
}

*/