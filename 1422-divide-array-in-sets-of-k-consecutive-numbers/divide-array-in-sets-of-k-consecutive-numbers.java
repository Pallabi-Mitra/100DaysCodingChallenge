class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {




    // Edge case: if the array length is not a multiple of k, return false
        if (nums.length % k != 0) {
            return false;
        }

        // Sort the array
        Arrays.sort(nums);

        // Frequency map to count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Try to form sets of k consecutive numbers
        for (int num : nums) {
            if (countMap.get(num) == 0) {
                continue; // This number has already been used in a previous set
            }

            // Attempt to create a sequence of k consecutive numbers starting from 'num'
            for (int i = 0; i < k; i++) {
                int current = num + i;
                if (countMap.getOrDefault(current, 0) == 0) {
                    return false; // If any number in the sequence is missing, return false
                }
                countMap.put(current, countMap.get(current) - 1);
            }
        }

        return true;
    }
}


/*
        // Optimal :

// cannot take repeated elements in one set always consecutive per sets:
// in place correction



        Arrays.sort(nums);
        int n = nums.length;
        if(n%k!=0) return false; // array cannot be grouped completely, elements will remain

        

        for(int i = 0;i<n;i++) // check for all array elemnts
        {
           if(nums[i]>0) // if the no is -1 that is already taken in a set
           {
            if(!findNext(nums,k,i,n)) // if returns false cannot form set
            return false;
           
           }
        }

        return true; // if never false encountered, it is true
        
    }

    public boolean findNext(int nums[],int k,int i,int n)
    {
           
           
            int search = nums[i]+1; // consecutive no needs to be searched
            nums[i]=-1; // set the current no as -1 in array
            i+=1; // move to next
            int count = 1; // to track the group size

            while(i < n && count < k) // till group size
            {
                if(nums[i]==search) // if match found
                {
                    search = nums[i]+1; // move to next consecutive element search till group size not formed
                    nums[i]=-1; // set the current as -1
                    count++;
                }
                i++; //  check next element
            }

            if( count!=k) // if all matching consecutive elemnets counting to group size not found
            return false;
            else // group size matching consecutives found
            return true;
    }
}

*/
