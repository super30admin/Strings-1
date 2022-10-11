class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
         * TC: O(n) to loop over string
         * SC: O(n) to store each charac of string in HashMap
         */
        if (s.length() == 0 || s == null) return 0;

        // logic HashMap
        int result = 0;
        Map<Character, Integer> map = new HashMap();
        int slow = 0;

        for (int fast=0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch));
            } 
            map.put(ch, fast + 1);
            result = Math.max(result, fast - slow + 1);
        }

        return result;
    }
}
