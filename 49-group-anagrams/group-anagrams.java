class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        // Using Hashmap : sorting the strings and storing as key value

        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char ch[]= s.toCharArray();
            //sort the characters 

            Arrays.sort(ch);

            // converting the character array to string

            String key = new String(ch);

// putting in the hashmap :

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(s);

            


        }

        return new ArrayList<>(map.values());




    }
}