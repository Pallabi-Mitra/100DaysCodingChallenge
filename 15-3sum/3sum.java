class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

//2-pointer approach :


    List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;













//Better Solution : Hashing : O(n^2):
// using extra data structure to filter out the duplicates 
/*


Set<List<Integer>> ans = new HashSet<>();

int n = nums.length;

for(int i =0;i<n;i++)
{
    HashSet<Integer> st = new HashSet<>();
    for(int j = i+1;j<n;j++)
    {
        int find = -(nums[i]+nums[j]);

        if(st.contains(find))
        {
            List<Integer> temp = Arrays.asList(nums[i],nums[j],find);
            temp.sort(null);
            ans.add(temp);
        }

        st.add(nums[j]);
    }
}

List<List<Integer>> al = new ArrayList<>(ans);
    return al;

*/

/*

HashMap<Integer,Integer> mpp = new HashMap<>();
//List<Integer> ans = new ArrayList<>();
List<List<Integer>> ans = new ArrayList<>();

Set<List<Integer>> st = new HashSet<>();

int i,j;
int n= nums.length;

for(i=0;i<n;i++)
{
    mpp.put(nums[i],i);
}

    for(i=0;i<n;i++)
    {
        int rem=0;
        int sum=0;
        for(j=i+1;j<n;j++)
        {
                sum=nums[i]+nums[j];
                rem= 0-sum;
                if(mpp.containsKey(rem) && mpp.get(rem)!=i && mpp.get(rem)!=j)
                {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], rem); 
                    Collections.sort(temp);
                    st.add(temp);
                }
        }
    }

    List<List<Integer>> al = new ArrayList<>(st);
        
        return al;

*/


        //Bruteforce : T.C :  O(n^3), SC : using set DS
        /*
        int i,j=0,k=0;

        int n = nums.length;
       // ArrayList<Integer> al= new ArrayList<>();
       // List<Integer> temp = new ArrayList<>();
        //HashSet<Integer> st = new HashSet<>();
        Set<List<Integer>> st = new HashSet<>();

        
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                for(k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        
                       //List<Integer> temp = new ArrayList<>();
                       
                      // temp.add(nums[i]);
                      // temp.add(nums[j]);
                        // temp.add(nums[k]);
                        
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                       // temp.sort(null);
                       Collections.sort(temp); 
                        st.add(temp);
  
                    }
                  
                }
               
            }
        }

List<List<Integer>> al = new ArrayList<>(st);
        
        return al;
        */
    }
}