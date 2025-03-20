class Solution {
    public void moveZeroes(int[] nums) {


        // Bruteforce :

        //TC: O(n)
        //SC: O(n)

        /*

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

*/

    //Optimized :

    // SC: O(1):

    int n= nums.length;
    int p1 = 0;
    int p2 = 0;

    
    while(p2 <n)
    {
         if(nums[p2]!=0)
        {
            int swap = nums[p2];
            nums[p2]=nums[p1];
            nums[p1]=swap;
            p1++;
           // p2++;
        }
    p2++;

    }
        

        /*
       int nonZero = 0;  
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                swap(nums[nonZero], nums[i]);
                nonZero++;
            }
        }

        */

    }

    
        
    
}