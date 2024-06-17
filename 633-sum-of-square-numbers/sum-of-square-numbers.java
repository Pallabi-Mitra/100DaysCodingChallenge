class Solution {
    public boolean judgeSquareSum(int c) {

// Optimal : Using 2 - pointers :

/*
int left = 0;
int right = (int)Math.sqrt(c);

while(left<=right)
{
    if(left * left + right * right ==c)
    {
        return true;
    }
    else if(left * left + right * right >c)
    {
        right--;
    }
    else
    {
        left++;
    }
}

return false;
    }
}

*/

   long left = 0; // Use long to prevent overflow
    long right = (long) Math.sqrt(c); // Use long to prevent overflow
    
    while (left <= right) {
        long sum = left * left + right * right;
        if (sum == c) {
            return true; // Found a pair (a, b) such that a^2 + b^2 = c
        } else if (sum < c) {
            left++; // Increase left pointer to get a larger sum
        } else {
            right--; // Decrease right pointer to get a smaller sum
        }
    }
    
    return false; // No such pair found
    }
}



 // Better : Using Hashing : Can use HashSet 
 /* TLE : 
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i = 0;i * i<=c;i++)
        {
            int res = i * i;
            int target = c - res;

             mpp.put(res,i);

            if(mpp.containsKey(target))
            {
                return true;
            }

           
        }

        return false;
    }
}

*/



 // Bruteforce : TLE

 /*
 
        for (int i = 0;i * i<=c;i++)
        {
            for(int j = 0;j * j<=c;j++)
            {
                if(Math.pow(i,2)+Math.pow(j,2)==c)
                {
                    return true;
                }
            }
        }

        return false;
        
    }
}

*/