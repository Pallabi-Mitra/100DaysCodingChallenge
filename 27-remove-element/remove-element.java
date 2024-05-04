class Solution {
    public int removeElement(int[] nums, int val) {

/*
        int n = nums.length;
        int c=0;

        for(int i = 0;i<n;i++)
        {
            if(nums[i]==val)
            {
                nums[i]=Integer.MAX_VALUE;
                c++;

            }
        }

        Arrays.sort(nums);
        int index = n-c;
        int temp[]=new int[index];
        for(int i = 0;i<index;i++)
        {
            temp[i]=nums[i];
        }

        return temp[];
        */

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
  
    }
}