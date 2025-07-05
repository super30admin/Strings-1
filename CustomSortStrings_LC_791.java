/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Space Complexity - O(m + n)
Time Complexity - O(1) since we have only 26 chars
*/

import java.util.HashMap;
import java.util.Map;

public class CustomSortStrings_LC_791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1);
        }

        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int cnt = map.get(ch);
                for(int k = 0; k < cnt; k++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for(char ch: map.keySet()){
            int cnt = map.get(ch);
            for(int i = 0; i < cnt; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}