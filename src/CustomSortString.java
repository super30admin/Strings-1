// Iterate over s and get the frequency of all characters in it.
// Now, iterate over order string and add characters in the order as per the frequencies.
// TC: O(n) n: length of string s
// SC: O(n) 
class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            frequencyMap.put(c , frequencyMap.getOrDefault(c,0)+1);
        }

        for(int i=0;i<order.length();i++) {
            char o = order.charAt(i);
            if(frequencyMap.containsKey(o)) {
                int frequency = frequencyMap.get(o);
                for(int j=0;j<frequency;j++) {
                    result.append(o);
                    frequencyMap.put(o,frequencyMap.get(o)-1);
                }
                if(frequencyMap.get(o) == 0) {
                    frequencyMap.remove(o);
                }
            }
        }

        for(Map.Entry<Character,Integer> entry: frequencyMap.entrySet()) {
            int count = entry.getValue();
            for(int j=0;j<count;j++)
                result.append(entry.getKey());
        }
        return result.toString();
    }
}