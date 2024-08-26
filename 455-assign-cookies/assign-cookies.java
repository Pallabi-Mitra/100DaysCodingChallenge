class Solution {
    public int findContentChildren(int[] greed, int[] cookies) {

        int m = greed.length;

        int n = cookies.length;

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int left =0;
        int right=0;

        while(left < n && right < m) // iterate till all kids
        {
            if(cookies[left]>=greed[right])
            {
                right++;
            }
            left++;

       }

       return right;
        
    }
}