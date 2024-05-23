class Solution {
    public int[] twoSum(int[] nums, int target) {

// Optimized :  2 - pointers : doesnt work since array is getting sorted
// can send boolean yes/no if pair exists or not
/*
 int n = nums.length;
  int a[]=new int[2];
 int left = 0;
 int right = n-1;
 Arrays.sort(nums);

 while(left<right)
 {
    if(nums[left]+nums[right]==target)
    {
            a[0]= left;
            a[1]=right;
            return a;
    }
    else if(nums[left]+nums[right]>target)
    {
        right--;
    }
    else
    {
        left++;
    }
 }
 return a;

*/




        // Better Solution : Hashing


        HashMap<Integer,Integer> mpp = new HashMap<>();

        int a[]=new int[2];

        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            int num = nums[i];

            int moreNeeded = target-num;

            if(mpp.containsKey(moreNeeded))
            {
                a[0]=mpp.get(moreNeeded);
                a[1]=i;
                return a;
            }

            mpp.put(nums[i],i);
        }


        return a;
        
    }
}