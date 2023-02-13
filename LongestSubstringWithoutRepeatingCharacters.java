public class LongestSubstringWithoutRepeatingCharacters {

// Time Complexity : O(2N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class HashsetSolution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            HashSet<Character> set = new HashSet<>();
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    while (s.charAt(start) != c) {
                        set.remove(s.charAt(start));
                        start++;
                    }
                    start++;
                }
                result = Math.max(result, i - start + 1);
                set.add(c);
            }
            return result;
        }
    }

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class HashMapSolution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    start = Math.max(start, map.get(c) + 1);
                }
                result = Math.max(result, i - start + 1);
                map.put(c, i);
            }
            return result;
        }
    }
}
