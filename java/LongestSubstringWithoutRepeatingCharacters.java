// Time Complexity : O(2N) = O(n) 2 pass solution
// Space Complexity : O(1) only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length()) {

            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(s.charAt(i));
            i++;

            max = Math.max(max, set.size());
        }

        return max;
    }
}


Approach 2
// Time Complexity : O(N) one pass solution
// Space Complexity : O(1) only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //update slow
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch));
            }

            //update index
            map.put(ch, i + 1);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}