class Solution {
    public void sortColors(int[] arr) {


// Deutch Flag Algorithm //
/*
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr[low];
                arr[low]= arr[mid];
                arr[mid] =  temp;

                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid]= arr[high];
                arr[high]= temp;

                high--;
            }
        }

*/
    
                int n = arr.length;
                
               int low = 0;
               int mid=0;
               int high=n-1;


               while(mid<=high)
               {
                    if(arr[mid]==0)
                    {
                           int temp=arr[mid];
                            arr[mid]=arr[low];
                            arr[low]=temp;
                            low++;
                            mid++;

                    }
                    else if(arr[mid]==1)
                    {
                        mid++;
                    }

                   else if(arr[mid]==2)
                    {
                       int temp=arr[mid];
                        arr[mid]= arr[high];
                        arr[high]=temp;
                       high--;
                    }
               }
        // Better Approach 



    }
        
    }
