class Solution {


    private void dfs(int row,int col,int[][]ans,int[][]image,int newColor, int delRow[], int delCol[], int iniColor)
    {
        ans[row][col] = newColor; // mark the cell to new color

        int n = image.length;
        int m = image[0].length;

        for(int i=0; i<4;i++) // getting the adjacent coordinates
        {
            int nrow= row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] !=newColor)
            {
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,iniColor);
            }
        }
    }










    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int iniColor = image[sr][sc]; // the starting color

        int[][] ans = image; // copy of given data

        int delRow[] = {-1, 0, +1 , 0};
        int delCol[]= { 0, +1, 0, -1};

        // calling dfs 

        dfs(sr,sc,ans, image, newColor, delRow,delCol,iniColor);

        return ans;

        
    }
}