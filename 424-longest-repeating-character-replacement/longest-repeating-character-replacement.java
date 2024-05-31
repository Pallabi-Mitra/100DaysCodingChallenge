class Solution {
    public int characterReplacement(String s, int k) {

// Bruteforce : 


    int n = s.length();
    int maxlen = 0;
    int changes=0;
    int maxFreq  = 0;




    for(int i = 0;i<n;i++)
    {
        int hash[]=new int[26]; // only english upper case letters
        for(int j = i;j<n;j++)
        {
            hash[s.charAt(j)-'A']++;
        

        maxFreq = Math.max(maxFreq,hash[s.charAt(j)-'A']);
        changes = (j-i+1) - maxFreq;

        if(changes <=k)
        {
            maxlen = Math.max(maxlen,j-i+1);
        }
        else
        break;
        }
    }

      return maxlen;  
    }
}