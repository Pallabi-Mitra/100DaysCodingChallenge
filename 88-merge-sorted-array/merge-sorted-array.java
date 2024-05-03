class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
// 2 pointers :


        int i = m-1;
        int j = n-1;
        int k = m+n -1;

      while(j>=0)
      {
        if(i>=0 && nums1[i]>nums2[j])
        {
                nums1[k]=nums1[i];
                k--;
                i--;
        }
        else
        {
            nums1[k]=nums2[j];
            j--;
            k--;

        }
      }





        // optimized :not working :
        /*

         int i = 0;
       
        int total = m+n;
        int temp;
        
        int first_index=0;
        if(n==1 && m==0)
        {
            nums1[0]=nums2[0];
        }
        else
        {
        for(i = 0;i<total;i++)
        {
            if(nums1[i]==0)
            {
                 first_index=i;
                 break;
            }
        }

        int j=first_index;
  
       i=0;
       int count=0;
    while(i<n && j<total)
    {
        j=first_index+i;
        if(nums1[j-1]<nums2[i])
        {
                nums1[j]=nums2[i];
                i++;
                j++;
                //k++;
        }
        else
        {
            int k = j-1;
            while(nums2[i]<nums1[k])
            {
                temp=nums1[j];
                nums1[j]=nums1[k];
                nums1[k]=temp;
                k--;
                j--;
                count++;

            }

            

            nums1[k+1]=nums2[i];
            //k=count+1;
           // j=count+1;
            i++;
        }
    }
        }
*/




        // bruteforce :

/*
        int t = m+n;
        int j = t-1;

        
        for(int i = 0;i<n;i++)
        {
            if(nums1[])
            nums1[j]=nums2[i];
            j--;
        }

        Arrays.sort(nums1);

*/
        


    }
}