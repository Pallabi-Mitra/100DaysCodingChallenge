class Solution {
    public int trap(int[] arr) {


        int res=0;
        int n = arr.length;

        for(int i =1;i<n-1;i++)
        {
            int lmax = arr[i];

            for(int j =0;j<i;j++)
            {
                lmax = Math.max(lmax,arr[j]);
            }

            int rmax = arr[i];

            for(int j = i+1;j<n;j++)
            {
                rmax = Math.max(rmax,arr[j]);
            }

            res = res + (Math.min(lmax,rmax)- arr[i]);
        }

        return res;

        
        
    }
}