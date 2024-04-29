class Solution {
    public List<Integer> generate_one_row(int numRows) {
        
            // nCr= n!/r! * (n-r)!

/* Find the element for R= 5, C=3:

            R-1
                C
                    C-1

            4C2 = 4!/2! * 2! = 6

            10C3 = 10*9*8/1*2*3

*/

int i,j;

ArrayList<Integer> al = new ArrayList<>();
 //List<List<Integer>> al = new ArrayList<>();

int row = 1;
int n=numRows;
al.add(1);

for(int col=1;col<n;col++)
{
        row=row*(n-col);
        row=row/col;
        al.add(row);
}

return al;

  

    }

     public List<List<Integer>> generate(int numRows) {

        //ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
           ans.add(generate_one_row(i));


        }
     
        return ans;

     }
}