class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int count =0;

        HashMap<Character,Integer>mpp = new HashMap<>();

        char ch[]=allowed.toCharArray();

        int n = words.length;

        for(int i=0;i<allowed.length();i++)
        {
            if(!mpp.containsKey(ch[i]))
            {
                mpp.put(ch[i],i);
            }
        }

        for(int i=0;i<n;i++)
        {
           // char input[]=words[i].toCharArray();
           // for(int j=0;j<input.length;j++)
           for(int j=0; j<words[i].length();j++)
            {
                if(!mpp.containsKey(words[i].charAt(j)))
                {
                    count++;
                    break;
                }
            }
        }

        return n-count;
        
    }
}