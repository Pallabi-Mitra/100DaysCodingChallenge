class Solution {
    public int[] twoSum(int[] numbers, int target) {

        //using two pointers : for constant space constraint and sorted array space utility

        int left = 0;
        int right = numbers.length-1;

        while(left < right)
        {
            int sum = numbers[left]+numbers[right];
            if(sum==target)
            {
                return new int[]{left+1,right+1};
            }
            else if(sum < target)
            {
                    left++;
            }
            else
            {
                 right--;
            }
        }
 return new int[] {-1, -1};
//Your solution must use only constant extra space.: cant use hashmap. 

/*
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

        */

        
    }
}