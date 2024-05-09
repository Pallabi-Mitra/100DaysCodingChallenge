class Solution {
    public void rotate(int[][] matrix) {

// Optimal : in place:
//Find transpose -> reverse it

//Transpose : O(n/2 * n/2)

int n = matrix.length;
int i,j;
//for(i=0;i<n-2;i++)
for(i=0;i<n;i++)
{
   // for(j=i+1;j<n-1;j++)
    for(j=i+1;j<n;j++)
    {
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
}

//Reverse : O(n * n/2)

for(i=0;i<n;i++)
{
    for(j=0;j<n/2;j++)
    {
        int temp = matrix[i][j];
        matrix[i][j]=matrix[i][n-1-j];
        matrix[i][n-1-j]=temp;
    }
}

    }
}

// Extra space : 
/*

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
  */    