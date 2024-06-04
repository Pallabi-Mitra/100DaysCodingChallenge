class Solution {
    public int longestPalindrome(String s) {



// Most optimal :

// Intuition : 

// even no :  take all the counts
// odd no : whatever even no till we can get we will add.
// for other remaining each count 1 of odd char we can take only 1 to make valid pallindrome
// so odd = 1 set static

int count[]=new int[58];
// ch -'A' // if lower case : 97-65 = 32 --- 58
// ch - 'A' // if upper case : 65-65= 0 -----26
int res = 0;
int odd = 0;

for(char ch : s.toCharArray())
{
    count[ch-'A']++;
}

for(int n : count)
{
    if(n%2==0 && n!=0) // even and no empty spots
    {
        res +=n;
    }
    else if(n%2==1) // odd numbers greater than 1
    {
        res+=n-1; // take the even pair out , eg : 5 -> 5-1 = 4 chars can be taken
        odd =1; // no of odd will be 1 no matter how many present
    }
    
}


return res + odd;
    }
}















// 9ms : 

/*
        HashMap<Character,Integer> mpp = new HashMap<>();
        int count = 0;
       // boolean odd_flag = false;
        int i = 0;


       // for(ch : s.toCharArray())
       for(;i<s.length();i++)
        {
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }

        if(mpp.size()==1)
        {
            count = mpp.get(s.charAt(i-1));
            return count;
        }

       // for(int n : mpp.values())

       for(Map.Entry<Character,Integer> entry : mpp.entrySet())
        {
            if(entry.getValue()%2==0)
            {
                count+=entry.getValue();
                //mpp.remove(entry.getKey());
                mpp.put(entry.getKey(),entry.getValue()%2);
            }
            else
            {
               
                count+=entry.getValue()-1;
 
                mpp.put(entry.getKey(),entry.getValue()%2);
            }
            
        }

        // just for 1 value :
        for(int n : mpp.values())
        {
            if(n==1)
            {
                count++;
                break;
            }
        }
       
               
        
        

        return count;
    }
}

*/

// 9ms : Lambda Expression :
/*
HashMap<Character,Integer> mpp = new HashMap<>();
int count = 0;
int i = 0;



for(;i<s.length();i++)
{
    mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
}

if(mpp.size()==1)
{
    count = mpp.get(s.charAt(i-1));
    return count;
}


// Iterator 
/*
Iterator<Map.Entry<Character,Integer>> index = mpp.entrySet().iterator();
while (index.hasNext()) {
    Map.Entry<Character,Integer> entry = index.next();
    if(entry.getValue()%2==0){
        count+=entry.getValue();
        index.remove();
    }

 

 // Lambda Expression - java 8 :

 //mpp.entrySet().removeIf(entry.getValue()%2==0);
        //count+=entry.getValue();


    else
    {
       
       
        count+=entry.getValue()-1;
  
        mpp.put(entry.getKey(),entry.getValue()%2);
    }
    
}

// just for 1 value :
if(mpp.size()>0)
{
    
        count++;
     
}

return count;
    }
}
*/



