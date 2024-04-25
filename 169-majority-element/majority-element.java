class Solution {
    public int majorityElement(int[] nums) {

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