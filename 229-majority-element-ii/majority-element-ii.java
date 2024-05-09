class Solution {
    public List<Integer> majorityElement(int[] v) {


// Optimal Solution : Moore's Voting Algorithm_ for 2 elements : O(2N), O(1)
/*

int n =v.length;
int ele1=Integer.MIN_VALUE;
int ele2=Integer.MIN_VALUE;
int count1=0,count2=0;

for(int i = 0;i<n;i++)
{
    if(count1==0 && ele2!=v[i])
    {
        count1=1;
        ele1=v[i];
    }
    else if(count2==0 && ele1!=v[i])
    {
        count2=1;
        ele2=v[i];
    }
    else if(ele1==v[i])
    {
        count1++;
    }
    else if(ele2==v[i])
    {
        count2++;
    }
    else
    {
        count1--;
        count2--;
    }

}

ArrayList<Integer> al = new ArrayList<>();

count1=0;
count2=0;
int mini = (int)(n/3)+1;

for(int i=0;i<n;i++)
{
    if(ele1==v[i])
    {
        count1++;
    }
    if(ele2==v[i])
    {
        count2++;
    }

}

if(count1>=mini)
{
    al.add(ele1);
}
if(count2>=mini)
{
    al.add(ele2);
}

return al;
    }
}

*/

//Hashing 2 iteration :: T.C : O(n), SC : O(N)
/*
ArrayList<Integer> al = new ArrayList<>();

HashMap<Integer,Integer> mpp = new HashMap<>();

int n = v.length;

for(int i=0;i<n;i++)
  {
    int freq=1;
    if(mpp.containsKey(v[i]))
    {
        int rem=mpp.get(v[i]);
        rem++;
        mpp.put(v[i],rem);
      
    }
    else
    {
        mpp.put(v[i],freq);
    }
  }

  for(Map.Entry<Integer,Integer> it : mpp.entrySet())
  {
    if(it.getValue()>n/3)
    {
        al.add(it.getKey());
    }
  }
  return al;
  }
  }

*/


//Hashing 1 iteration :

/*
ArrayList<Integer> al = new ArrayList<>();

HashMap<Integer,Integer> mpp = new HashMap<>();

int n = v.length;
int mini = (int)(n / 3) + 1;

for(int i=0;i<n;i++)
{
    int freq=0;
    int key = v[i];

    if(mpp.containsKey(key))
    {
        freq=mpp.get(key);
        mpp.put(key,freq);
    }

    freq++;
    
    mpp.put(key,freq);

   // if(mpp.get(key)>n/3)
    
     //   al.add(key); 
   
   
   if(mpp.get(v[i])==mini) // avoids adding same element in list [2,2]
   {
    al.add(v[i]);
   }
   if(al.size()==2)
    break;

}

return al;
    }
    }

*/


//Bruteforce :O(n2)

  ArrayList<Integer> al = new ArrayList<>();
 
  int count=0;

int n = v.length; //size of the array
        List<Integer> ls = new ArrayList<>(); // list of answers

        for (int i = 0; i < n; i++) {
            //selected element is v[i]:
            // Checking if v[i] is not already
            // a part of the answer:
            if (ls.size() == 0 || ls.get(0) != v[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    // counting the frequency of v[i]
                    if (v[j] == v[i]) {
                        cnt++;
                    }
                }

                // check if frquency is greater than n/3:
                if (cnt > (n / 3))
                    ls.add(v[i]);
            }

            if (ls.size() == 2) break;
        }

        return ls;
        }
        }
    


/* my solution : memory limit exceeded : 

        ArrayList<Integer> al = new ArrayList<>();
        int n = nums.length;
        int need= n/3;
        int k=0;
        if(n==0)
        {
            return al;
        }
        else if(n==1)
        {
            al.add(nums[0]);
        }
        else if(n==2)
        {
            
          //  while(nums[k]!=nums[k+1] && k<n)
            //{
              //  al.add(nums[k]);
                // k++;
            //}
            
            while(nums[k]!=nums[k+1])
            {
            al.add(nums[0]);
            al.add(nums[1]);
            }
        }
        else
        {

                for(int i=0;i<n;i++)
                {
                    int count=1;
                    if(!al.contains(i))
                    {
                             for(int j=i+1;j<n;j++)
                    {
                        if(nums[i]==nums[j])
                        {
                            count++;
                        }
                        if(count>need)
                        {
                                al.add(nums[i]);
                                break;
                        }
                        
                    }
                    }
                   
                }

                
        }

        return al;
        }
        }
        */
   