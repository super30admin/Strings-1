class Solution {

    /**
     * Sliding window -  2 pointers
     * Map of char and index. if duplicate, move low to duplicate+1.
     * Record current length in max at every iteration.
     * return max in end.
     * TC:O(n)
     * SC:O(1) - only 26 chars - constant
     */
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // duplicate found.
                //record max(do this for all iterations) and move low to duplicate +1
                low = Math.max(low, map.get(c) + 1);
            }
            max = Math.max(max, i - low + 1);
            map.put(c, i);
        }
        return max;
    }
}
