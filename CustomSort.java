// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) as the hashmap will have at most 26 characters

import java.util.HashMap;
import java.util.Map;

class CustomSort {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0 || order == null || order.length() == 0){
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();

        // populate the string map
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // iterate through order map
        for(int i = 0; i < order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                char ch = order.charAt(i);
                int val = map.get(ch);

                while(val > 0){
                    sb.append(ch);
                    map.put(ch, map.get(ch) - 1);
                    val--;
                }

                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();

            while(value > 0){
                sb.append(key);
                value--;
            }
        }
        return sb.toString();
    }
}
