class Solution {
    public List<List<Integer>> threeSum(int[] nums) {


//Better Solution : Hashing : O(n^2):




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