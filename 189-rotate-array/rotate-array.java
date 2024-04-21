class Solution {
    public void rotate(int[] nums, int k) {
        


        int i;
        int arr[]=new int[nums.length];

        for(i =0;i<nums.length;i++)
        {
            arr[(i+k)%nums.length]=nums[i];  // 7%7==0
        }
 for(i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }
    }
}
        // Optimal Solution : Striver: works for odd number

/*

  int n = nums.length;
  // Function to Rotate k elements to left
  //public static void Rotateeletoleft(int[] arr, int n, int k) {
    // Reverse first k elements
    Reverse(nums, 0, k);
    // Reverse last n-k elements
    Reverse(nums, k+1 , n - 1);
    // Reverse whole array
    Reverse(nums, 0, n - 1);
  
    }
    public void Reverse(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

          //  Brute Force Solution : LEFT ROTATE 
          /*
            int n = nums.length;
            k = k%n;

            int temp[] = new int[k];

            for(int i =0;i<k;i++)
            {
                temp[i]=nums[i];
            }
          for(int i = k;i<n;i++)
            {
                    nums[i-k]=nums[i];
            }

            for(int i = n-k;i<n;i++)
            {
                nums[i]=temp[i-(n-k)];
            }


*/


// Brute Force : RIGHT ROTATE
/*
        int n = nums.length;
        k = k%n;
        int i;
       // int s = k+1;
        int s = n-k;
        int temp[]=new int[n-k];

        for(i=0;i<s;i++)
        {
            temp[i]=nums[i];
        }

        for(i=n-k;i<n;i++)
        {
            nums[i-(n-k)]=nums[i];
        }
      //  int j =0;
        for(i=k;i<n;i++)
        {
          //  nums[i]=temp[j];
          //  j++;

          nums[i]= temp[i-k];
        }


*/






        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* My Solution : 
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

       // Optimal Solution : Love Babbar
       /*
int i;
        int arr[]=new int[nums.length];

        for(i =0;i<nums.length;i++)
        {
            arr[(i+k)%nums.length]=nums[i];  // 7%7==0
        }
 for(i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }

*/



