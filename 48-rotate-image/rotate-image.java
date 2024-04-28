class Solution {
    public void rotate(int[][] matrix) {


        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][]=new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[j][n-1-i]=matrix[i][j];
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               matrix[i][j]=ans[i][j];
            }
        }


        
    }
}
       /*
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        } 
        
    }
}
*/