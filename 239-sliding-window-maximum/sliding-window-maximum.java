class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;

        int res[]=new int[n-k+1];

        int resultIndex=0; 

        Deque<Integer> q = new ArrayDeque<>();

        for(int i =0;i<n;i++)
        {
                // remove numbers out of range K

                if(!q.isEmpty() && q.peek()==i-k){ 
                    // out of index elements are removed from front
                    q.poll(); // remove from deque
                }

                // remove smaller numbers in K range as they are useless

                while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]) // front element of deque
                {
                    q.pollLast(); // remove smaller from back
                }

                q.offer(i); // after removeing we add that to queue
                    if(i>=k-1) // when i reaches the subarray last element we compute the max
                    {
                        res[resultIndex] = arr[q.peek()]; 
                        //front element of deque will be max so we add it to res array
                        resultIndex++;
                    }

        }

        return res;
    }
}


















/*Bruteforce
         int left = 0, right = 0;
        int i, j;
        ArrayList < Integer > maxx = new ArrayList < > ();
        while (right < k - 1) {
            right++;
        }
        while (right < arr.length) {
            GetMax(arr, left, right, maxx);
            left++;
            right++;
        }
        
    int res[]=new int[maxx.size()];

    for(i =0;i<maxx.size();i++)
    {
        res[i]=maxx.get(i);
    }

    return res;
        

    }

public static void GetMax(int arr[], int l, int r, ArrayList < Integer > maxx) {
        int i, maxi = Integer.MIN_VALUE;
        for (i = l; i <= r; i++)
            maxi = Math.max(maxi, arr[i]);
        maxx.add(maxi);
    }
}


*/





// Bruteforce : O(n2)
/*
    int n = nums.length;
   // int maxi = Integer.MIN_VALUE;
    ArrayList<Integer> al = new ArrayList<>();

    for(int i  =0;i<=n-k;i++)
    {
        int cnt = k;
        int j=i;
        int maxi = Integer.MIN_VALUE;
       while(cnt>0 && j<n)
        {
            cnt--;
            
           maxi=Math.max(maxi,nums[j]);
           
            j++;
            
        }
        al.add(maxi);
    }

    int res[]=new int[al.size()];

    for(int i =0;i<al.size();i++)
    {
        res[i]=al.get(i);
    }

    return res;
        
    }
}
*/