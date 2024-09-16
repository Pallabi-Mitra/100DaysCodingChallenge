class Solution {
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans[]=new int[2];

     for(int i = 0;i< numbers.length;i++)
        {
            int current = numbers[i];
            int complement = target - current;
            if(mpp.containsKey(complement))
            {
                
                ans[0]= mpp.get(complement);
                ans[1]=i+1;
                break;
            }

            mpp.put(current,i+1);
        }

        return ans;
        
    }
}