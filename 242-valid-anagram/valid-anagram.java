class Solution {
    public boolean isAnagram(String s, String t) {

// By sorting 
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
    //return Arrays.equals(ch1, ch2);
      
    }
}

*/

// Using HashMap :

/*

HashMap<Character,Integer> mpp = new HashMap<>();


// put the characters in 1st string along with their frequency in hashmap:

for(char c: s.toCharArray())
{
    
    mpp.put(c,mpp.getOrDefault(c,0)+1);


}

// iterate through string 2 and check if something is not present in hashmap or else reduce the count and put it

for(char ch : t.toCharArray())
{
    if(!mpp.containsKey(ch))
        return false;
    
    mpp.put(ch,mpp.get(ch)-1);
}


// looping through hashmap to check which is having value other than 0. It needs to be 0 to match completely


for(int count : mpp.values())
{
    if(count!=0)
    return false;
    
}

return true;
    }
}


*/



// Using Hash Table :


int hash[]= new int[26];

for(char c : s.toCharArray())
{
    hash[c-'a']++;
}

for(char c : t.toCharArray())
    {
        hash[c-'a']--;
    }

    for(int i = 0;i<26;i++)
    {
        if(hash[i]!=0)
        return false;
    }

    return true;
    }
}



