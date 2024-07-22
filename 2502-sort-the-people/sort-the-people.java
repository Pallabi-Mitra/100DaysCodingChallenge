class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        TreeMap<Integer,String> mpp = new TreeMap<Integer, String>(Collections.reverseOrder());

        int n = heights.length;

        String ans[]=new String[n];
        int k=0;

        for(int i=0;i<n;i++)
        {
            mpp.put(heights[i],names[i]);
        }

        for( String s: mpp.values())

        {
                ans[k]= s;
                k++;
        }    

        return ans;    
    }
}