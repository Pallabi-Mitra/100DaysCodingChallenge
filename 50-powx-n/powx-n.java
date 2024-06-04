class Solution {
    public double myPow(double x, int n) {


// Optimal Approach :

double ans = 1.0;

long num = n; // copying the power

if( num < 0) // given num is negative
{
    num = -1 * num; // convert -ve no to positive
}

    while(num > 0) // power not becoming 0, till 1
    {
        if(num%2==1)// odd power 
        {
            ans = ans * x; // multiplying 1 no
            num = num -1 ; // power becomes even
        }
        else // even power
        {
            x = x*x; // no gets multiplied by itself

            num = num/2; // power gets divided by half
        }
    }

    if(n<0) // if -ve power:

    {
        ans = (double)(1.0)/(double)(ans);
    }
        return ans;
    
    }

}

//Iteration : TLE :
/*

        double ans = 1 ;
        int count = n;

        //ans = Math.pow(x,n);
        
        while(count>0) // positive power
        {

                ans = ans * x;
                count--; 
        }
        while(count<0)// negative power
        {
            ans = ans * 1/x;
            count++;

        }
        return ans;
        
    }
}

*/

