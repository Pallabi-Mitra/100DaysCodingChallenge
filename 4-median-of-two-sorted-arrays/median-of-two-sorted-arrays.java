class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
// Better Approach :


int n = nums1.length;
int m = nums2.length;

int i = 0;
int j = 0;

int total = n+m;

int index2 = total/2;
int index1= index2-1;
int cnt = 0;

int index1_element = -1;
int index2_element = -1;

while(i< n && j<m)
{
    if(nums1[i]<nums2[j])
    {
        if(cnt==index1) index1_element  = nums1[i];
        if(cnt==index2) index2_element = nums1[i];
        cnt++;
        i++;
    }
    else
    {
        
        if(cnt==index1) index1_element  = nums2[j];
        if(cnt==index2) index2_element = nums2[j];
        cnt++;
        j++;

    }
}

while(i<n)
{
    if(cnt==index1) index1_element  = nums1[i];
        if(cnt==index2) index2_element = nums1[i];
        cnt++;
        i++;
}
while(j<m)
{
    if(cnt==index1) index1_element  = nums2[j];
        if(cnt==index2) index2_element = nums2[j];
        cnt++;
        j++;

}

if(total%2==1)
return index2_element;
else

return (double)((double)(index1_element + index2_element))/2.0;







    }
}


// bruteforce :
/*
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

   // int total = n + m;
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
*/