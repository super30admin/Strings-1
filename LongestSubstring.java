// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use Hashmap to solve this
// We take max and slow
// We check if the character is already in the map, if yes we change the value of slow
// We take the length as max  and put the new index of the character in the map

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int slow = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i + 1);
        }
        return max;
    }
}