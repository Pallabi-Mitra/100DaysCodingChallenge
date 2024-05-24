class Solution {
    public boolean isSubsequence(String sub, String s1) {

    if (sub.length()<1)
            return true;
        char[] subb=sub.toCharArray();
        char[] s11=s1.toCharArray();
        for (int i=0, j=0;i<s11.length;i++)
        {
            if(s11[i]==subb[j])
                j++;

            if (j==subb.length)
                return true;
        }
        return false;

    }
}





// Iterative Solution :
/*

        int j = 0;

        for(int i = 0;i<s1.length() && j<sub.length();i++)
        {
            if(s1.charAt(i)==sub.charAt(j))
            {
               
                j++;
            }

        }
        if(j==sub.length())
        return true;
        else
        return false;

        
    }
}

*/