class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
// Optimal :

int n1 = nums1.length;
int n2 = nums2.length;
int left = (n1+n2+1)/2; // no of elements in left partition

if(n1>n2)
    return findMedianSortedArrays(nums2,nums1); // swaps array, I need smaller array at first

int low= 0; int high = n1; // size of smaller array1
int n = n1+n2;
while(low<=high)
{
    int mid1 = (low+high)/2;
    int mid2= left-mid1; 
    // incase the values are not there :
    int l1 = Integer.MIN_VALUE;
    int l2 = Integer.MIN_VALUE;
    int r1 = Integer.MAX_VALUE;
    int r2 = Integer.MAX_VALUE;
    //assigning values :

    if(mid1 < n1 ) r1 = nums1[mid1]; // 1st array smallest
    if(mid2 < n2)  r2 = nums2[mid2]; // 2nd array smallest

    if(mid1-1>=0) l1= nums1[mid1-1]; // 1st array largest element
    if(mid2-1>=0) l2 = nums2[mid2-1]; // 2nd array largest element

    if(l1<=r2 && l2 <= r1) // Valid Symmetry - Possible
    {
        if(n%2==1) return Math.max(l1,l2);
        return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
    }
    else if(l1> r2)
    {
        high = mid1-1;// take lesser elements to make left smaller , eliminate right
    }
    else
    {
        low=mid1+1; // take more elements to reduce right value, so eliminate left space
    }


}
return 0;

    }
}










// Better Approach : without extra space
/*

int n = nums1.length;
int m = nums2.length;

int i = 0;
int j = 0;

int total = n+m;

int index2 = total/2; // for odd median
int index1= index2-1;
int cnt = 0;

int index1_element = -1;
int index2_element = -1;

while(i< n && j<m)
{
    if(nums1[i]<nums2[j])//whichever is less we take
    {
        if(cnt==index1) index1_element  = nums1[i]; // if counter is same we store the element
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

if(total%2==1) // if odd this array elemet is median
return index2_element;
else // if even
// just add and divide the array elements by 2. to get the median 
return (double)((double)(index1_element + index2_element))/2.0;







    }
}

*/
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