// Time Complexity : O(m+n), where m is lenght of order and n is length of s.
// Space COmplexity : O(N) where N is the size of the result but because we are using StringBuilder, we will have to factor it.
class Solution {
    public String customSortString(String order, String s) {
        if ( order == null || order.length() == 0) return "";

        StringBuilder result = new StringBuilder();

        // store the occurrence of elemnts of s in a hashmap
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Start printing from order
        for (int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                while(map.get(c) > 0) {
                    result.append(c);
                    map.put(c, map.get(c)- 1);
                }
                map.remove(c);
            }
        }

        // Append remaining values
        for ( char key : map.keySet()) {
            while (map.get(key) > 0) {
                result.append(key);
                map.put(key, map.get(key) - 1);
            }
        }

        return result.toString();

    }
}
