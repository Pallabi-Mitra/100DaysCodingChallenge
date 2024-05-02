class Solution {
    public int maxProduct(int[] nums) {

//optimized :


        int n = nums.length;

        int prefix=1;
        int suffix=1;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
           if(prefix==0)
           {
            prefix=1;
           }

           if(suffix==0)
           {
            suffix=1;
           }

           prefix=prefix*nums[i];
           suffix=suffix*nums[n-i-1];
           maxi= Math.max(maxi,Math.max(prefix,suffix));
        }

        return maxi;

    }
}






//bruteforce :
/*
        int n = nums.length;
        int product;
        int maxi=Integer.MIN_VALUE;

        for(int i = 0;i<n;i++)
        {
            product = 1;

            for(int j = i;j<n;j++)
            {
                    product = product * nums[j];

                    maxi = Math.max(maxi,product);
            }
        }

        return maxi;
        
    }
}
*/