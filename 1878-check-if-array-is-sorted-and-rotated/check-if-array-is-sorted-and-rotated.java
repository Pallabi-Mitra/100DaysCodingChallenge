class Solution {
    public boolean check(int[] nums) {
int c = 0;
/*
    for(int i = 0;i < nums.length; i++){
        if(nums[i] > nums[(i+1)%nums.length]){
            c++;
        }
        if(c > 1){
            return false;
        }
    }
    return true;
   */
   int n = nums.length;

   for(int i=1;i<nums.length;i++)
   {
    if(nums[i-1]>nums[i])
    {
        c++;
    }
   }

   if(nums[n-1]>nums[0])
   {
    c++;
   }

    return c<=1;
   }     
    
}
