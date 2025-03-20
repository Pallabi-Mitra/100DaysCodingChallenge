class Solution {
    public void moveZeroes(int[] nums) {


        // Bruteforce :

        //TC: O(n)
        //SC: O(n)

        int n = nums.length;
        int arr[]= new int[n];
        int noOfZero =0;
        int index=0;

        for(int i=0; i<n ;i++)
        {
            if(nums[i]!=0)
            {
                arr[index]=nums[i];
                index++;
            }
           

        }

        for(int i =0;i<n;i++)
        {
            nums[i]=arr[i];
        }


        
    }
}