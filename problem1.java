// Time Complexity : O(s.length) because order will be always less than 26
// Space Complexity : O(s.length) for map and sb
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : Add every char of s to the map with its frequency, and according to the order add it. If at end some characters are left, I can add in any order.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (countMap.containsKey(c)) {
                int freq = countMap.get(c);
                while (freq-- > 0) {
                    sb.append(c);
                }
                countMap.remove(c); 
            }
        }
        for (char c : countMap.keySet()) {
            int freq = countMap.get(c);
            while (freq-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
