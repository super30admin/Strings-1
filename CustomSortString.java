// TC: O (m + n) where m, n are lengths of order and s
// SC: O (1) since we are using a fixed size map of 26 characters

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> sMap = new HashMap<>();
        // compute frequencies of each character in s
        for(char c: s.toCharArray()) {
            sMap.putIfAbsent(c, 0);
            sMap.compute(c, (k, v) -> v + 1);
        }
        StringBuilder result = new StringBuilder();
        // iterate over order
        // append as many copies of each character as needed
        for(char o: order.toCharArray()) {
            if(sMap.containsKey(o)) {
                result.repeat(o, sMap.get(o));
                sMap.remove(o);
            }
        }
        // append any leftover characters not in order
        for(char c: sMap.keySet()) {
            result.repeat(c, sMap.get(c));
        }
        return result.toString();
    }
}

