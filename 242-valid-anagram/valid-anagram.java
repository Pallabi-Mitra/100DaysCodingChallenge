class Solution {
    public boolean isAnagram(String s, String t) {

// By sorting 

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