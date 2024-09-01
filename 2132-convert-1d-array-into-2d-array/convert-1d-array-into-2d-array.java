class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

        int[][] ans = new int[m][n];

        int s = original.length;
        int k=0;

        if(m * n == s)
        {
              
        
            for(int i=0;i<m;i++) // rows
            {
                for(int j=0;j<n;j++) // cols
                {
                    ans[i][j]= original[k];
                    k++;
                }
            }
        }
        else
        {
            return new int[0][0];
        }

        return ans;
       
        
    }
}