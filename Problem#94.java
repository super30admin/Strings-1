// Custom Sort String

// Time Complexity : O(m+n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k = 0; k < count; k++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        // Add remaining characters, i.e. characters that are not present in the order string, but present in the s string to the result
        for( Character c : map.keySet()){
            int count = map.get(c);
            for(int i = 0; i < count; i++){
                result.append(c);
            }
        }
        return result.toString();
    }
}