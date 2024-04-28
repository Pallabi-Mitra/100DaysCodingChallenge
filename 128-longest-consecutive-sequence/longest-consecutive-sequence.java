class Solution {
    public int longestConsecutive(int[] nums) {

// optimal :

int n = nums.length;

if(n==0)
    return 0;

    int i;
Set<Integer> s  = new HashSet<>();

int longest=1;

    for(i=0;i<n;i++)
    {
            s.add(nums[i]);
    }

    for(int it: s)
    {
        if(!s.contains(it-1))
        {
            int count=1;
            int x=it;


                while(s.contains(x+1))
                {
                    x=x+1;
                    count++;
                }
                 longest=Math.max(longest,count);
        }

       
    }


return longest;






/* better :


        int n = nums.length;
        Arrays.sort(nums);
        int len=1;
        int count=0;
        int last_small=Integer.MIN_VALUE;
        if (n == 0) return 0;

        for(int i = 0;i<n;i++)
        {
            if(nums[i]-last_small==1)
            {
                last_small=nums[i];
                count++;
                
                
            }
            else if(nums[i]!=last_small)
            {
                last_small=nums[i];
                count=1;
               

            }

             len=Math.max(len,count);
        }

       

        return len;

*/

    }
}