class Solution {
    public int countPrimes(int n) {

        // Seive of Eratosthenes

// Step 1: Marking the array positions with 1
        int arr[]=new int[n];
        for(int i=2;i<n;i++)
        {
            arr[i]=1;
        }

// Step 2 : creating black box to give the prime no in o(1): pre-compute

        for(int i = 2;i * i<n ;i++) // goes till sqrt of n
        {
            if(arr[i]==1) // its prime no
            {
                // mark all its multiples as 0 since it cant be prime

                for(int j = i * i; j<n ; j+=i)
                {
                    arr[j]=0;
                }
            }
        }


        
    


    // Print the prime nos - marked as 1 in the array

   int count = 0;
    for(int i = 2;i<n;i++)
    {
         
        if(arr[i]==1)
        {
            count++;
        }
    }
    return count;
    }
}