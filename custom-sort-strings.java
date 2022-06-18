import java.util.*;

class Solution {
    // Sliding window with hashmap solution
    // Time complexity is O(n)
    // Space complexity is O(1) // Since 26 characters only
    // This solution is submitted on leetcode with zero errors
    public String customSortString(String order, String s) {
        // Edge case
        if(order.length() == 0 || s.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }
        StringBuilder result = new StringBuilder();
        for(int j = 0; j<order.length();j++){
            char e = order.charAt(j);
            if(map.containsKey(e)) {
                int count = map.get(e);
                for(int k = 0; k<count;k++){
                    result.append(e);
                }
            map.remove(e);
            }
        }
        for(Character c : map.keySet()){
            int count = map.get(c);
            for(int k = 0; k<count;k++){
                result.append(c);
            }
        }
        return result.toString();
    }
}