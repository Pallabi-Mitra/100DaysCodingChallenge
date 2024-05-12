class Solution {

public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int low = 0;
        int high = cols-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int ele = mat[0][mid];
            int maxRow = 0;
            // finding max element in all rows for mid column
            for(int row = 1; row<rows; row++){
                if(mat[row][mid]>ele){
                    ele = mat[row][mid];
                    maxRow = row;
                }
            }
            if((mid==0 || ele>mat[maxRow][mid-1])
                && (mid==cols-1 || ele>mat[maxRow][mid+1])){
                    return new int[]{maxRow,mid};
            }
            else if(mid!=0 && ele<mat[maxRow][mid-1]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}



/* TLE :

    public int maxElement(int[][] mat,int n,int mid)
    {
        int maxi = -1;
        int index = -1;
        for(int i = 0;i<n;i++)
        {
            if(mat[i][mid]>maxi)
            {
                maxi=mat[i][mid];
                 index=i;
            }
           
           
        }
        return index;
    } 

    public int[] findPeakGrid(int[][] mat) {

//Optimized : Binary Search :

        int n = mat.length;
        int m = mat[0].length;
        int a[]=new int[2];
        int low = 0;
        int high = m-1;
        

        while(low<=high)
        {
            int mid = (low+high)/2;

          int row = maxElement(mat,n,mid); 
          int left = mid-1 >=0 ? mat[row][mid-1] : -1;
          int right = mid+1 <m ? mat[row][mid+1] : -1;

        if(mat[row][mid]>left && mat[row][mid]> right)
        {
            a[0]=row;
            a[1]=mid;
            //return [row,mid];
        }
        else if(mat[row][mid]<left) // decreasing curve -> go left
        {
            high=mid-1;
        }
        else
        low= mid+1;
        }

    return a;
   // return [-1,-1];

        
    }
}
*/