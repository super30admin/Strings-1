// Time Complexity : O(n),
// Space Complexity : O(1), since map will store maximum 26 characters
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, max = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
                map.put(ch, i);
            } else {
                map.put(ch, i);
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
// HashSet Implementation
// Time Complexity : O(2n) = O(n), 2n for iterating usng 2 pointers
// Space Complexity : O(1), since set will store maximum 26 characters
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int start = 0, end = 0, size = 1;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (s.charAt(start) != s.charAt(i)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(s.charAt(i));
                end++;
            }
            size = Math.max(size, i - start + 1);
        }
        return size;
    }
}