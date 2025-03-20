class Solution {
    public boolean isAnagram(String s, String t) {

// By sorting 

// TC : O(n log n) - sorting
// SC : O(n) - For arrays

/*
    char ch1[]= s.toCharArray();

    char ch2[]= t.toCharArray();

   
    


    Arrays.sort(ch1);
    Arrays.sort(ch2);

    String s1 = String.valueOf(ch1);
    String s2 = String.valueOf(ch2);
    

    if(s1.equals(s2))
    return true;
    else
    return false;




        
    }
}
*/
//Optimal appraoch :

// TC : O(n)
// SC : O(1)

int alpha[]=new int[26];

if (s.length()!=t.length())
    return false;


for(int i=0;i<s.length();i++)
{
    alpha[s.charAt(i)-'a']++;
}

for(int i=0;i<t.length();i++)
{
    alpha[t.charAt(i)-'a']--;
}

for(int i =0;i<alpha.length;i++)
{
    if(alpha[i]!=0)
    {
        return false;
    }


}

return true;
    }
}