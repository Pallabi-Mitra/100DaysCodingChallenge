class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int i,j;

       
       
        int max = -1;

        for(i=0;i<accounts.length;i++)
        {
            int sum =0;
            for(j=0;j<accounts[0].length;j++)
            {
                sum = sum + accounts[i][j];
            }
            max = Math.max(max,sum);
        }

    return max;

    }
}