class Solution {
    public void sortColors(int[] nums) {

// TC : O(n)

    //Dutch Flag Algorithm

    int n = nums.length;
    int low=0, mid = 0, high = n-1;

    while(mid<=high)
    {
        if(nums[mid]==0)
        {
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;
            mid++;
            low++;
        }
        else if(nums[mid]==1)
        {
             mid++;
        }
       
        else 
        {
            int temp = nums[high];
            nums[high] = nums[mid];
            nums[mid] = temp;
          //  mid++;
            high--;
        }
    }

    }
}

// TC : O(n)
/*
        int count_0 = 0;
        int count_1 = 0;
      

        for(int i = 0; i< nums.length;i++)
        {
            if(nums[i]==0)
                count_0++;
            if(nums[i]==1)
                count_1++;
           
        }

        for(int i  =0;i<count_0;i++)
        {
            nums[i]=0;
        }
        for(int i = count_0;i<count_0+count_1;i++)
        {
            nums[i]=1;
        }
        for(int i = count_0+count_1;i<nums.length;i++)
        {
            nums[i]=2;
        }
        
    }
}

*/