class Solution {
    public int[] asteroidCollision(int[] a) {

// optimal : 

    Stack<Integer> st = new Stack<Integer>();

    int n = a.length;


for(int i = 0;i<n;i++)
{
    while(!st.isEmpty() && a[i]<0 && st.peek()>0)
    {
        int diff = a[i] + st.peek();

        if(diff<0)
            st.pop();
        else if(diff>0)
            a[i]=0;
        else
        {
                a[i]=0;
            st.pop();
        }
            
    }

    if(a[i]!=0)
    {
        st.push(a[i]);
    }



}
   int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}















//Bruteforce :
/*

        int n = a.length;
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 1;i<n;i++)
        {
            if(a[i-1]<a[i] && ((a[i]>0 && a[i-1]<0 )||(a[i]<0 && a[i-1]>0)))
            {
                al.add(a[i]);
            }
            else if(Math.abs(a[i-1])==Math.abs(a[i]) && ((a[i]>0 && a[i-1]<0 )||(a[i]<0 && a[i-1]>0)))
            {
                continue;
            }
            else
            {
                al.add(a[i-1]);
            }
        }


       int arr[]=new int[al.size()];

       for(int i = 0;i<al.size();i++)
       {
            arr[i]=al.get(i);
       }

        return arr;        
    }
}

*/