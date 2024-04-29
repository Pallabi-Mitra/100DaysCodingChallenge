class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

// Optimal : T.C : O(n*m), SC : O(n*m)


        int n = matrix.length;
        int m = matrix[0].length;
        int i,j;
       ArrayList<Integer> al = new ArrayList<>();


        int top=0;
        int bottom = n-1;
        int left=0;
        int right=m-1;

    while(left<=right && top<=bottom)
    {
                    for(i=left;i<=right;i++)
                    {
                        al.add(matrix[top][i]);
                    }
                        top++;
// incase of 1 row only, : top if not less than botton not work
                for(i=top;i<=bottom;i++)
                {
                    al.add(matrix[i][right]);
                }
                right--;

         if(top<=bottom) // if new row is not present what to print
         {
                for(i=right;i>=left;i--)
                {
                    al.add(matrix[bottom][i]);
                }

                bottom--;
         }       

                
        if(left<=right) //inside spiral without top
        {

        
                for(i=bottom;i>=top;i--)
                {
                    al.add(matrix[i][left]);
                }
                left++;

                
        }
    }
    return al;








//Bruteforce : 
/*
        int n = matrix.length;
        int m = matrix[0].length;
        int i,j;
       // ans[][]=new int[n][m];
       ArrayList<Integer> al = new ArrayList<>();

        if(n==1)
        {
            for(j=0;j<m;j++)
            {
                     al.add(matrix[0][j]);
            }
               
                return al;
                
        }
         else if(m==1)
        {
            for(i=0;i<n;i++)
            {
                     al.add(matrix[i][0]);
            }
               
                return al;
        }
        else
        {

                for(j=0;j<m;j++)
                {
                al.add(matrix[0][j]);

                }

                for(i=1;i<n;i++)
                {
                    al.add(matrix[i][m-1]);
                }

                for(j=m-2;j>0;j--)
                {
                    al.add(matrix[n-1][j]);
                }

                for(i=n-1;i>0;i--)
                {
                    al.add(matrix[i][0]);
                }

                
        }

        if(n>2)
        {
            for(j=1;j<m-1;j++)
                {
                    al.add(matrix[1][j]);
                }
        }

return al;

*/
/*
 List<Integer> ans = new ArrayList<>();
        
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns
        
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
*/
        
    }
}