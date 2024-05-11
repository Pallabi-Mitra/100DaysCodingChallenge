class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

// bruteforce :

int n = nums1.length;
int m =nums2.length;
int ans[]= new int[n+m];

    int i = 0; int j =0; int k = 0;

    while(i<n && j<m)
    {
        if(nums1[i]<nums2[j])
        {
            ans[k]=nums1[i];
            i++;
            k++;
        }
        else
        {
            ans[k]=nums2[j];
            j++;
            k++;
        }
    }
    while(i<n)
    {
        ans[k]=nums1[i];
        k++;
        i++;

    }
    while(j<m)
    {
        ans[k]=nums2[j];
        k++;
        j++;
    }

   // int index = n + m;
    int total = ans.length;
   // double res =0;

    if(total %2!=0)
    {
        //res = ans[(int)total/2];
        return ans[total/2];
    }
    return ((double) ans[total / 2] + (double) ans[(total / 2)-1]) / 2.0;

    }
}