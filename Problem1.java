import java.util.HashMap;
import java.util.Map;


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We make a frequency map of the characters in the 's'. Then iterate over the order string
 * and construct the result string using StringBuilder. We keep on reducing the count of
 * that character from the freq. map. When the value becomes 0, we remove it from the map.
 * At last, we just append the remaining keys to the string and return the result string.
 */

public class Problem1 {
    public String customSortString(String order, String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //fill freq. map
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //build the string
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                while(map.get(c) != 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
                map.remove(c);
            }
        }

        //just append the keys in the map with value != 0
        for(char c: map.keySet()) {
            while(map.get(c) != 0) {
                sb.append(c);
                map.put(c, map.get(c) - 1);
            }
        }

        return sb.toString();
    }
}
