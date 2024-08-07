class Solution {
    public String kthDistinct(String[] arr, int k) {


        //creating hashmap to count the frequency of string

        HashMap<String,Integer> mpp = new HashMap<>();

        for(String s : arr)
        {
            mpp.put(s, mpp.getOrDefault(s,0)+1);
        }

        int distinctCount = 0;

        for(String s : arr)
        {
            if(mpp.get(s)==1) // value is 1 means distinct
            {
                distinctCount++;
            }

            if(distinctCount==k)
            {
                return s;
            }
        }

        return "";






        /* 
        //not working

        HashMap<String,Integer> mpp = new HashMap<>();
        int j=1;
        String ans="";
       
       for(int i=0;i<arr.length;i++)
       {
                if(!mpp.containsKey(arr[i]))
                {
                         mpp.put(arr[i],j);
                         j++;
                }
                else
                {
                    mpp.remove(arr[i]);
                    j--;
                }
               
                
       }

       for(Map.Entry<String,Integer> entry :mpp.entrySet())
       {

        String key = entry.getKey();
        Integer value = entry.getValue();


            if(k==value)
            {
                 ans = key;
            }
           
       }

        
        return ans;


        */

    }
}
  