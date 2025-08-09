// SC: O(1) since limited number of chars (26)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;

        for (end = 0; end < s.length(); ++end) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // do not move the start pointer backwards. very important. If the character is already in the map and if its position 
                // is same as start or after that, then we can shrink the window. Otherwise, we might decrease the start which should never happen. 
                // we must always increase the start and shrink the window.
                if (map.get(c) >= start) {
                    start = map.get(c) + 1;
                }
            }

            map.put(c, end);

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}