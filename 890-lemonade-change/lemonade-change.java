class Solution {
    public boolean lemonadeChange(int[] bills) {


// using three notes variables :

        int bill_5=0;
        int bill_10=0;
        int bill_20=0;
        int change = 0;
        boolean flag = true;

        for(int i=0;i<bills.length;i++)
        {
                int bill = bills[i];

                if(bill == 5)
                {
                    bill_5++;
                    change =0;
                }
                else if(bill == 10)
                {
                    bill_10++;
                    if(bill_5 >= 1)
                    {
                        change = 5;
                        bill_5--;
                    }
                    else
                    {
                        flag = false;
                        return flag;
                    }
                }
                else if(bill ==20)
                {
                    bill_20++;
                    if(bill_5 >= 1 && bill_10>=1)
                    {
                        change = 15;
                        bill_5--;
                        bill_10--;
                        
                    }
                    else if(bill_5 >=3 && bill_10==0)
                    {
                        change = 15;
                        bill_5 = bill_5 - 3;
                        
                    }
                    else
                    {
                        flag = false;
                        return flag;
                    }
                }
        }

        return flag;
    }
}

// using sum variable :

/*
        int sum=0;
        int change = 0;
        boolean flag = true;

        for(int i=0;i<bills.length;i++)
        {
                int bill = bills[i];

                if(bill == 5)
                {
                    sum+= bill;
                    change =0;
                }
                else if(bill == 10)
                {
                    sum+= bill;
                    if(sum >= 5)
                    {
                        change = 5;
                        sum = sum-change; // current sum updated
                    }
                    else
                    {
                        flag = false;
                        return flag;
                    }
                }
                else if(bill ==20)
                {
                    sum+=bill;
                    if(sum >=15)
                    {
                        change = 15;
                        sum = sum-change; // current sum updated
                    }
                    else
                    {
                        flag = false;
                        return flag;
                    }
                }
        }

        return flag;
        
    }
}

*/