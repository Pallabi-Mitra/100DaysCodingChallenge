class Solution {
    public int[] rearrangeArray(int[] nums) {


        // two-pointer : 


        int start = 0;
        int n = nums.length;
        int arr[]=new int[n];

        int i,j=0,k=0;

        for(i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
                    arr[2*k + 1]= nums[i];
                    k++;
            }
            else
            {
                arr[2*j]= nums[i];
                j++;
            }
        }

return arr;





/*
        // Brute Force : O(N), O(1) :


        int n = nums.length;

        int pos[]=new int[n/2];
        int neg[]=new int[n/2];
        int k =0,i,j=0;
        for(i = 0;i<n;i++)
        {
            if(nums[i]<0)
            {
                neg[j]=nums[i];
                j++;
            }
            else
            {
                pos[k]=nums[i];
                k++;
            }

        }

        for(i=0;i<n/2;i++)
        {
            nums[2*i]=pos[i];
             nums[2*i+1]=neg[i];
        }


return nums;
        */
    }
}