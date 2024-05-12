class Solution {
   
// Optimized : Binary Search :

public boolean binarySearch(int []matrix, int target)
{
            int low = 0;
            int high = matrix.length;

            while(low<=high)
            {
                int mid = (low+high)/2;

                if(matrix[mid]==target)
                {
                    return true;
                }
                else if(matrix[mid]<target)
                {
                    low=mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            return false;
            
}
 public boolean searchMatrix(int[][] matrix, int target) {

    int n = matrix.length;
    int m = matrix[0].length;

    for(int i = 0;i<n;i++)
    {
        if(matrix[i][0] <= target && matrix[i][m-1] >= target)
        {
            // start binary search :
            /*
            int low = 0;
            int high = m-1;

            while(low<=high)
            {
                int mid = (low+high)/2;

                if(matrix[i][mid]==target)
                {
                    return true;
                }
                else if(matrix[i][mid]<target)
                {
                    low=mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            */
            return binarySearch(matrix[i],target);
        }
        
    }

    return false;






/* Bruteforce :

    for(int i  =0 ; i<n;i++)
    {
        for(int j = 0;j<m;j++)
        {
            if(matrix[i][j]==target)
            {
                return true;
            }
        }
    }
    return false;
   */     
    }
}