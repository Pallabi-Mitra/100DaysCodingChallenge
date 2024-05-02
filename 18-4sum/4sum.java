class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

//Optimal Solution : O()

int n = nums.length;
List<List<Integer>> ans = new ArrayList<>();
Arrays.sort(nums);

for(int i=0;i<n;i++)
{
    if(i>0 && nums[i]==nums[i-1])continue; // skip duplicates

    for(int j=i+1;j<n;j++)
    {
      if(j>i+1 && nums[j]==nums[j-1])continue; // skip duplicates

        int k = j+1;
        int m = n-1;

        while(k<m)
        {
                
                long sum= nums[i];
                sum+=nums[j];
                sum+=nums[k];
                sum+=nums[m];

                if(sum==target)
                {
                    /*
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]+nums[m]);
                    ans.add(temp);
                    k++;
                    m--;
                    while(k<m && nums[k]==nums[k-1])k++;
                    while(k<m && nums[m]==nums[m+1])m--;
                    */

                    List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[m]);
                        ans.add(temp);
                        k++;
                    m--;
                    while(k<m && nums[k]==nums[k-1])k++;
                    while(k<m && nums[m]==nums[m+1])m--;
                }
                else if(sum<target)
                {
                    k++;
                }
                else
                {
                    m--;
                }

        }




    }
}

    return ans;


    }
}

/*
int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }


}

*/
/*//Better Solution : O(n^3)
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
*/
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
            long sum = nums[i]+nums[j];
            sum+=nums[k];
            long find = target - sum;

            if(hashset.contains(find))
            {
                List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)find);
                temp.sort(null);
                st.add(temp);
            }
            hashset.add((long) nums[k]);
        }
    }
}


    List<List<Integer>> al = new ArrayList<>(st);
    return al;


    }
}

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