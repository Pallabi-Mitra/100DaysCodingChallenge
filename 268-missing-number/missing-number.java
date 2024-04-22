class Solution {
    public int missingNumber(int[] nums) {


// Optimal Solution : XOR

// same ^ same : 0
// Diff ^ Diff : 1

// 0 ^ 3 = 3

int i;
int xor1=0;
int xor2=0;



for(i=0;i<nums.length;i++)
{
    xor2=xor2 ^ nums[i];
    xor1 = xor1 ^ (i+1);
}


return xor1 ^ xor2;

    }
}
// Optimal Solution : TC : O(N) // Sum of N natural nos
/*

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
*/






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