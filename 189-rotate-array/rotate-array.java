class Solution {
    public void rotate(int[] nums, int k) {
        /*
            int n = nums.length-1;
            int arr[]=new int[nums.length];

            int sub = n-k;

            int i,j=0;

            for(i=0;i<=n;i++)
            {
                if(i<=sub)
                {
                    arr[i+k]=nums[i];
                }
                else if(i>sub)
                {
                    arr[j]=nums[i];
                    j++;
                }
            }

        for(i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }
        
*/
       // nums=arr;
int i;
        int arr[]=new int[nums.length];

        for(i =0;i<nums.length;i++)
        {
            arr[(i+k)%nums.length]=nums[i];
        }
 for(i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }


    }
}