class Solution {
    public int[] plusOne(int[] digits) {
for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;

// Bruteforce :
/*
         int n = digits.length;
        int no_of_digits=1;
        
        int ans=digits[n-1];

        for(int i = n-2;i>=0;i--)
        {
            int c=n-i-1;
            int res=1;
            while(c>0)
            {
                    res=res*10;
                    c--;
            }
            res= res*digits[i];
            ans=ans+res;
            no_of_digits++;
            

        }
        ans = ans+1;
        int result[]=new int[no_of_digits];
        for(int i = no_of_digits-1;i>=0;i--)
        {
                result[i]=ans%10;
                ans = ans /10;

        }
        return result;
        
     */   
    }
}