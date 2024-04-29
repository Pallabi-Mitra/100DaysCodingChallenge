class Solution {
    public int majorityElement(int[] v) {

// Brute Force : Set
/*
        HashSet<Integer> s = new HashSet<>();

        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            s.put(nums[i]);
        }

        int s_size = s.size();
        
        for(i=0;i<n;i++)
        {
            if(nums[i]==s.contains(i))
            {

            }
        } 


        */



        // Brute Force : counting
/*
        
       long count;
      int n = nums.length;
        int i=0 , j;

        while(i<n)
        {
             count = 0;
               

                for(j=0;j<n;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                }
                
                if(count > n/2)
                {
                   return nums[i];
                }
            i++;   
        }     

        return -1;  
*/
        // Better Solution : Hashing : 


        int n = v.length;
        int i ;

        HashMap<Integer,Integer> mpp = new HashMap<>();
/*
        for(i=0;i<n;i++)
        {
            int freq=0;
            int key = nums[i];

            if(mpp.containsKey(key))
            {
                freq = mpp.get(key);
            }

            freq++;

            mpp.put(key,freq);
        }
*/

        for(i=0;i<n;i++)
  {
    int freq=1;
    if(mpp.containsKey(v[i]))
    {
        int rem=mpp.get(v[i]);
        rem++;
        mpp.put(v[i],rem);
      
    }
    else
    {
        mpp.put(v[i],freq);
    }
  }
      int res=0;
     for(Map.Entry<Integer,Integer> it : mpp.entrySet())
     {

       //int res = Math.max(it.getValue());

       if(it.getValue()>n/2)
       {
         res = it.getKey();
       }
      
     }

        return res;

    }
}


        // Moore's Voting Algorithm : 
/*
        int n = nums.length;

        int i;
        int count=0;
        int ele=0; 
    
        for(i=0;i<n;i++)
        {
         if(count==0)
            {
              
                count=1;
                ele = nums[i];
            }
            else if(nums[i]==ele)
            {
                    count++;
            }
            else
            {
                    count--;
            }


        }

        int count1=0;

        for(i=0;i<n;i++)
        {
                if(nums[i]==ele)
                {
                    count1++;
                }
        }

        if(count1> n/2)
        {
            return ele;
        }
        return -1;
    }
}
*/