class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}
//Better Solution : O(n^3)

/*
int n = nums.length;

Set<List<Integer>> st = new HashSet<>();

for(int i = 0;i<n;i++)
{
    for(int j=i+1;j<n;j++)
    {
        Set<Long> hashset = new HashSet<>();
        for(int k=j+1;k<n;k++)
        {
            Long sum = nums[i]+nums[j];
            sum+=nums[k];
            Long find = target - sum;

            if(hashset.contains(find))
            {
                List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)find);
                temp.sort(null);
                st.add(temp);
            }
            hashset.add(nums[k]);
        }
    }
}


    List<List<Integer>> al = new ArrayList<>(st);
    return al;

*/





        //Brute force : T.C :O(n^4), S.C : 0(1)
/*
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
       
       for(int i = 0;i<n;i++)
       {
        for(int j=i+1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                for(int p=k+1;p<n;p++)
                {
                    int sum= nums[i]+nums[j]+nums[k]+nums[p];

                    if(sum==target)
                    {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[p]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
       }

       List<List<Integer>> al = new ArrayList<>(st);
       return al;
        
    }
}
*/