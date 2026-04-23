// O(n + m) time, O(1) space since only 26 chars

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int freq = map.get(c);

                for (int i = 0; i < freq; i++) {
                    ans.append(c);
                }
                map.remove(c);
            }
        }

        for (char c : map.keySet()){
            int freq = map.get(c);
            for(int i = 0; i < freq; i++){
                ans.append(c);
            }
        }

        return ans.toString();
    }
}