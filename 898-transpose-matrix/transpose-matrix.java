
/*
class Solution {
    public int[][] transpose(int[][] matrix) {

        int n =matrix.length;
        int m = matrix[0].length;

// Swapping :
/*

        for(int i = 0;i<n;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        return matrix;
        

        // in-place :
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[j][i];
            }
        }

        return arr;
    }
}
*/
class Solution {
   public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                result[i][j] = matrix[j][i];
            }
        } 

        return result;
    }
}