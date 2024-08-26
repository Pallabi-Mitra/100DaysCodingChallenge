class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        int m = players.length;
        int n = trainers.length;

        int left=0;
        int right =0;
        int count=0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        while(left < m && right < n)
        {
                if(players[left]<=trainers[right])
                {
                   left++;
                }
                
                right++;
        }
        return left;



        
    }
}