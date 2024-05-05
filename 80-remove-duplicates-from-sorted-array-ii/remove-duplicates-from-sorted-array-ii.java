class Solution {
    public int removeDuplicates(int[] nums) {


/*
 int i =0;
        
        for(int ele : nums)
        {
            if(i==0 || i==1 || nums[i-2] != ele)
            {
                nums[i] = ele;
                i++;
            }
        }
    return i ;
*/
  int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;

/*
        int n = nums.length;
        int c=0;
        int low = 1;
        boolean flag = true;
        
        for(int i = 1;i<n;i++)
        {
                  if(nums[i-1]==nums[i] && flag==true)
                    {
                        
                        low++;
                        flag=false;
                    }

                else if(nums[i-1]!=nums[i])
                {

                }

        }
                   
            
            

        }
*/
        
    }
}