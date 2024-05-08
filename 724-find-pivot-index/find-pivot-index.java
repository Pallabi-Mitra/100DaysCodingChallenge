class Solution {
    public int pivotIndex(int[] nums) {

//bruteforce : O(n2):

        int n = nums.length;
        
        int index=Integer.MAX_VALUE;

        for(int i =0;i<n;i++)
        {
            int leftSum = 0;
        int rightSum = 0;
            for(int j = 0;j<i;j++)
            {
                    leftSum+=nums[j];
            }
            for(int k = i+1;k<n;k++)
            {
                rightSum+=nums[k];
            }

            if(rightSum==leftSum)
            {
                index = Math.min(index,i);
            }
            
        }

        if(index==Integer.MAX_VALUE)
                 return -1;
        else
                return index;
        
    }
}