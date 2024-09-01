class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

// Check if it's possible to form a 2D array with m * n elements
    if (original.length != m * n) {
        // Return an empty 2D array if not possible
        return new int[0][0];
    }
    
    // Create the 2D array with m rows and n columns
    int[][] result = new int[m][n];
    
    // Fill the 2D array with elements from the original array
    for (int i = 0; i < original.length; i++) {
        // Determine the row and column index
        int row = i / n;
        int col = i % n;
        
        // Assign the value from the original array to the 2D array
        result[row][col] = original[i];
    }
    
    // Return the constructed 2D array
    return result;
    }
}

/*
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

*/