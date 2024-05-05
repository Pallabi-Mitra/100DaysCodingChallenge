class Solution {
    public List<Integer> findDuplicates(int[] nums) {


// Optimized : HashMap


List<Integer> ans = new ArrayList<>();
        int n = nums.length;


HashMap<Integer, Integer> map = new HashMap<>();
         
    for (int element : nums) 
    {   
        if(map.get(element) == null)
        {
            map.put(element, 1);
        }
        else
        {
            map.put(element, map.get(element)+1);
        }
    }
         
   for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
     
        if(entry.getValue() > 1)
        {
           ans.add(entry.getKey());
        }
    }

return ans;







    }
}


/* optimized : 

 List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }
}

*/




        // Bruteforce : TLE
        /*

        int n = nums.length;
        List<Integer> al = new ArrayList<>();
        int i,j;

        for(i = 0;i<n;i++)
        {
            int count = 0;
                for(j = i+1;j<n;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                    if(count==1)
                        {
                            al.add(nums[j]);
                            break;
                        }
                }
                
        }
        
        return al;
    }
}
*/