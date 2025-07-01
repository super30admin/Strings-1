//maintain a HashMap and add all characters in s and their frequencies to it. Then iterate over order. And according to that, append the characters from the hashmap to a new String. Append remaining chars from Hashmap
//Time complexity: O(n)
//Space complexity: O(1)

import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                int count = map.get(order.charAt(i));
                for (int j = 0; j < count; j++) {
                    st.append(order.charAt(i));
                }
                map.remove(order.charAt(i));
            }
        }

        for (Character key : map.keySet()) {
            int count = map.get(key);
            for (int i = 0; i < count; i++) {
                st.append(key);
            }
        }

        return st.toString();
    }
}