class Solution {
    public int[] shuffle(int[] nums, int n) {


        int x=0;
        int y=n;
        int temp[]=new int[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                temp[i]=nums[x];
                x++;
            }
            else
            {
                temp[i]=nums[y];
                y++;
            }
         }

         return temp;
    }
}