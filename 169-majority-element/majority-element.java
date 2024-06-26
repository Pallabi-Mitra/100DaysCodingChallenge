class Solution {
    public int majorityElement(int[] nums) {


        // Moore's Voting Algorithm : 

        int n = nums.length;

        int i;
        int count=0;
        int ele=0; 
    
        for(i=0;i<n;i++)
        {
         if(count==0) // if counts get 0 we start to form a new array
            {
              
                count=1;
                ele = nums[i];
            }
            else if(nums[i]==ele) // if same element we continue increasing the count
            {
                    count++;
            }
            else // if different we decrease the count
            {
                    count--;
            }


        }
        return ele;
// reiterates the array to check if the element chosen is majority or not :
/*
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
        */
    }
}



        // Better Solution : Hashing : o(n) -- hashmap in java takes o(1) to insert elements

/*
        int n = nums.length;
        int i ;

        HashMap<Integer,Integer> mpp = new HashMap<>();

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

// store the occurences count in the map : 
      
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
  
  // Iterate on the map :
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
*/

        // Moore's Voting Algorithm : 
/*
        int n = nums.length;

        int i;
        int count=0;
        int ele=0; 
    
        for(i=0;i<n;i++)
        {
         if(count==0) // if counts get 0 we start to form a new array
            {
              
                count=1;
                ele = nums[i];
            }
            else if(nums[i]==ele) // if same element we continue increasing the count
            {
                    count++;
            }
            else // if different we decrease the count
            {
                    count--;
            }


        }
// reiterates the array to check if the element chosen is majority or not :
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








        // Brute Force : counting method : O(n2)
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
        }
        }




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
