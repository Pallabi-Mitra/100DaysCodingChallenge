class Solution {
    public int thirdMax(int[] nums) {

/*
        int n = nums.length;
        int left = 0;
        int right = n-1;

        if(n<3)
        {
            if(nums[0]>nums[1])
            return nums[0];
            else
             return nums[1];
        }


        Arrays.sort(nums);

        

        while(left<=right)
        {
            if(nums[left]<nums[right])
            {
                int temp = nums[right];
                nums[right]= nums[left];
                nums[left]= temp;
                left++;
                right--;
            }
        }

        

        int cnt = 1;
        for(int i = 1;i<n;i++)
        {
            if(nums[i]!=nums[i-1])
            cnt++;
            if(cnt==3)
            return nums[i];
        }

        return nums[1];
        */

       
    Arrays.sort(nums); // Ascending
    int n = nums.length;
    int count = 1; // At least one max exists

    for (int i = n - 2; i >= 0; i--) {
        if (nums[i] != nums[i + 1]) {
            count++;
        }
        if (count == 3) {
            return nums[i];
        }
    }

    return nums[n - 1]; // Return max if 3rd max doesn't exist
}

    }
