class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {


// My solution :
/*
         int row = matrix.length;
        int col = matrix[0].length;

        ArrayList<Integer> ans = new ArrayList<>();


      
        Integer arrRowMin[]= new Integer[row];

        int arrColMax[]= new int[col];

        for(int i=0;i<row;i++)
        {
            
        int minRow = Integer.MAX_VALUE;
            for(int j=0;j<col;j++) // all cols per row
            {
                  if(matrix[i][j]<minRow)
                  {
                    minRow = matrix[i][j]; // min of each row
                  }  
            }


            arrRowMin[i] = minRow;


        }


        for(int j=0;j<col;j++)
        {
            
            int maxCol = Integer.MIN_VALUE;

            for(int i=0;i<row;i++) // all cols per row
            {
                  if(matrix[i][j]>maxCol)
                  {
                    maxCol = matrix[i][j]; // min of each row
                  }  
            }


            arrColMax[j] = maxCol;


        }

           //Arrays.sort(arrRowMin);
           Arrays.sort(arrRowMin, Collections.reverseOrder());

           Arrays.sort(arrColMax);

           if(arrRowMin[0]==arrColMax[0])
           {
            ans.add(arrRowMin[0]);
           }


           
        
        return ans;
        */

        int row = matrix.length;
        int col = matrix[0].length;

        ArrayList<Integer> ans = new ArrayList<>();
        int[] rowMin = new int[row];
        int[] rowMinColIndex = new int[row];

        // Find the minimum element in each row
        for (int i = 0; i < row; i++) {
            int minRow = Integer.MAX_VALUE;
            int colIndex = -1;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                    colIndex = j;
                }
            }
            rowMin[i] = minRow;
            rowMinColIndex[i] = colIndex;
        }

        // Check if these minimum elements are the maximum in their columns
        for (int i = 0; i < row; i++) {
            int minValue = rowMin[i];
            int colIndex = rowMinColIndex[i];
            boolean isMaxInColumn = true;

            for (int k = 0; k < row; k++) {
                if (matrix[k][colIndex] > minValue) {
                    isMaxInColumn = false;
                    break;
                }
            }

            if (isMaxInColumn) {
                ans.add(minValue);
            }
        }

        return ans;
    }
}