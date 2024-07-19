class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {


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

        /* 
        for(int i=0;i<row;i++)
        {
            if(arr[i]>maxCol)
            {
                maxCol=arr[i]; // getting max in the rows
            }
        }
            */

          
           //Arrays.sort(arrRowMin);
           Arrays.sort(arrRowMin, Collections.reverseOrder());

           Arrays.sort(arrColMax);

           if(arrRowMin[0]==arrColMax[0])
           {
            ans.add(arrRowMin[0]);
           }


           
        
        return ans;
    }
}