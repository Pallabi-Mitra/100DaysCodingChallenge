class Solution {
    public int singleNumber(int[] arr) {


int n = arr.length;
HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        //Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        
        return -1;

    }
}
// Not work for -ve nos:
/*
int n = arr.length;

        // Find the maximum element:
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // Declare hash array of size maxi+1
        // And hash the given array:
        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        //Find the single element and return the answer:
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }
}
// Hashing :
/*

int maxi=0;
int i;

for(i = 0;i<nums.length;i++)
{
    if(nums[i]>maxi)
        maxi=nums[i];
}

int hash[]= new int[maxi+1];

//int hash[maxi]={0};

for(i=0;i<nums.length;i++)
{
    hash[nums[i]]++;
}

for(i=0;i<nums.length;i++)
{
    if(hash[nums[i]]==1)
    {
        return nums[i];
    }
}

return -1;

*/
/*
// Brute-Force : TC : O(N), SC : O(N)

int i;
int n = nums.length;
int hash[]= new int[n+1];
//int c=1;
    for(i=0;i<nums.length;i++)
    {
            hash[nums[i]]++;
    }

    for(i=0;i<=n;i++)
    {
        if(hash[i]==1)
            return i;
    }


   /* for (i = 0; i < n; i++) {
            if (hash[nums[i]] == 1)
                return nums[i];
        }
        return -1;
*/
