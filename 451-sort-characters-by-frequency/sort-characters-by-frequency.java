class Solution {
    public String frequencySort(String s) {
/*

        HashMap<Character,Integer> mpp = new HashMap<>();

        for(char c : s.toCharArray())
        {
            int freq=0;
            if(mpp.containsKey(c))
            {
                freq = mpp.get(c);
                freq++;
            }
            mpp.put(c,freq);

        }

        for(char c : s.toCharArray)
    {
        if(mpp.get(c))
    }
        
        }
}
*/
// Step 1: Create a HashMap to store character frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Step 2: Count frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 3: Sort the entries based on frequency
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());
        
        // Step 4: Construct the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}