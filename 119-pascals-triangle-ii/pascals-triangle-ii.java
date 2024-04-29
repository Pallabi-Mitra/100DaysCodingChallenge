class Solution {
    public List<Integer> getRow(int rowIndex) {


        ArrayList<Integer> al = new ArrayList<>();

    int n = rowIndex + 1;
    long ans = 1;
    al.add(1);
    for(int i = 1;i<n;i++)
    {
        /*
        long next = ans*(n-i)/i;
        al.add((int)next);
        ans=next;
        */

        ans=ans*(n-i);
        ans=ans/i;
        al.add((int)ans);
    }
    return al;
    

    }
}