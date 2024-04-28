class Solution {
    
    public void setZeroes(int[][] matrix) {

        // Bruteforce :

        int i,j;
       int row=0,col=0;
        int k  =0;
        

        int totalRows=matrix.length;
        int totalColumns = matrix[0].length;
        

        for(i=0;i<totalRows;i++)
        {
            for(j=0;j<totalColumns;j++)
            {
                    if(matrix[i][j]==0)
                    {
                       markRow(i,matrix,totalColumns);
                       markCol(j,matrix,totalRows);

                    }
            }
        }

        
        for(i=0;i<totalRows;i++)
        {
            
            for(j=0;j<totalColumns;j++)
            {
                if(matrix[i][j]==-1000)
                {
                        matrix[i][j]=0;
                }
                     
            }
               
            
        }
    }
        public void markRow(int i,int[][] matrix,int totalColumns )
        {
            for(int j=0;j<totalColumns;j++)
            {
                if(matrix[i][j]!=0)
                {
                    matrix[i][j]=-1000;
                }
            }
        }



        public void markCol(int j,int[][] matrix,int totalRows)
        {

            
            for(int i=0;i<totalRows;i++)
            {
                if(matrix[i][j]!=0)
                {
                    matrix[i][j]=-1000;
                }
            }
        }



       
        
    
}