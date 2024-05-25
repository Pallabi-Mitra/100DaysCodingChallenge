class Solution {
    public int firstUniqChar(String s) {

        int hash[]=new int[26];

        for(char c : s.toCharArray())
        {
            hash[c-'a']++;
        }
        char [] ch = s.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
            int index = ch[i]-'a';

            if(hash[index]==1)
            {
                return i;
            }
        }
        
        return -1;
        
    }
}
