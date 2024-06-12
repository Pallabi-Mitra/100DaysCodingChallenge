class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        List<String> al = new ArrayList<>();

        partition(0,s,ans,al);

        return ans;

        
    }


    public void partition(int index, String s, List<List<String>> ans,List<String> al)
    {
        // base case :

        if(index==s.length())
        {
            ans.add(new ArrayList<>(al));
            return;
        }


        // creating partitions

        for(int i = index; i< s.length();i++)
        {
            if(isPallindrome(s,index,i))
            {
                al.add(s.substring(index,i+1));

            partition(i+1,s,ans,al);
            al.remove(al.size()-1);
            }
        }


    }

    public boolean isPallindrome(String s, int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }
}