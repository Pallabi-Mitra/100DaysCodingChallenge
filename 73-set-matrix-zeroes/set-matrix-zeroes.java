class Solution {
    
    public void setZeroes(int[][] matrix) {


//Optimal Solution : optimize the space. take the first row, first col.

//int col[m] = {0}; -> matrix[0][..] // first row taken
//int row[n]={0}; -> matrix[..][0] // first col taken
int col0=1;
 int n = matrix.length;
    int m  = matrix[0].length;

for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                    if(matrix[i][j]==0)
                    {
                        // mark the i-th row : 
                        matrix[i][0]=0;

                        //mark the jth col
                        if(j!=0)
                        matrix[0][j]=0;
                        else
                        col0=0;
                      

                    }
            }    
        }


        for(int i =1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]!=0)
                {
                    //check for col & row:
                    if(matrix[0][j]==0 || matrix[i][0]==0)
                    {
                        matrix[i][j]=0;
                    }
                }
            }
        }


    if(matrix[0][0]==0)
    {
        for(int j=0;j<m;j++)
        {
            matrix[0][j]=0;
        }

    }
    if(col0==0)
    {
        for(int i=0;i<n;i++)
        {
            matrix[i][0]=0;
        }
    }




// Better Solution : TC :O(2*n*m), SC: O(n) + O(m)

/*
    
    int i,j;
   
    int n = matrix.length;
    int m  = matrix[0].length;

    int row[]= new int[n];
    int col[]=new int[m];




 for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                    if(matrix[i][j]==0)
                    {
                       
                       row[i]=1;
                       col[j]=1;

                    }
            }
        }



         for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j]=0;
                }
            }
        }

/* not needed :
        for(i=0;i<n;i++)
        {
            j=0;
            if(row[i]==1)
            {
                while(j<m)
                {
                matrix[i][j]=0;
                j++;
                }
                
            }
        }


     for(j=0;j<n;j++)
        {
            i=0;
            if(col[j]==1)
            {
                while(i<n)
                {
                matrix[i][j]=0;
                i++;
                }
                
            }
        }

*/





    }



/*
        // Bruteforce : O(n*m)*O(n+m)+O(n*m) ~~ n^3

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


*/
       
        
    
}