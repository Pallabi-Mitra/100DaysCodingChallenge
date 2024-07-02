class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {


        ArrayList<Integer> al = new ArrayList<>();

        int k =0;
       

        for(int i = 0;i<nums1.length;i++)
        {
            for(int j =0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j] && nums2[j]!=-1)
                {
                    al.add(nums1[i]);
                    nums2[j]=-1;
                    break;
                }
            }
        }
 int res[]=new int[al.size()];
        for(int num : al)
        {
            res[k]=num;
            k++;
        }
        return res;
        
    }
}