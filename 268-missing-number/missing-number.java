class Solution {
    public int missingNumber(int[] nums) {
        

        int n =nums.length;

        int hash[]=new int[n+1];
        int i;
        for(i=0;i<=n-1;i++)
        {
            hash[nums[i]]=1;
        }

        for(i=0;i<=n;i++)
        {
            if(hash[i]==0)
                return i;
        }
        return -1;
    }
}