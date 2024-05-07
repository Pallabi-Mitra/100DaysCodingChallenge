class Solution {
    public int removeDuplicates(int[] nums) {
       
       int n = nums.length;
       int low =1;


       for(int i = 1;i<n;i++)
       {
            if(nums[i-1]!=nums[i])
            {
                nums[low]=nums[i];
                low++;
            }
       }

       return low;
  
        /*
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
        */
    }
}