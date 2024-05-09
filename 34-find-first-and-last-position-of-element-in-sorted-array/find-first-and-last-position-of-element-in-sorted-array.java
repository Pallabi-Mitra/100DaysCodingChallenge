class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;
        int n = nums.length;
        int a[]=new int[2];

        for(int i = 0;i<n;i++)
        {
            if(nums[i]==target)
            {
                if(first==-1)
                
                    first=i;
                    
                    last = i;
                
            }
        }
        a[0]=first;
        a[1]=last;

        return a;
        
    }
}