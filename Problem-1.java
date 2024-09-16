// Time Complexity : O(n) + O(m) + O(n) ~ O(n)
// Space Complexity : O(1) hashMap of 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0;i < order.length(); i ++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                for(int j = 0; j < map.get(c); j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            for(int j = 0; j < map.get(c); j++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}