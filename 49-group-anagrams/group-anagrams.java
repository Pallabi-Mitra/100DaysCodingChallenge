class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {




/*
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



*/

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // MUCH simpler key creation
            String key = Arrays.toString(count);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
   