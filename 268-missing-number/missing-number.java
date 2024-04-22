class Solution {
    public int missingNumber(int[] nums) {

// Optimal Solution : TC : O(N)


int n = nums.length;

int sum = (n * (n+1))/2;


int i;
int s=0;

for(i=0;i<nums.length;i++)
{
        s=s+nums[i];
}

int sub = (sum-s);
return sub;


    }
}







// Brute Force : TC : O(N), SC : (N)
/*
        int n =nums.length;

        int hash[]=new int[n+1];
        int i;
        for(i=0;i<n;i++)
        {
            hash[nums[i]]=1;
        }

        for(i=0;i<=n;i++)
        {
            if(hash[i]==0)
                return i;
        }
        return -1;
    }
}

*/