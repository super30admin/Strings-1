// Time Complexity :  O(m + n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String customSortString(String order, String s) {
        
        if(order == null || order.length() == 0) return s;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        
        for(char ch: order.toCharArray()) {
            
            if(map.containsKey(ch)) {
                for(int i = 0; i < map.get(ch); i++) {
                    result.append(ch);
                }                  
            }

            map.remove(ch);
        }
        
        for(char ch: s.toCharArray()) {
            if(map.containsKey(ch)) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}